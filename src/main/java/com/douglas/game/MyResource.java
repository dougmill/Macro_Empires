package com.douglas.game;

import com.douglas.game.database.System;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<System> getIt() {
        Session session = Main.getSession();
        session.beginTransaction();
        System[] systems = new System[3];
        systems[0] = new System();
        systems[0].setxCoord(1);
        systems[0].setyCoord(2);
        systems[1] = new System();
        systems[1].setxCoord(3);
        systems[1].setyCoord(2);
        systems[2] = new System();
        systems[2].setxCoord(4);
        systems[2].setyCoord(6);
        session.save(systems[0]);
        session.save(systems[1]);
        session.save(systems[2]);
        List result = session.createQuery("from Systems").list();
        session.getTransaction().commit();
        session.close();
        return (List<com.douglas.game.database.System>)result;
    }
}
