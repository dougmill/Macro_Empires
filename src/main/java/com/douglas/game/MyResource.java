package com.douglas.game;

import com.douglas.game.database.Systems;
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
    public List<Systems> getIt() {
        Session session = Main.getSession();
        session.beginTransaction();
        List result = session.createQuery("from Systems").list();
        session.getTransaction().commit();
        session.close();
        return (List<Systems>)result;
    }
}
