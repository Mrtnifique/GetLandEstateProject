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

    @FindBy(xpath = "//h1[contains(text(),'PROFİLİM')]")
    public WebElement profilePageTitle;

    // Profile Information Fields
    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumberField;

    @FindBy(id = "email")
    public WebElement emailField;

    // Update Profile Elements
    @FindBy(xpath = "//button[contains(text(),'UPDATE')]")
    public WebElement updateButton;

    @FindBy(xpath = "//div[@class='success-message']")
    public WebElement successMessage;

    // Change Password Elements
    @FindBy(xpath = "//div[contains(text(),'Change Password')]")
    public WebElement changePasswordSection;

    @FindBy(id = "currentPassword")
    public WebElement currentPasswordField;

    @FindBy(id = "newPassword")
    public WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//button[contains(text(),'CHANGE')]")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//div[@class='password-strength']")
    public WebElement passwordStrengthIndicator;

    @FindBy(xpath = "//span[contains(text(),'STRONG')]")
    public WebElement strongPasswordIndicator;

    // Profile Photo Elements
    @FindBy(xpath = "//div[contains(text(),'Profile Photo')]")
    public WebElement profilePhotoSection;

    @FindBy(xpath = "//button[contains(text(),'SELECT')]")
    public WebElement selectPhotoButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//img[@class='photo-preview']")
    public WebElement photoPreview;

    @FindBy(xpath = "//button[contains(text(),'EDIT')]")
    public WebElement editPhotoButton;

    @FindBy(xpath = "//button[contains(text(),'SAVE')]")
    public WebElement savePhotoButton;
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

    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickChangePasswordSection() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordSection));
        changePasswordSection.click();
    }

    public void enterCurrentPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(currentPasswordField));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void enterNewPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(newPasswordField));
        newPasswordField.clear();
        newPasswordField.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(password);
    }

    public void clickChangePasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordButton));
        changePasswordButton.click();
    }

    public boolean isStrongPasswordIndicatorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(strongPasswordIndicator));
            return strongPasswordIndicator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProfilePhotoSection() {
        wait.until(ExpectedConditions.elementToBeClickable(profilePhotoSection));
        profilePhotoSection.click();
    }

    public void clickSelectPhotoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selectPhotoButton));
        selectPhotoButton.click();
    }

    public void selectPhoto(String filePath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.xpath("//input[@type='file']")));
        fileInput.sendKeys(filePath);
    }

    public boolean isPhotoPreviewDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(photoPreview));
            return photoPreview.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickEditPhotoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editPhotoButton));
        editPhotoButton.click();
    }

    public void clickSavePhotoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(savePhotoButton));
        savePhotoButton.click();
    }

  /*  public void clickDeleteAccountSection() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountSection));
        deleteAccountSection.click();
    }

    public boolean isWarningMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(warningMessage));
            return warningMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
*/
    public void updateProfileFields(String name, String phone, String email) {
        if (name != null && !name.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(nameField));
            nameField.clear();
            nameField.sendKeys(name);
        }
        if (phone != null && !phone.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
            phoneNumberField.clear();
            phoneNumberField.sendKeys(phone);
        }
        if (email != null && !email.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(emailField));
            emailField.clear();
            emailField.sendKeys(email);
        }
    }

  /*  public boolean isFormValidationWorking() {
        try {
            wait.until(ExpectedConditions.visibilityOf(formValidation));
            return formValidation.isDisplayed();
        } catch (Exception e) {
            return false;
        }*/
    }
