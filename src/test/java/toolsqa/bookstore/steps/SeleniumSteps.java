package toolsqa.bookstore.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumSteps {
    public WebDriver driver;

    @Given("The path to the driver is set$")
    public void setDriverPath() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LaSandu\\OneDrive - ENDAVA\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^User is on Home page$")
    public void user_is_on_Home_Page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.demoqa.com/books");
    }

    @When("^User navigates to Login page$")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='item-0']/a")).click();
    }

    @When("^User enters username and password$")
    public void user_enters_UserName_and_Password() {
        driver.findElement(By.id("log")).sendKeys("testuser_1");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
    }
}
