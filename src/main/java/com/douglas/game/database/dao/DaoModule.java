package com.douglas.game.database.dao;

import com.google.inject.AbstractModule;

/**
 * Guice module for data access objects.
 */
public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(StarSystemDao.class).to(StarSystemDaoImpl.class);
    }
}
