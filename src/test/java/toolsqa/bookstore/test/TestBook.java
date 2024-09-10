package toolsqa.bookstore.test;

import org.junit.BeforeClass;
import org.junit.Test;
import toolsqa.bookstore.actions.BookApiActions;
import toolsqa.bookstore.model.BooksList;

public class TestBook {

    private static BookApiActions bookApiActions;

    @BeforeClass
    public static void setup() {
        bookApiActions = new BookApiActions();
    }
//testeaza ca un anumit autor e in lista de carti
    @Test
    public void testGetBooks() {
        BooksList list = bookApiActions.getAllBooks();
//            System.out.println("ha\n"+ list.getBooks().get(0).getAuthor());

    }
}
