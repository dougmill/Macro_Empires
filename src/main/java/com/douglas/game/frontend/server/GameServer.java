package com.douglas.game.frontend.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

/**
 * Server that both serves up static content and api responses.
 */
public class GameServer {
    private Server server;

    /**
     * Creates and configures the server, but does not start it running.
     */
    public GameServer() {
        server = new Server(8080);

        // Set root address in the URL that this server will respond to.
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");

        // Set up Jersey and tell it to use JerseyConfig.
        ServletHolder jerseyServletHolder = new ServletHolder(new ServletContainer());
        jerseyServletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
                JerseyConfig.class.getCanonicalName());

        // Set address relative to root above that Jersey will answer api calls on.
        servletContextHandler.addServlet(jerseyServletHolder, "/api/*");

        // Set address relative to root above that static content will be served on.
        servletContextHandler.addServlet(DefaultServlet.class, "/");

        // Set filesystem address relative to project root for where to find static content files.
        servletContextHandler.setResourceBase("src/main/webapp");
    }

    /**
     * Starts the server and blocks until server is shut down.
     *
     * @throws Exception potentially thrown by server.start().
     */
    public void run() throws Exception {
        server.start();
        server.join();
    }
}
