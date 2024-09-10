package toolsqa.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Data
public class CreateUserResult {

    String userID;
    String username;
    List<Book> books;

 public CreateUserResult(String username, String userID) {
        this.userID = userID;
        this.username = username;
    }
}
