package com.douglas.game.frontend.server;

import com.douglas.game.Main;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;

/**
 * Configuration setup class.
 */
public class JerseyConfig extends ResourceConfig {
    @Inject
    public JerseyConfig(ServiceLocator serviceLocator) {
        // Find all api endpoints.
        packages("com.douglas.game.frontend.api");

        // Let Jersey and Guice dependency injection talk to each other.
        // Note that even with this Jersey will only use Guice for classes Jersey has no knowledge of.
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Main.getInjector());
    }
}
