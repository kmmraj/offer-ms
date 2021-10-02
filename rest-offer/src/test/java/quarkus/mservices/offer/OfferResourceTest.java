package quarkus.mservices.offer;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
public class OfferResourceTest {

    @Test
    public void testOfferMSResponseType() {
        given()
                .when()
                .get("/api/offers")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testOfferMSResponseValue() {
        given()
                .when()
                .get("/api/offers")
                .then()
                .statusCode(200)
                .body("origin", containsInAnyOrder("AMS"))
                .body("travel_date", containsInAnyOrder(startsWith("20")));
    }

}