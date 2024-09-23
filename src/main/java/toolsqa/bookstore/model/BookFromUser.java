package toolsqa.bookstore.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookFromUser {

    String isbn;
    String userId;

    public BookFromUser(String isbn, String userId) {
        this.isbn = isbn;
        this.userId = userId;
    }
}
