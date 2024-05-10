package cydeo.steps;

import cydeo.utilities.BrowserUtils;
import cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setupMethod(){
        System.out.println("--------- Before Method is Executed ---------");
    }


    @After
    public void teardownMethod(Scenario scenario){

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        BrowserUtils.sleep(2);
        Driver.closeDriver();
        System.out.println("--------- After Method is Executed ---------");

    }

}
