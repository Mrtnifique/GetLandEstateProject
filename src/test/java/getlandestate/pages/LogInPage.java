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
    @FindBy(xpath = "//input[@placeholder='(XXX) XXX-XXXX']")
    public WebElement phoneNumberBox;

    //Phone Number Warning Message
    @FindBy(xpath = "//div[contains(text(),'Phone is required')]")
    public WebElement isPhoneWarningDisplayed;

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

    //Confirm Password Input Box
    @FindBy(xpath = "//div[contains(text(),'Email is required')]")
    public WebElement isConfirmPasswordWarningDisplayed;

    //Confirm Password Warning Message
    @FindBy(xpath = "//div[contains(text(),'Confirm password is required')]")
    public WebElement confirmPasswordWarningDisplayed;

    //I understand and agree button
    @FindBy(xpath = "//input[@id='terms']")
    public WebElement iUnderstandAndAgreeButton;

    //Register Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButton;

    //Register Success Message
    @FindBy(xpath = "//div[@class='p-toast-detail']")
    public WebElement successMessage;



    //seval 103
































}
