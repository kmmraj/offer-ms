package quarkus.mservices.offer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;

public class Offer {

    public String id;
    public String origin;
    public String destination;
    @JsonbProperty("flight_id")
    public String flightId;
    @JsonbProperty("cabin_class")
    public CabinClassEnum cabinClass;
    @JsonbProperty("travel_date")
    @JsonbDateFormat("yyyy/MM/dd HH:mm")
    public Instant travelDate;

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", flightId='" + flightId + '\'' +
                ", cabinClass=" + cabinClass +
                ", travelDate=" + travelDate +
                '}';
    }
}
