package org.acme;

import net.gcomputer.webservices.DilbertSoap;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {
    private static final Logger LOGGER = Logger.getLogger(GreetingResource.class.getName());

    @Inject
    private DilbertSoap ws;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String result = null;

        try {
            result = ws.todaysDilbert();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result = "Failure.";
        }

        return (result);
    }
}