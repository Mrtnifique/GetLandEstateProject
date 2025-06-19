package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
    public ReportPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Most Popular
    @FindBy(xpath = "//span[normalize-space()='MOST POPULAR PROPERTIES']")
    public WebElement mostpopular;




}
