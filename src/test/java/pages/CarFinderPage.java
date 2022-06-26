package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarFinderPage {

    public CarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class='leftSide']>h1")
    public WebElement heading1;

    @FindBy (css = "h3[role='presentation']")
    public WebElement heading3;

    @FindBy (css = "a[data-qa='router-link']")
    public WebElement tryCarFinderLink;

}
