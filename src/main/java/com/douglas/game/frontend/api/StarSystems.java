package com.douglas.game.frontend.api;

import com.douglas.game.database.schema.StarSystem;
import com.douglas.game.database.service.StarSystemService;

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
@Path("starsystems")
public class StarSystems {
    private StarSystemService starSystemService;

    @Inject
    public StarSystems(StarSystemService starSystemService) {
        this.starSystemService = checkNotNull(starSystemService);
    }

    /**
     * Gets the list of every System in the database.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StarSystem> getAllSystems() {
        return starSystemService.getAllSystems();
    }
}
