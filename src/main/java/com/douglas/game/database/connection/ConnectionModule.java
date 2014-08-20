package com.douglas.game.database.connection;

import com.google.inject.AbstractModule;

/**
 * Guice module for database connectivity.
 */
public class ConnectionModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DatabaseConnection.class).to(ProductionDatabaseConnection.class);
    }
}
