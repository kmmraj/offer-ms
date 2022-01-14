package quarkus.mservices.price;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mock
@RestClient
public class MockOfferProxy implements OfferProxy {
    @Override
    public List<Offer> getOffer() {
        Offer offerOne = new Offer();
//        offerOne.id = RandomStringUtils.random(10, true, true);
        offerOne.id = UUID.randomUUID().toString().substring(0, 8);
        offerOne.cabinClass = CabinClassEnum.BUSINESS;
        offerOne.destination = "PAR";
        offerOne.origin = "AMS";
//        offerOne.flightId = RandomStringUtils.random(5, true, true);
        offerOne.flightId = UUID.randomUUID().toString().substring(0, 5);
        offerOne.travelDate = Instant.now().plus(10, ChronoUnit.DAYS);

//        logger.info(" Offer One is: " + offerOne);
        return Collections.singletonList(offerOne);
    }
}
