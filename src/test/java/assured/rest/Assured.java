package assured.rest;
import assured.user.Name;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Assured {

    @BeforeAll
    public void setUp() {
        RestAssured.baseURI = "https://fakestoreapi.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void login() {
        int userId = 3;
        assured.user.Name name = given().pathParam("userId", userId).get("/users/{userId}")
                .then().body("id", equalTo(userId))
                .statusCode(200).extract().jsonPath().getObject("name", Name.class);
        Assertions.assertNotNull(name);
        Assertions.assertEquals("ryan", name.getLastname());
    }
}