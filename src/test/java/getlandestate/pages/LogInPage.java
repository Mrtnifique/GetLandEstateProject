package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Email Box
    @FindBy(name = "email")
    public WebElement emailBox;

    //Password Box
    @FindBy(name = "password")
    public WebElement passwordBox;

    //Login Button
    @FindBy(xpath = "//button[contains(@class,'submit-button btn')]")
    public WebElement loginButton;

    //Register button
    @FindBy(xpath = "//a[@data-rr-ui-event-key='6']")
    public WebElement registerButtonunaDaxilOlmali;
}
