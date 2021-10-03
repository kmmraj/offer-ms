package quarkus.mservices.price;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(configKey = "offer.proxy")
@Path("/api/offers")
public interface OfferProxy {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Offer> getOffer();
}
