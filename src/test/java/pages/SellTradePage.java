package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SellTradePage {

    public SellTradePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "div[class*='sc-4ef54ea5-6']")
    public WebElement mainHeading;

    @FindBy (css = "div[class*='sc-4ef54ea5-17']")
    public WebElement subHeading;

    @FindBy (css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy (css = "input[class*='FormInput-oo6j68-5']")
    public WebElement vinInputBox;

    @FindBy (css = "button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getYourOfferButton;
}
