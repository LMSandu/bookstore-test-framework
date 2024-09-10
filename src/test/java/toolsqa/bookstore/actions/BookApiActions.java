package toolsqa.bookstore.actions;

import groovy.util.logging.Log4j;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import toolsqa.bookstore.model.BooksList;

import static io.restassured.RestAssured.given;

@Log4j
@RequiredArgsConstructor
public class BookApiActions {

    RequestSpecification booksBaseUri = given().baseUri("http://demoqa.com/BookStore/v1/Books");

    public BooksList getAllBooks() {
        Response getBooksResponse = booksBaseUri.log().all()
                .when().get("")
                .prettyPeek();
        if (getBooksResponse.statusCode() == HttpStatus.SC_OK) {
            return getBooksResponse.as(BooksList.class);
        } else {
            return null;
        }

    }
}
