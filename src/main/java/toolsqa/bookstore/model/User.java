package toolsqa.bookstore.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public class User {

    String userName;
    String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User userName1 = (User) o;
        return Objects.equals(userName, userName1.userName) && Objects.equals(password, userName1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(this); //this este obiectul curent
        } catch (JsonProcessingException e) {
            return super.toString(); //super e parintele
        }
        return "";
    }
}
