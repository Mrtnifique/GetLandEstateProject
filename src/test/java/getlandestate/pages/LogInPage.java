package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.By;
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



    //Seval Aslan  baslangic 26
    //Register Button
    @FindBy(xpath = "//a[normalize-space()='Register']")
    public WebElement goTologInPage;

    //First Name Input Box
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameBox;

    //First Name Warning Message
    @FindBy(xpath = "//div[contains(text(),'First name is required')]")
    public WebElement isFirstNameWarningDisplayed;

    //Last Name Input Box
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameBox;

    //Last Name Warning Message
    @FindBy(xpath = "//div[contains(text(),'Last name is required')]")
    public WebElement isLastNameWarningDisplayed;

    //Phone Number Input Box
    @FindBy(name = "phone")
    public WebElement phoneNumberBox;

    //Phone Number Warning Message
    @FindBy(xpath = "//div[contains(text(),'Phone is required')]")
    public WebElement isPhoneWarningDisplayed;

    //invalid phone number
    @FindBy(xpath = "//div[contains(text(),'Invalid phone number')]")
    public WebElement invalidPhoneNumber;

    //E-mail Input Box
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailBox1;

    //Email Warning Message invalid email
    @FindBy(xpath = "//div[contains(text(),'Invalid email')]")
    public WebElement isEmailWarningDisplayed;

    //Email Warning Message email is required
    @FindBy(xpath = "//div[contains(text(),'Email is required')]")
    public WebElement isEmailRequiredWarningDisplayed;

    //Email Warning Message email is required
    @FindBy(xpath = "//div[contains(text(),'Invalid email')]")
    public WebElement invalidEmail;

    //Password Input Box
    @FindBy(xpath = "//div[contains(text(),'Password is required')]")
    public WebElement isPasswordWarningDisplayed;

    //Is Weak Password Warning Message
    @FindBy(xpath = "//div[contains(text(),'At least 8 characters')]")
    public WebElement isWeakPasswordWarningDisplayed;

    //Confirm Password Input Box
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    public WebElement confirmPasswordBox;

    //Confirm Password Warning Message must match
    @FindBy(xpath = "//div[contains(text(),'Passwords must match')]")
    public WebElement confirmPasswordMustMatchWarningDisplayed;

    //I understand and agree button
    @FindBy(xpath = "//input[@id='terms']")
    public WebElement iUnderstandAndAgreeButton;

    //Register Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;

    //Register Success Message
    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement successMessage;




















    //Seval Aslan  bitis 126

    //Ayhan Togan baslangic 128










































































    //Ayhan Togan bitis 203

    //Merve Subas baslangic 205










































































    //Merve Subas bitis 280

    //Ruhin Bey baslangic 282













































































    //Ruhin Bey bitis 360

    //Sumeyye Niyet baslangic 362

































































    //Sumeyye Niyet bitis 428

    //Pinar Yuzer baslangic 430

    //login button
    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginButton1;








































































    //Pinar Yuzer bitis 505

    //Semih Oner baslangic 507







































































    //Semih Oner bitis 579

    //Emine Gurses baslangic 581










































































    //Emine Gurses bitis 656

    //Selin Onal baslangic 658








































































    //Selin Onal bitis 731

    //Rezzan Erva Odabaşı 733



































































    //Rezzan Erva Odabaşı bitis 801

    //Emine Arı Baslangıc 803








































































    //Emine Arı bitis 876

    //Fatih Üstünyer baslangic 878

    @FindBy(xpath = "//button[@class='mail-button']")
    public WebElement bizeMailAtinBox;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement bizeMailAd;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement bizeMailSoyad;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement bizeMailEmail;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement bizeMailMesaj;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement bizeMailGonderButonu;

    @FindBy(xpath = "//span[normalize-space()='ContactMessages']")
    public WebElement contactMessgeButonu;

    @FindBy(xpath = "//input[@placeholder='Type Something']")
    public WebElement contactMessageAramaButonu;

    @FindBy(xpath = "//button[@class='search-button btn btn-primary']")
    public WebElement contactMesssageSearchButonu;

    @FindBy(xpath = "//div[@class='admin-contact-message-container']//div[1]//h2[1]//button[1]")
    public  WebElement aradıgimizMesaj;
    //body/div[@id='root']/div[@class='user-layout-container']/nav[@class='top-nav-menu bg-default navbar navbar-expand-lg navbar-light sticky-top']/div[@class='container']/div[@class='menu-wrapper']/div[@class='hero']/div[@class='user-logo-nav navbar-nav']/img[1]")
    //body/div[@id='root']/div[@class='user-layout-container']/nav[@class='top-nav-menu bg-default navbar navbar-expand-lg navbar-light sticky-top']/div[@class='container']/div[@class='menu-wrapper']/div[@class='hero']/div[@class='user-logo-nav navbar-nav']/img[1]")

    @FindBy(xpath = "//body/div[@id='root']/div[@class='user-layout-container']/nav[@class='top-nav-menu bg-default navbar navbar-expand-lg navbar-light sticky-top']/div[@class='container']/div[@class='menu-wrapper']/div[@class='hero']/div[@class='user-logo-nav navbar-nav']/img[1]")
    public WebElement customerMenuButonu;

    @FindBy(xpath = "//*[@id=\"subMenu\"]/div/a[1]")
    public WebElement dropdownElementi;


































































    //Fatih Üstünyer bitis 953



}
