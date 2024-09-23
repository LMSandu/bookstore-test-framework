package toolsqa.bookstore.actions;

import groovy.util.logging.Log4j;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import toolsqa.bookstore.model.UserResult;
import toolsqa.bookstore.model.User;

import static io.restassured.RestAssured.given;

@Log4j
@RequiredArgsConstructor
public class UserApiActions {

    RequestSpecification userBaseUri = given().baseUri("https://demoqa.com");


    public Response createUserBookstore(String userName, String password) {

        User user = new User(userName, password);
        return userBaseUri
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when().post("/Account/v1/User").prettyPeek();

    }

    public void deleteUserBookstore(String userId) {
        String url = "/Account/v1/User/" + userId;
        userBaseUri.log().all().when().delete(url).prettyPeek().then().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    public Response getUserWithBooksInfo(String userId){

        return userBaseUri.queryParam("userId", userId)
                .log().all()
                .when().get("/Account/v1/User/}")
                .prettyPeek();
    }

}
