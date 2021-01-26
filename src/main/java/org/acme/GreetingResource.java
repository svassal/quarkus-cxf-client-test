package org.acme;

import com.dataaccess.webservicesserver.TextCasingSoapType;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/hello-resteasy")
public class GreetingResource {
    private static final Logger LOGGER = Logger.getLogger(GreetingResource.class.getName());

    TextCasingSoapType ws = CDI.current().select(TextCasingSoapType.class).get();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String result = null;

        try {
            result = ws.invertStringCase("tEST STRING.");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result = "Failure.";
        }

        return (result);
    }
}