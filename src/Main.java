import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Main {

    public static void main(String[] args) {

        //BaseURL
        RestAssured.baseURI="https://www.google.com";

        //given -- pass request headers, parameters request cookies
        //In this case the headers are empty
        //Headers and cookies are added after third parameter
        //header("hdbf", "dnksn").
        //cookies("hdbf", "dnksn").
        //body("hdbf", "dnksn").
        //when().
        //get(resource)

        given().
                param("location", "-33.8670522, 151.1957362").
                param("radius", "500").
                param("Key", "AIzaSyBBPYG2GzNDwtUtwm3vMFV_CGaSMfUtTa0").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(404).and().contentType(ContentType.JSON).and().
                body("results[0].geometry.location.lat", equalTo("-33.8688197"));




        //header("hdbf", "dnksn").
        //cookies("hdbf", "dnksn").
        //body("hdbf", "dnksn")

    }
}
