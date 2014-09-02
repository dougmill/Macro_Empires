package com.douglas.game.database.transaction;

import com.douglas.game.database.connection.DatabaseConnection;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Method interceptor for {@link Transactional} methods that opens and closes a transaction for them.
 */
@Singleton
class TransactionHandler implements MethodInterceptor {
    private DatabaseConnection databaseConnection;

    @Inject
    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = checkNotNull(databaseConnection);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Session session = null;
        Transaction transaction = null;
        try {
            session = databaseConnection.getSession();
            if (session.getTransaction().isActive()) {
                // Transaction was already begun by an outer @Transactional method, let that one take care of it.
                return methodInvocation.proceed();
            }
            transaction = session.beginTransaction();
            Object retVal = methodInvocation.proceed();
            transaction.commit();
            return retVal;
        }
        catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            if (session != null && session.isOpen()) {
                session.close();
            }
            throw e;
        }
    }
}
