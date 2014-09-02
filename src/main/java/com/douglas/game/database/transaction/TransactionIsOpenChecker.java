package com.douglas.game.database.transaction;

import com.douglas.game.database.connection.DatabaseConnection;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Method interceptor for {@link SubTransactional} methods that checks that a transaction is already open when they are
 * called.
 */
@Singleton
class TransactionIsOpenChecker implements MethodInterceptor {
    private DatabaseConnection databaseConnection;

    @Inject
    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = checkNotNull(databaseConnection);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (!databaseConnection.getSession().getTransaction().isActive()) {
            throw new IllegalStateException("Database access attempted outside a transaction.");
        }
        return methodInvocation.proceed();
    }
}
