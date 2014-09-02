package com.douglas.game.database.service;

import com.google.inject.AbstractModule;

/**
 * Guice module for data manipulation tasks.
 */
public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(StarSystemService.class).to(StarSystemServiceImpl.class);
    }
}
