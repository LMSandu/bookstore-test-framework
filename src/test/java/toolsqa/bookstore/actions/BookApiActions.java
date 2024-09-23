package toolsqa.bookstore.actions;

import groovy.util.logging.Log4j;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import toolsqa.bookstore.model.BooksList;
import toolsqa.bookstore.model.CollectionOfIsbn;
import toolsqa.bookstore.model.ListOfBooksInfo;
import toolsqa.bookstore.model.BookFromUser;

import java.util.List;

import static io.restassured.RestAssured.given;

@Log4j
@RequiredArgsConstructor
public class BookApiActions {

    RequestSpecification booksBaseUri = given().baseUri("https://demoqa.com/BookStore/v1/Books");
    RequestSpecification bookBaseUri = given().baseUri("https://demoqa.com/BookStore/v1/Book");

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

    public Response addListOfBooksForUser(String username, List<CollectionOfIsbn> collectionOfIsbns) {
        ListOfBooksInfo listOfBooksforUser = new ListOfBooksInfo(username, collectionOfIsbns);
        return booksBaseUri
                .contentType(ContentType.JSON)
                .body(listOfBooksforUser)
                .log().all()
                .when().post()
                .prettyPeek();
    }

    public void deteleBookFromUser(String isbn, String userId) {
        BookFromUser bookFromUser = new BookFromUser(isbn, userId);
        bookBaseUri.contentType(ContentType.JSON)
                .body(bookFromUser)
                .log().all()
                .when().delete()
                .then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}