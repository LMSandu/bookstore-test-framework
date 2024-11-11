package toolsqa.bookstore.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import toolsqa.bookstore.UI.PracticeFormPOM;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestUI {

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LaSandu\\OneDrive - ENDAVA\\Documents\\chromedriver-win64\\chromedriver.exe");
    }

    @Test
    public void testBookstoreTextBox() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement usernameElement = driver.findElement(By.id("userName"));
        boolean isUsernameDisplayed = usernameElement.isDisplayed();
        if (isUsernameDisplayed) {
            usernameElement.clear();
            usernameElement.sendKeys("Laura Sandu");
        }

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        emailElement.sendKeys("lssmm@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Current address here.");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Permanent address here.");

        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void testBookstoreRadioButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();

        driver.findElement(By.id("yesRadio")).click();
        assertThat(driver.findElement(By.id("yesRadio")).isSelected(), is(true));
        assertThat(driver.findElement(By.cssSelector("input[id='impressiveRadio']")).isDisplayed(), is(true));
        assertThat(driver.findElement(By.cssSelector("input[id='noRadio']")).isEnabled(), is(false));


    }

    @Test
    public void testBookstoreDropdown() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();

       WebElement optionsElement = driver.findElement(By.xpath("//div/input[@id='withOptGroup']"));

        Select selectOptions = new Select(optionsElement);
        if (selectOptions.isMultiple()){
            selectOptions.selectByVisibleText("Group 1, option 1");
            assertThat("Group 1, option 1", is(selectOptions.getFirstSelectedOption()));
        }

        WebElement optionsElement2 = driver.findElement(By.xpath("//div/input[@id='selectOne']"));

        Select selectOptions2 = new Select(optionsElement2);
        if (selectOptions2.isMultiple()){
            selectOptions2.selectByIndex(1);
        }


        WebElement optionsElement3 = driver.findElement(By.xpath("//div/input[@id='oldSelectMenu']"));

        Select selectOptions3 = new Select(optionsElement3);
        if (selectOptions3.isMultiple()){
            selectOptions3.selectByValue("red");
        }

    }

    @Test
    public void testUsingPOMClass(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/automation-practice-form");
        PracticeFormPOM practiceFormPOM = new PracticeFormPOM(driver);



        practiceFormPOM.setFirstName("Florin");
        practiceFormPOM.setLastName("Popescu");
        practiceFormPOM.selectMaleGender();
        practiceFormPOM.selectSportAsHobby();

    }
}
