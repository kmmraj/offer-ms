package quarkus.mservices.price;

import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.javamoney.moneta.Money;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.Instant;

@Path("/api/prices")
public class PriceResource {

    @Inject
    Logger logger;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Returns offer prices",
            description = "Price retrieval API")
    public Response getOfferPrice(@FormParam("offer_id") String offerId) {

        OfferPrice offerPrice = new OfferPrice();
        offerPrice.id = RandomStringUtils.random(5, true, true);
        offerPrice.offerId = offerId;
//        CurrencyUnit usd = Monetary.getCurrency("USD");
//        offerPrice.price = Money.of(12, usd);
        offerPrice.price = new BigDecimal("101");
        offerPrice.creationDate = Instant.now();
        return Response.status(201).entity(offerPrice).build();
    }
}