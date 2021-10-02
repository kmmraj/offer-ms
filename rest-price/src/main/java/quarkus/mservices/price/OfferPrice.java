package quarkus.mservices.price;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.javamoney.moneta.Money;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.time.Instant;

public class OfferPrice {
    public String id;
    public String offerId;
    public BigDecimal price;
    @JsonbDateFormat("yyyy/MM/dd HH:mm")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;
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
