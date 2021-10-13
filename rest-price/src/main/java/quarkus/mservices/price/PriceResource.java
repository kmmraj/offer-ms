package quarkus.mservices.price;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Path("/api/prices")
public class PriceResource {

    @Inject
    Logger logger;

    @Inject
    @RestClient
    OfferProxy offerProxy;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Returns offer prices",
            description = "Price retrieval API")
    @Fallback(fallbackMethod = "fallBack_getOfferPrice")
    @Retry(maxRetries = 3, delay = 3000)
    public Response getOfferPrice(@FormParam("offer_id") String offerId) {

        OfferPrice offerPrice = new OfferPrice();
//        offerPrice.id = RandomStringUtils.random(5, true, true);
        offerPrice.id = UUID.randomUUID().toString().substring(0, 8);;
        Offer offerOne = offerProxy.getOffer().get(0);
        offerPrice.offerId = offerOne.id;
        offerPrice.offer = offerOne;
//        CurrencyUnit usd = Monetary.getCurrency("USD");
//        offerPrice.price = Money.of(12, usd);
        offerPrice.price = new BigDecimal("101");
        offerPrice.creationDate = Instant.now();
        logger.info("OfferPrice Details are: " + offerPrice);
        return Response.status(201).entity(offerPrice).build();


    }

    private Offer getTempOffer() {
        Offer offerOne = new Offer();
        offerOne.cabinClass = CabinClassEnum.BUSINESS;
        offerOne.destination = "PAR";
        offerOne.origin="AMS";
        offerOne.flightId="TBD";
        offerOne.id="TBD";
        return offerOne;
    }

    public Response fallBack_getOfferPrice(@FormParam("offer_id") String offerId) {
        OfferPrice offerPrice = new OfferPrice();
//        offerPrice.id = RandomStringUtils.random(5, true, true);
        offerPrice.id = UUID.randomUUID().toString().substring(0, 5);
        Offer offerOne = getTempOffer();
        offerPrice.offerId = offerOne.id;
        offerPrice.offer = offerOne;
        offerPrice.price = new BigDecimal("101");
        offerPrice.creationDate = Instant.now();
        logger.warn("Temporary OfferPrice Details are: " + offerPrice);
        return Response.status(206).entity(offerPrice).build();

    }
}