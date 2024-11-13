package toolsqa.bookstore.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import toolsqa.bookstore.actions.BookApiActions;
import toolsqa.bookstore.actions.UserApiActions;
import toolsqa.bookstore.model.Book;
import toolsqa.bookstore.model.CollectionOfIsbn;
import toolsqa.bookstore.model.UserResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RequiredArgsConstructor
public class UserSteps {

    private static final UserApiActions userApiActions = new UserApiActions();
    private static final BookApiActions bookApiActions = new BookApiActions();
    Response createUserResult;
    String userId;

    //ToDo: add method for verifying that user doesn't already exist and log outcomes using Log4J
    //ToDo: use  password = RandomStringUtils.randomAscii(32); with private password attribute
    @When("I create an user with the following details:")
    public void iCreateUser(List<Map<String, String>> users) {
        if (!users.isEmpty()) {
            users.forEach(user ->
                    {
                        String userName = user.get("userName");
                        String password = user.get("password");

                        createUserResult = userApiActions.createUserBookstore(userName, password);
                        userId = createUserResult.as(UserResult.class).getUserID();
                    }
            );
        }
        else{
            throw new RuntimeException("The users list is empty!");
        }
    }

    @When("Authorization is done for user (.*) with password (.*)$")
    public void userIsAuthorized(String username, String password) {
        Response response = userApiActions.authorizeUser(username, password);
        assertThat("The user is authorized.", response.getStatusCode(), is(HttpStatus.SC_OK));
    }

    @And("A token is generated for user (.*) with password (.*)$")
    public void generateTokenForUser(String username, String password) {
        Response response = userApiActions.generateTokenForUser(username, password);
        assertThat(String.format("The token is generated for user %s.", username), response.getStatusCode(), is(HttpStatus.SC_OK));
    }

    @Then("The user is created")
    public void checkCreationOfUser() {
        assertThat("User was created", createUserResult.getStatusCode(), is(HttpStatus.SC_CREATED));
    }

    @Then("The user was not created")
    public void checkUserNotCreated() {
        assertThat("User was not created", createUserResult.getStatusCode(), is(HttpStatus.SC_NOT_ACCEPTABLE));
    }

    @When("I add the following books for user {}:")
    public void addBookListForUser(String userName, List<String> listOfIsbns) {
        List<CollectionOfIsbn> ListCollectionOfIsbn = listOfIsbns.stream().map(CollectionOfIsbn::new).collect(Collectors.toList());

        Response response = bookApiActions.addListOfBooksForUser(userName, ListCollectionOfIsbn);
        assertThat("The books were added to the user.", response.getStatusCode(), is(HttpStatus.SC_CREATED));
    }

    @Then("I see the books are associated with the user:")
    public void booksAreInListForUser(List<String> listOfIsbns) {
        if (!userId.isEmpty()) {
            List<Book> books = userApiActions.getUserWithBooksInfo(userId).as(UserResult.class).getBooks();
            List<String> allBooksList = new ArrayList<>();
            books.forEach(book -> allBooksList.add(book.getIsbn()));

            assertThat("The books have been added to the user", allBooksList.containsAll(listOfIsbns));
        }
    }
}
