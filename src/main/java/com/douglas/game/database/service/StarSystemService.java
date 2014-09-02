package com.douglas.game.database.service;

import com.douglas.game.database.schema.StarSystem;

import java.util.List;

/**
 * Retrieves information on Systems.
 */
public interface StarSystemService {
    /**
     * Gets the list of every System in the database.
     */
    public List<StarSystem> getAllSystems();
}
