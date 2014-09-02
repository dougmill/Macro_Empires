package com.douglas.game.database.dao;

import com.douglas.game.database.schema.StarSystem;

import java.util.List;

/**
 * Data access for System objects.
 */
public interface StarSystemDao {
    public List<StarSystem> getAllSystems();
}
