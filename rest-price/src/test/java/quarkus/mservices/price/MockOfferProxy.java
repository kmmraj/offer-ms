package quarkus.mservices.price;

import io.quarkus.test.Mock;
import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Mock
@RestClient
public class MockOfferProxy implements OfferProxy{
    @Override
    public List<Offer> getOffer() {
        Offer offerOne = new Offer();
        offerOne.id = RandomStringUtils.random(10, true, true);
        offerOne.cabinClass = CabinClassEnum.BUSINESS;
        offerOne.destination = "PAR";
        offerOne.origin = "AMS";
        offerOne.flightId = RandomStringUtils.random(5, true, true);
        offerOne.travelDate = Instant.now().plus(10, ChronoUnit.DAYS);

//        logger.info(" Offer One is: " + offerOne);
        return Collections.singletonList(offerOne);
    }
}
