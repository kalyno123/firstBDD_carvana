package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Driver;
import utils.DropDownHandler;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarFinderPage carFinderPage;
    TryCarFinderPage tryCarFinderPage;
    SellTradePage sellTradePage;
    GetYourOfferPage getYourOfferPage;
    LoanCalculatorPage loanCalculatorPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carFinderPage = new CarFinderPage();
        tryCarFinderPage = new TryCarFinderPage();
        sellTradePage = new SellTradePage();
        getYourOfferPage = new GetYourOfferPage();
        loanCalculatorPage = new LoanCalculatorPage();
    }


    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String link) {
        carvanaHomePage.clickOnMenuLink(link);
    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Then("user should see {string} text")
    public void user_should_see_text(String heading) {
        switch (heading){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carFinderPage.heading1.isDisplayed());
                Assert.assertEquals(heading, carFinderPage.heading1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carFinderPage.heading3.isDisplayed());
                Assert.assertEquals(heading, carFinderPage.heading3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(tryCarFinderPage.pageHeadLine.isDisplayed());
                Assert.assertEquals(heading, tryCarFinderPage.pageHeadLine.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(tryCarFinderPage.pageSubHeading.isDisplayed());
                Assert.assertEquals(heading, tryCarFinderPage.pageSubHeading.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(sellTradePage.mainHeading.isDisplayed());
                Assert.assertEquals(heading, sellTradePage.mainHeading.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(sellTradePage.subHeading.isDisplayed());
                Assert.assertEquals(heading, sellTradePage.subHeading.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Assert.assertTrue(getYourOfferPage.errorMsg.isDisplayed());
                Assert.assertEquals(heading, getYourOfferPage.errorMsg.getText());
                break;
            default:
                throw new NotFoundException("The heading is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see {string} link")
    public void user_should_see_link(String link) {
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isEnabled());
        Assert.assertEquals(link, carFinderPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String link) {
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isEnabled());
        carFinderPage.tryCarFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        Assert.assertTrue(sellTradePage.vinButton.isDisplayed());
        Assert.assertTrue(sellTradePage.vinButton.isEnabled());
        sellTradePage.vinButton.click();
    }

    @When("user enters vin number as {string}")
    public void user_enters_vin_number_as(String keys) {
        sellTradePage.vinInputBox.sendKeys(keys);
    }

    @When("user hovers over on {string} menu item")
    public void user_hovers_over_on_menu_item(String string) {
       // ActionsUtil.moveToElement(carvanaHomePage.financingMenuLinks);
    }

    @When("user enters {string} as {string}")
    public void user_enters_as(String inputType, String keys) {
        switch (inputType){
            case "Cost of Car I want":
                loanCalculatorPage.priceInputBox.sendKeys(keys);
                break;
            case "What is Your Down Payment?":
                loanCalculatorPage.downPaymentInputBox.sendKeys(keys);
                break;
            default:
                throw new NotFoundException("The input box is not defined properly in the feature file!!!");
        }
    }

    @When("user selects {string} as {string}")
    public void user_selects_as(String dropDown, String option) {
        switch (dropDown){
            case "What’s Your credit Score?":
                DropDownHandler.selectOptionByVisibleText(loanCalculatorPage.creditScoreDropDown, option);
                break;
            case "Choose Your Loan Terms":
                DropDownHandler.selectOptionByVisibleText(loanCalculatorPage.loanTermDropDown, option);
                break;
            default:
                throw new NotFoundException("The drop down menu is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void user_should_see_the_monthly_payment_as(String string) {
        
    }
}
