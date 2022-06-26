package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaHomePage{

    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "div[data-qa='header-items']>a")
    public List<WebElement> mainMenuItemLinks; // 3

    @FindBy (css = "div[class*='HeaderFinancingstyles__StyledDropDown']>a")
    public List<WebElement> financingMenuLinks; // 3

    public void clickOnMenuLink(String linkText){
        for(WebElement link : mainMenuItemLinks){
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }

    public void clickOnFinanceLink(String linkText){
        for(WebElement link : financingMenuLinks){
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }


}
