package getlandestate.pages;
import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContactMessageE2EPage {
    public ContactMessageE2EPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "email")
    public WebElement emailBox;
    @FindBy(name = "password")
    public WebElement passwordBox;
    @FindBy(css = "button[type='submit']")
    public WebElement accountLoginButton;
    @FindBy(xpath = "//button[@class='submit-button btn btn-secondary']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginLink;
    @FindBy(xpath = "//span[.='ContactMessages']")
    public WebElement contactMessageLink;
    @FindBy(xpath = "(//div[@class='accordion-item'])[1]")
    public WebElement emailButtonFirst;
    @FindBy(xpath = "(//div[@class='accordion-body']/p)[1]")
    public WebElement messageTextFirst;
}