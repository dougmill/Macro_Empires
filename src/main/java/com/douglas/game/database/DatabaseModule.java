package com.douglas.game.database;

import com.douglas.game.database.connection.ConnectionModule;
import com.douglas.game.database.dao.DaoModule;
import com.douglas.game.database.service.ServiceModule;
import com.douglas.game.database.transaction.TransactionModule;
import com.google.inject.AbstractModule;

/**
 * Guice module for general database interactions.
 */
public class DatabaseModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ConnectionModule());
        install(new DaoModule());
        install(new ServiceModule());
        install(new TransactionModule());
    }
}
