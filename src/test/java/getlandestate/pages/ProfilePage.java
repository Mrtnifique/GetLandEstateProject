package getlandestate.pages;

import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ProfilePage {

    private WebDriverWait wait;

    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginIcon;

    // Profile Page Elements
    @FindBy(xpath = "//body/div[@id='root']/div[@class='user-layout-container']/nav[@class='top-nav-menu bg-default navbar navbar-expand-lg navbar-light sticky-top']/div[@class='container']/div[@class='menu-wrapper']/div[@class='hero']/div[@class='user-logo-nav navbar-nav']/img[1]")
    public WebElement myProfileIcon;

    @FindBy(xpath = "//span[normalize-space()='My Profile']")
    public WebElement myProfileSection;

    @FindBy(xpath = "//h1[normalize-space()='MY PROFILE']")
    public WebElement profilePageTitle;

    // =====Profile Information Fields=====
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastnameField;

    @FindBy(xpath = "//input[@placeholder='(XXX) XXX-XXXX']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailField;

    // Update Profile Elements
    @FindBy(xpath = "//button[normalize-space()='UPDATE']")
    public WebElement updateButton;

    @FindBy(xpath = "//span[@class='p-toast-summary']")
    public WebElement successMessage;

    // =====Profile Photo Elements=====
    @FindBy(xpath = "//p[normalize-space()='Profile Photo']")
    public WebElement profilePhotoSection;

    @FindBy(xpath = "//button[normalize-space()='SELECT']")
    public WebElement selectPhotoButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//button[normalize-space()='DONE']")
    public WebElement fileSelectDoneButton;


    @FindBy(xpath = "//img[@class='photo-preview']")
    public WebElement photoPreview;

    @FindBy(xpath = "//button[contains(text(),'EDIT')]")
    public WebElement editPhotoButton;

    @FindBy(xpath = "//button[normalize-space()='SAVE']")
    public WebElement savePhotoButton;

    // =====Change Password Elements======0
    @FindBy(xpath = "//button[.//p[text()='Change Password']]")
    public WebElement changePasswordSection;

    @FindBy(xpath = "//input[@placeholder='Current Password']")
    public WebElement currentPasswordField;

    @FindBy(xpath = "//input[@name='newPassword']")
    public WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='repeatNewPassword']")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//button[normalize-space()='CHANGE']")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//div[@class='strength-label']")
    public WebElement passwordStrengthIndicator;

    @FindBy(xpath = "//span[contains(text(),'STRONG')]")
    public WebElement strongPasswordIndicator;

    @FindBy(xpath = "//div[contains(text(),'First')]")
    public WebElement nameFieldError;

    @FindBy(xpath = "//div[contains(text(),'profileFormTranslations.invalidEmail')]")
    public WebElement emailFormatError;

    @FindBy(xpath = "//div[contains(text(),'Last')]")
    public WebElement lastNameFieldError;

    @FindBy(xpath = "//div[contains(text(),'phone')]")
    public WebElement phoneFormatError;


    //Şifre değişttikten sonra tekrar giriş sayfasına yönlendiriyor
/*
    // Delete Account Elements
    @FindBy(xpath = "//div[contains(text(),'Delete Account')]")
    private WebElement deleteAccountSection;

    @FindBy(xpath = "//div[@class='warning-message']")
    private WebElement warningMessage;

    @FindBy(xpath = "//div[@class='form-validation']")
    private WebElement formValidation; */

    // Methods
    public void clickMyProfileSection() {
        wait.until(ExpectedConditions.elementToBeClickable(myProfileSection));
        myProfileSection.click();
    }

    public boolean isProfilePageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(profilePageTitle));
            return profilePageTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNameFieldValue() {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        return nameField.getAttribute("value");
    }


    public String getPhoneNumberFieldValue() {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        return phoneNumberField.getAttribute("value");
    }

    public String getEmailFieldValue() {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.getAttribute("value");
    }

    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateButton));
        updateButton.click();
    }

    }


