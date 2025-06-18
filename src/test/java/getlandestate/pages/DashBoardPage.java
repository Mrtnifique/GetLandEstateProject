package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Login Button
    @FindBy(linkText = "Login")
    public WebElement loginButton;

    //Search Box
    @FindBy(xpath = "//button[@class='btn btn-primary']//*[name()='svg']")
    public WebElement searchBox;

    //Filter Page
    @FindBy(xpath = "//select[@id='c']")
    public WebElement categoryFilter;

    //Country Filter
    @FindBy(xpath = "//select[@id='ctry']")
    public WebElement countryFilter;

    //City Filter
    @FindBy(xpath = "//select[@id='city']")
    public WebElement cityFilter;

    //District Filter
    @FindBy(xpath = "//select[@id='dist']")
    public WebElement districtFilter;

    //Filter Search Button
    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement filterSearchButton;

    //House Displayed
    @FindBy(xpath = "//img[@alt='Scenic_Spacious_Garden_House']")
    public WebElement houseDisplayed;

    //House Click
    @FindBy(xpath = "//img[@alt='Scenic_Spacious_Garden_House']")
    public WebElement houseClick;

    //Contact Number Eyes Button
    @FindBy(xpath = "//div[contains(@class,'advert-details-owner-phone')]//button[2]")
    public WebElement contactNumberEyesButton;

    //Contact Alert
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement contactAlert;

    //Contact Alert Close Button
    @FindBy(xpath = "//button[@class='close-button btn btn-primary']//*[name()='svg']")
    public WebElement contactAlertCloseButton;

    //Tour Date
    @FindBy(xpath = "//input[@id='tourDate']")
    public WebElement tourDate;

    //Tour Time
    @FindBy(xpath = "//select[@id='tourTime']")
    public WebElement tourTime;

    //Submit Tour Request Button
    @FindBy(xpath = "//div[@class='tour-request-form-button-wrapper']")
    public WebElement submitTourRequestButton;

    //Contact Alert
    @FindBy(xpath = "//div[@class='auth-modal-body modal-body']")
    public WebElement contactAlert2;

    //Create one now butonuna tıklanır
    @FindBy(xpath = "//span[@class='register-link']")
    public WebElement createOneNowButton;


    //Tour date is required
    @FindBy(xpath = "//div[normalize-space()='Tour date is required']")
    public WebElement tourDateIsRequired;

    //Tour time is required
    @FindBy(xpath = "//div[normalize-space()='Tour time is required']")
    public WebElement tourTimeIsRequired;


    // Contact
    @FindBy(xpath= "//*[@id='offcanvas-menu']/div[2]/div[1]/a[4]")
    public WebElement contact;

    // Contact FirstName
    @FindBy(xpath= "//*[@id='firstName']")
    public WebElement firstName;

    // Contact Lastname
    @FindBy(xpath= "//*[@id='lastName']")
    public WebElement lastName;

    // Contact email
    @FindBy(xpath= "//*[@id='email']")
    public WebElement  email;

    // Contact message
    @FindBy(xpath= "//*[@id='message']")
    public WebElement message;

    // Contact Submit Button
    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitButton;

    // Contact Submit Button negatif
    @FindBy(xpath= "//button[@type='submit']")
    public WebElement submitButton01;

    // Contact Firstname warning
    @FindBy(xpath= "//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[1]/div")
    public WebElement firstNameWarning;

    // Contact Lastname warning
    @FindBy(xpath= "//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[2]/div")
    public WebElement lastNameWarning;

    // Contact required email warning
    @FindBy(xpath="//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[3]/div")
    public WebElement requiredEmailWarning;

    //Contact invalid email warning
    @FindBy(xpath= "//*[@id='root']/div[1]/div/div[3]/div[2]/div[1]/div/form/div[3]/div")
    public WebElement invalidEmailWarning;

    // Contact success Message
    @FindBy(xpath= "//div[@class='p-toast-detail']")
    public WebElement successMessage;



    //Seval Aslan  baslangic 140



































































































    //Seval Aslan  bitis 240

    // Ayhan Togan baslangic 242










































































    // Ayhan Togan bitis 317

    //Merve Subas baslangic 319










































































    //Merve Subas bitis 394

    //Ruhin Bey baslangic 396













































































    //Ruhin Bey bitis 474

    //Sumeyye Niyet baslangic 476

































































    //Sumeyye Niyet bitis 542

    //Pinar Yuzer baslangic 544










































































    //Pinar Yuzer bitis 619

    //Semih Oner baslangic 621







































































    //Semih Oner bitis 693

    //Emine Gurses baslangic 695










































































    //Emine Gurses bitis 770

    //Selin Onal baslangic 772








































































    //Selin Onal bitis 845

    //Rezzan Erva Odabaşı 847



































































    //Rezzan Erva Odabaşı bitis 915

    //Emine Arı Baslangıc 917








































































    //Emine Arı bitis 990

    //Fatih Üstünyer baslangic 992










































































    //Fatih Üstünyer bitis 1067

}
