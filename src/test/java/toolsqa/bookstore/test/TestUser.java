package toolsqa.bookstore.test;

import org.junit.BeforeClass;
import org.junit.Test;
import toolsqa.bookstore.actions.UserApiActions;
import toolsqa.bookstore.model.CreateUserResult;

import java.util.UUID;

public class TestUser {

    private static UserApiActions userApiActions;

    @BeforeClass
    public static void setupTests(){
        userApiActions = new UserApiActions();
    }

    @Test
    public void createUserTest() {
        CreateUserResult newUser = userApiActions.createUserBookstore(
                "Laura" + UUID.randomUUID().toString().replace("-", "").substring(0, 5),
                "Laura123#5");
        System.out.println("Rezultat:\n" + newUser.getUsername());

    }

    @Test
    public void deleteUserTest() {
        userApiActions.deleteUserBookstore("176e141d-d4e8-43d9-816c-baffb7e5c6a3");
    }
}
