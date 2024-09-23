package toolsqa.bookstore.test;

import org.junit.BeforeClass;
import org.junit.Test;
import toolsqa.bookstore.actions.BookApiActions;
import toolsqa.bookstore.model.BooksList;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestBook {

    private static BookApiActions bookApiActions;

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
}
