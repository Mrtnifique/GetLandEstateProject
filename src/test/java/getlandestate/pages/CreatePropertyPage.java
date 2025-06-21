package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePropertyPage {
    public CreatePropertyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Common Information
    @FindBy(xpath = "//div[@class='advert-common container']")
    public WebElement commonInfo;

    //Address Information
    @FindBy(xpath = "//div[@class='advert-address  container']")
    public WebElement addressInfo;

    //Properties Section
    @FindBy(xpath = "//div[@class='advert-properties  container']")
    public WebElement propertiesSection;

    //Title Input
    @FindBy(xpath = "//*[@name='title']")
    public WebElement titleInput;

    //Description Warning
    @FindBy(xpath = "//textarea[@name='desc']")
    public WebElement descriptionWarning;

    //AddresWarning
    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressWarning;

    //Address Input
    @FindBy(xpath = "//*[@id='address']")
    public WebElement addressInput;

    //Description Input
    @FindBy(xpath = "//*[@id='desc']")
    public WebElement descriptionInput;

    //Advert Type Dropwdown
    @FindBy(xpath = "//select[@id='advertTypeId']")
    public WebElement advertTypeDropwDown;

    //Price Input
    @FindBy(xpath = "//*[@id='price']")
    public WebElement priceInput;

    //Category Dropwdown
    @FindBy(xpath = "//select[@id='categoryId']")
    public WebElement categoryDropwDown;

    @FindBy(xpath = "//select[@id='countryId']")
    public WebElement countryDropwDown;

    @FindBy(xpath = "//select[@id='cityId']")
    public WebElement cityDropwDown;

    @FindBy(xpath = "//select[@id='districtId']")
    public WebElement districtDropwDown;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadArea;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createAdButton;

    @FindBy(xpath = "//div[@class='image-feedback']")
    public WebElement imageWarning;

    //Create one now butonuna tıklanır
    @FindBy(xpath = "//span[@class='register-link']")
    public WebElement createOneNowButton;

    //Back to Homepage
    @FindBy(xpath = "//a[@title='Back to Site']")
    public WebElement BackToHomePage;

    //Create Property
    @FindBy(xpath = "//a[@class='add-property btn btn-primary']")
    public WebElement CreatePropertyButton;

}


