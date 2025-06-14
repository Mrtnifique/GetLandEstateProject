package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[contains(@class,'submit-button btn')]")
    public WebElement loginButton;
}
