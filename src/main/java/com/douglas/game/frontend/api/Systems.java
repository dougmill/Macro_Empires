package com.douglas.game.frontend.api;

import com.douglas.game.database.schema.System;
import com.douglas.game.database.service.SystemService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * API point for requesting information on Systems.
 */
@Path("systems")
public class Systems {
    private SystemService systemService;

    @Inject
    public Systems(SystemService systemService) {
        this.systemService = checkNotNull(systemService);
    }

    /**
     * Gets the list of every System in the database.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<System> getAllSystems() {
        return systemService.getAllSystems();
    }
}
