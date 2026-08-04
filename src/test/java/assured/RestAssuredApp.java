package assured;
import assured.models.Rating;
import assured.models.Response;
import assured.models.ResponseItem;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class RestAssuredApp {

    @Test
    void getAllUsersTest() {
        Rating rating = Rating.builder().rate("Casino").count(100).build();

        ResponseItem responseItem = ResponseItem.builder()
                .rating(rating)
                .id(1)
                .price(100)
                .image("Space")
                .category("HD' Led samsung G45")
                .description("China").build();

        List<ResponseItem> responseItems = new ArrayList<>();
        responseItem.setCategory(responseItem.getCategory());
        responseItem.setDescription(responseItem.getDescription());
        responseItem.setId(responseItem.getId());
        responseItem.setPrice(responseItem.getPrice());
        responseItem.setImage(responseItem.getImage());
        responseItems.add(responseItem);
        Response response = Response.builder().response(responseItems).build();
        given().body(response)
                .post("https://fakestoreapi.com/products")
                .then()
                .log()
                .all()
                .statusCode(201);
    }

    private ResponseItem responseItem() {
        return ResponseItem.builder()
                .id(1)
                .price(500)
                .image("Cactus")
                .description("USA")
                .title("pomidor")
                .category("Samsung galaxy s23 ultra")
                .build();
    }

    @Test
    public void updateItemTest() {
        ResponseItem responseItem = responseItem();
        responseItem.setPrice(450);
        given().body(responseItem).put("https://fakestoreapi.com/products/" + responseItem.getId())
                .then().log().all().body("price", not(equalTo(responseItem.getPrice()))).statusCode(200);
    }
    @Test
    public void authUserTest() {
        Map<String, String> response = new HashMap<>();
        response.put("username", "bobic");
        response.put("email", "bobic@gmail.com");
        response.put("password", "788888");
        given().contentType(ContentType.JSON).body(response)
                .post("https://fakestoreapi.com/users")
                .then().log().all().statusCode(201)
                .body("password", not(equalTo(response.get("password"))));
    }
}