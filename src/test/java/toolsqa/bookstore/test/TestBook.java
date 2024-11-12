package toolsqa.bookstore.test;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import toolsqa.bookstore.actions.BookApiActions;
import toolsqa.bookstore.model.Book;
import toolsqa.bookstore.model.BooksList;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestBook {

    private static BookApiActions bookApiActions;

    private static final Logger log = LogManager.getLogger();

    @BeforeClass
    public static void setup() {
        bookApiActions = new BookApiActions();
    }

    public void isAuthorPresent(String author, boolean expectedResult) {
        BooksList list = bookApiActions.getAllBooks();
        List<String> authorNames = new ArrayList<>();

        for (int i = 0; i < list.getBooks().size(); i++) {
            authorNames.add(list.getBooks().get(i).getAuthor());
        }
        assertThat(format("Author %s can be found in the bookstore", author), authorNames.contains(author), is(expectedResult));
    }

    @Test
    public void test() {
//        isAuthorPresent("Laura", false);
//        isAuthorPresent("Richard E. Silverman", true);
//
//        List<CollectionOfIsbn> collectionOfIsbns = new ArrayList<>();
//        collectionOfIsbns.add(new CollectionOfIsbn("9781491904244"));
//
//        bookApiActions.addListOfBooksForUser("Lauradaef0", collectionOfIsbns);

//        bookApiActions.deteleBookFromUser("9781491904244","Lauradaef0");


    }

    @Test
    public void deserializeJsonAsList() {

        Response response = given().baseUri("https://demoqa.com/BookStore/v1/Books")
                .log().all()
                .get();

        List<String> books = response.jsonPath().getList("books.title");

        int booksNumber = 0;
        for (String book : books) {
            log.info("Book: {}", book);
            booksNumber++;
        }
        log.info("\nThe number of books in this store is {}", booksNumber);

    }

    @Test
    public void deserializeJsonAsArray() {

        Response response = given().baseUri("https://demoqa.com/BookStore/v1/Books")
                .log().all()
                .get();

        Book[] books = response.jsonPath().getObject("books", Book[].class);

        int authorNumber = 0;

        for (Book book : books) {
            log.info("Author: {}", book.getAuthor());
            authorNumber++;
        }
        log.info("The number of authors in this bookstore is {}", authorNumber);
    }
}
