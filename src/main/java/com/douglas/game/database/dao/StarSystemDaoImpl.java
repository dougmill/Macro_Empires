package com.douglas.game.database.dao;

import com.douglas.game.database.connection.DatabaseConnection;
import com.douglas.game.database.schema.StarSystem;
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
class StarSystemDaoImpl implements StarSystemDao {
    private DatabaseConnection databaseConnection;

    @Inject
    public StarSystemDaoImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = checkNotNull(databaseConnection);
    }

    @SubTransactional
    @Override
    public List<StarSystem> getAllSystems() {
        Session session = databaseConnection.getSession();

        // Hibernate will always return only StarSystem objects from this query.
        @SuppressWarnings("unchecked")
        List<StarSystem> result = (List<StarSystem>)session.createQuery("from Star_Systems").list();
        return result;
    }
}
