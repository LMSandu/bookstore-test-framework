package toolsqa.bookstore.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPOM {

    WebDriver driver;

    public PracticeFormPOM(WebDriver driver){
        this.driver = driver;
    }

    By firstName = By.cssSelector("input[id='firstName']");

    By lastName = By.id("lastName");

    By maleGender = By.xpath("//div/input[@id='gender-radio-1']");

    By sportHobbby = By.cssSelector("input[id='hobbies-checkbox-1']");

    public void setFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void selectMaleGender(){
        driver.findElement(maleGender).click();
    }

    public void selectSportAsHobby(){
        driver.findElement(sportHobbby).click();
    }
}
