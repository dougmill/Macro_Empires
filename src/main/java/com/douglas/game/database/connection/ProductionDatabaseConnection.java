package com.douglas.game.database.connection;

import com.google.inject.Singleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Opens the production database file and provides sessions connected to it.
 */
@Singleton
class ProductionDatabaseConnection implements DatabaseConnection {
    private final SessionFactory sessionFactory;

    public ProductionDatabaseConnection() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.setProperty("hibernate.connection.url",
                    "jdbc:h2:file:" + System.getProperty("user.dir") + "/src/main/resources/Macro_Empires");

            ServiceRegistry serviceRegistry =
                    new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
