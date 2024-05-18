package cydeo.pages;

import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PracticePage {


    public PracticePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameEl;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordEl;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement successMessage;

    public void clickLink(String text) {

        Driver.getDriver().findElement(By.linkText(text)).click();

    }

    public void login() {
        // ENV VARIABLE ?

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        usernameEl.sendKeys(username);
        passwordEl.sendKeys(password);
        loginButton.click();



    }

}
