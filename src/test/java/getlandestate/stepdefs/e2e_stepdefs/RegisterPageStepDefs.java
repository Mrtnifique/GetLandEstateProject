package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.ParameterType;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPageStepDefs {

    LogInPage logInPage = new LogInPage();
    Faker faker = new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @ParameterType("true|false")
    public Boolean bool(String value) {
        return Boolean.valueOf(value);
    }

    @Given("Kullanıcı {string} sitesine erişir")
    public void kullanıcı_sitesine_erişir(String url) {
        Driver.getDriver().get(url);
    }

    @When("Kayıt sayfasına gider")
    public void kayıt_sayfasına_gider() {
        logInPage.goTologInPage.click();
    }

    @And("Kullanici bilgilerini girer: {string}, {string}, {string}, {string}, {string}, {string}, {bool}")
    public void kullanici_bilgilerini_girer(String firstName, String lastName, String phone, String email,
                                            String password, String confirmPassword, Boolean checkbox) {
        // Generate random data when empty string is provided
        String generatedFirstName = firstName.isEmpty() ? "" : (firstName.equals("Ali") ? firstName : faker.name().firstName());
        String generatedLastName = lastName.isEmpty() ? "" : (lastName.equals("Yılmaz") ? lastName : faker.name().lastName());
        String generatedPhone = phone.isEmpty() ? "" : (phone.equals("05001112233") ? phone : faker.numerify("05########"));
        String generatedEmail = email.isEmpty() ? "" : (email.equals("mail@example.com") ? email : faker.internet().emailAddress());
        String generatedPassword = password.isEmpty() ? "" : (password.equals("StrongPass123?") ? password : faker.internet().password(8, 16, true, true, true));
        String generatedConfirmPassword = confirmPassword.isEmpty() ? "" : (confirmPassword.equals("StrongPass123?") ? confirmPassword : generatedPassword);

        fillField(logInPage.firstNameBox, generatedFirstName);
        fillField(logInPage.lastNameBox, generatedLastName);
        fillField(logInPage.phoneNumberBox, generatedPhone);
        fillField(logInPage.emailBox1, generatedEmail);
        fillField(logInPage.passwordBox, generatedPassword);
        fillField(logInPage.confirmPasswordBox, generatedConfirmPassword);

        if (checkbox && !logInPage.iUnderstandAndAgreeButton.isSelected()) {
            logInPage.iUnderstandAndAgreeButton.click();
        }
    }

    private void fillField(WebElement element, String value) {
        if (value != null && !value.trim().isEmpty()) {
            element.clear();
            element.sendKeys(value.trim());
        } else {
            element.click();
        }
    }

    @And("Register butonuna tıklar")
    public void register_butonuna_tıklar() {
        logInPage.registerButton.click();
    }

    @Then("First Name alanı için uyarı mesajı görüntülenir")
    public void first_name_uyarisi() {
        verifyVisible(logInPage.isFirstNameWarningDisplayed);
    }

    @Then("Last Name alanı için uyarı mesajı görüntülenir")
    public void last_name_uyarisi() {
        verifyVisible(logInPage.isLastNameWarningDisplayed);
    }

    @Then("Phone Number alanı için uyarı mesajı görüntülenir")
    public void phone_number_uyarisi() {
        verifyVisible(logInPage.isPhoneWarningDisplayed);
    }

    @Then("Email alanı için uyarı mesajı görüntülenir")
    public void email_uyarisi() {
        verifyVisible(logInPage.isEmailRequiredWarningDisplayed);
    }

    @Then("Password alanı için uyarı mesajı görüntülenir")
    public void password_uyarisi() {
        verifyVisible(logInPage.isPasswordWarningDisplayed);
    }

    @Then("Zayıf şifre için uyarı mesajı görüntülenir")
    public void zayıf_sifre_uyarisi() {
        verifyVisible(logInPage.isWeakPasswordWarningDisplayed);
    }

    @Then("Confirm Password alanı için uyarı mesajı görüntülenir")
    public void confirm_password_uyarisi() {
        verifyVisible(logInPage.confirmPasswordWarningDisplayed);
    }

    @Then("Checkbox işaretlenmeden kayıt olma işlemi başarısız olur")
    public void checkbox_kayit_engellenir() {
        Assert.assertFalse("Checkbox seçilmeden kayıt butonu aktif olmamalı", logInPage.registerButton.isEnabled());
    }

    @Then("Başarılı kayıt işlemi gerçekleşir")
    public void basarili_kayit() {
        verifyVisible(logInPage.successMessage);
    }

    private void verifyVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue("Beklenen eleman görünür olmalı", element.isDisplayed());
    }
}