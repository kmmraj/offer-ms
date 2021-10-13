package quarkus.mservices.offer;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Path("/api/offers")
@Tag(name = "Resource for Offer APIs")
@Schema(description = "OfferResource API")
public class OfferResource {

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Returns offers",
            description = "Offer retrieval API")
    public List<Offer> getOffers() {

        Offer offerOne = new Offer();
//        offerOne.id = RandomStringUtils.random(10, true, true);
        offerOne.id = UUID.randomUUID().toString().substring(0, 8);
        offerOne.cabinClass = CabinClassEnum.BUSINESS;
        offerOne.destination = "PAR";
        offerOne.origin = "AMS";
//        offerOne.flightId = RandomStringUtils.random(5, true, true);
        offerOne.flightId = UUID.randomUUID().toString().substring(0, 5);
        offerOne.travelDate = Instant.now().plus(10, ChronoUnit.DAYS);

        logger.info(" Offer One is: " + offerOne);
        return Collections.singletonList(offerOne);
    }
}