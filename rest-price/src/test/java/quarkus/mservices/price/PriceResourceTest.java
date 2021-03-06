package quarkus.mservices.price;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

@QuarkusTest
class PriceResourceTest {

    @Test
    void testGetPrices() {

        given()
                .when()
                .post("/api/prices")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON);
    }

}