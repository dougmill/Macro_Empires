package com.douglas.game.database.dao;

import com.douglas.game.database.connection.DatabaseConnection;
import com.douglas.game.database.schema.System;
import com.douglas.game.database.transaction.SubTransactional;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.hibernate.Session;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Data access for System objects.
 */
@Singleton
public class SystemDao {
    private DatabaseConnection databaseConnection;

    @Inject
    public SystemDao(DatabaseConnection databaseConnection) {
        this.databaseConnection = checkNotNull(databaseConnection);
    }

    @SubTransactional
    public List<System> getAllSystems() {
        Session session = databaseConnection.getSession();
        List result = session.createQuery("from Systems").list();
        return (List<System>)result;
    }
}
