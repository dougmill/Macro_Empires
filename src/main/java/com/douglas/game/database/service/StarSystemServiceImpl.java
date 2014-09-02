package com.douglas.game.database.service;

import com.douglas.game.database.dao.StarSystemDao;
import com.douglas.game.database.schema.StarSystem;
import com.douglas.game.database.transaction.Transactional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Retrieves information on Systems.
 */
@Singleton
class StarSystemServiceImpl implements StarSystemService {
    private StarSystemDao starSystemDao;

    @Inject
    public StarSystemServiceImpl(StarSystemDao starSystemDao) {
        this.starSystemDao = checkNotNull(starSystemDao);
    }

    /**
     * Gets the list of every System in the database.
     */
    @Transactional
    public List<StarSystem> getAllSystems() {
        return starSystemDao.getAllSystems();
    }
}
