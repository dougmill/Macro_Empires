package com.douglas.game.database.connection;

import org.hibernate.Session;

/**
 * Injectable source of Hibernate Sessions.
 */
public interface DatabaseConnection {
    public Session getSession();
}
