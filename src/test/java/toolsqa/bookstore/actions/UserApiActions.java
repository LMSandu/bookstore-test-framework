package toolsqa.bookstore.actions;

import groovy.util.logging.Log4j;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import toolsqa.bookstore.model.CreateUserResult;
import toolsqa.bookstore.model.User;

import static io.restassured.RestAssured.given;

@Log4j
@RequiredArgsConstructor
public class UserApiActions {

    RequestSpecification userBaseUri = given().baseUri("https://demoqa.com");


    public CreateUserResult createUserBookstore(String userName, String password) {

        User user = new User(userName, password);
        Response creationResult = userBaseUri
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when().post("/Account/v1/User").prettyPeek();

        if (creationResult.statusCode() == HttpStatus.SC_CREATED) {
            return creationResult.as(CreateUserResult.class);
        } else {
            return null;
        }
    }

    public void deleteUserBookstore(String userId) {
        String url = "/Account/v1/User/" + userId;
        userBaseUri.log().all().when().delete(url).prettyPeek().then().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

}