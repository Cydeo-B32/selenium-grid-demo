package cydeo.steps;


import cydeo.pages.PracticePage;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class StepDefs {
    PracticePage practicePage=new PracticePage();
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("practice_url"));
        BrowserUtils.waitFor(3);
    }
    @When("I clicked {string} page")
    public void i_clicked_page(String pageText) {
       practicePage.clickLink(pageText);
    }
    @When("I fill the form with valid credentails")
    public void i_fill_the_form_with_valid_credentails() {

        practicePage.login();

    }
    @Then("I should see {string} message")
    public void i_should_see_message(String expectedSuccessMessage) {

        String actualSuccessMessage = practicePage.successMessage.getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
    }

    @Then("I should see page title as {string}")
    public void i_should_see_page_title_as(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
