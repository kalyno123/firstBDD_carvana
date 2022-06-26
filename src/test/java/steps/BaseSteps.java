package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class BaseSteps {

    // ** BASESTEPS CLASS IS USE TO HOLD ALL THE COMMON SCENARIOS AND GLOBAL REUSED METHODS INSTANCE VARIABLES FOR DIFF FEATURE FILES
    // CUCUMBER READS THE CLASSES IN STEPS PACKAGE AS ONE CLASS ONCE ITS EXECUTED

    WebDriver driver;

    @Before
    public void setup(){
        driver = Driver.getDriver();
    }

    @Given("user is on {string}")
    public void user_is_on(String url){
        driver.get(url);
    }
}
