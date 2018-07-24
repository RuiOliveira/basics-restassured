package googlemaps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Basics2 {

    @Test
    public void postData() {

        //body("put resquest json format")

        RestAssured.baseURI="https://www.google.com";

        given().

                queryParam("key", "AIzaSyBBPYG2GzNDwtUtwm3vMFV_CGaSMfUtTa0").
                body("{name: \"Test\"}").
                when().
                post("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(404).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));

        //Create a place = response (place id)


        //and delete place = request - place id)

        //E2E test

    }
}
