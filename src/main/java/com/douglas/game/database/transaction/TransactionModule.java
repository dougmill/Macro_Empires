package com.douglas.game.database.transaction;

import com.douglas.game.database.connection.DatabaseConnection;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * Guice module for transaction demarcation.
 */
public class TransactionModule extends AbstractModule {
    @Override
    protected void configure() {
        TransactionHandler handler = new TransactionHandler();
        requestInjection(handler);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), handler);

        TransactionIsOpenChecker checker = new TransactionIsOpenChecker();
        requestInjection(checker);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(SubTransactional.class), checker);

        requireBinding(DatabaseConnection.class);
    }
}
