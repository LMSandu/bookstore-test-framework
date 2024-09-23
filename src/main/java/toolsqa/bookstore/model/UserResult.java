package toolsqa.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Data
public class UserResult {

    String userID;
    String username;
    List<Book> books;

    public UserResult(String username, String userID) {
        this.userID = userID;
        this.username = username;
    }
}
