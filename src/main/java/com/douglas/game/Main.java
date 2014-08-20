package com.douglas.game;

import com.douglas.game.database.DatabaseModule;
import com.douglas.game.frontend.server.GameServer;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Main class.
 */
public class Main {
    private static Injector injector;

    /**
     * Needed for the Jersey-Guice bridge.
     */
    public static Injector getInjector() {
        return injector;
    }

    public static void main(String[] args) throws Exception {
        injector = Guice.createInjector(
                new DatabaseModule());

        GameServer server = new GameServer();
        server.run();
    }
}
