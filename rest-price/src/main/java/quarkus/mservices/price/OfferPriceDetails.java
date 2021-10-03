package quarkus.mservices.price;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.time.Instant;

public class OfferPriceDetails {
    public String id;
    public String offerId;
    public BigDecimal price;
    @JsonbDateFormat("yyyy/MM/dd HH:mm")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;
    public Offer offer;
//    public Money price;


    @Override
    public String toString() {
        return "OfferPrice{" +
                "id='" + id + '\'' +
                ", offerId='" + offerId + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                '}';
    }
}
