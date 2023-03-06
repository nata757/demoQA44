
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    public final String BASE_URI = "https://reqres.in";

    @Test
    public void getListUsers() {
        Response response = given()
                .when()
                .baseUri(BASE_URI)
                .log().all()
                .get("/api/users?page=2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("per_page"), 6);
        Assert.assertEquals(response.jsonPath().getString("data[2].email"), "tobias.funke@reqres.in");
        Assert.assertEquals(response.jsonPath().getString("data[4].first_name"), "George");
    }

   @Test
    public void getListUser_2(){
       given()
               .when()
               .baseUri(BASE_URI)
               .log().all()
               .get("/api/users?page=2")
               .then()
               .log().all()
               .assertThat()
               .statusCode(200)
               .body("per_page", Matchers.equalTo(6))
               .body("data[2].email", Matchers.equalTo("tobias.funke@reqres.in"));

   }
   @Test
    public void createUser() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
       Response response = given()
               .body(body)
               .when()
               .baseUri(BASE_URI)
               .log().all()
               .post("/api/users")
               .then()
               .log().all()
               .assertThat()
               .statusCode(201)
               .extract().response();

       Assert.assertEquals(response.jsonPath().getString("name"), "morpheus");




   }

}
