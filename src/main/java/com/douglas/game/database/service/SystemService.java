package com.douglas.game.database.service;

import com.douglas.game.database.dao.SystemDao;
import com.douglas.game.database.schema.System;
import com.douglas.game.database.transaction.Transactional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Retrieves information on Systems.
 */
@Singleton
public class SystemService {
    private SystemDao systemDao;

    @Inject
    public SystemService(SystemDao systemDao) {
        this.systemDao = checkNotNull(systemDao);
    }

    /**
     * Gets the list of every System in the database.
     */
    @Transactional
    public List<System> getAllSystems() {
        return systemDao.getAllSystems();
    }
}
