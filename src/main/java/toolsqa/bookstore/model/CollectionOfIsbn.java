package toolsqa.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Data
public class CollectionOfIsbn {
    String isbn;

    public CollectionOfIsbn(String isbn){
        this.isbn = isbn;    }
}
