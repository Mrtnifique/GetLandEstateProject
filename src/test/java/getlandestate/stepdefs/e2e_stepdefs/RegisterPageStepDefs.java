package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.ParameterType;
import org.junit.Assert;
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
        wait.until(ExpectedConditions.elementToBeClickable(logInPage.goTologInPage));
        logInPage.goTologInPage.click();
    }

    // TC01: First Name alanı boş bırakıldığında uyarı verilmesi
    @And("Kullanici bilgileri girilir")
    public void kullanici_bilgileri_girilir() {
        // Bu step sadece genel kullanım için, spesifik testler kendi steplerini kullanacak
    }

    @Then("First Name alanı için uyarı mesajı görüntülenir")
    public void first_name_uyarı_mesajı_görüntülenir() {
        // First Name boş bırakılır, diğer alanlar doldurulur
        logInPage.firstNameBox.click();
        logInPage.lastNameBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.isFirstNameWarningDisplayed));
        Assert.assertTrue("First Name için uyarı mesajı görüntülenmelidir",
                logInPage.isFirstNameWarningDisplayed.isDisplayed());
    }

    // TC02: Last Name alanı boş bırakıldığında uyarı verilmesi
    @Then("Last Name alanı için uyarı mesajı görüntülenir")
    public void last_name_uyarı_mesajı_görüntülenir() {
        // Last Name boş bırakılır, diğer alanlar doldurulur
        logInPage.lastNameBox.click();
        logInPage.phoneNumberBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.isLastNameWarningDisplayed));
        Assert.assertTrue("Last Name için uyarı mesajı görüntülenmelidir",
                logInPage.isLastNameWarningDisplayed.isDisplayed());
    }

    // TC03: Phone Number alanı boş bırakıldığında uyarı verilmesi
    @Then("Phone Number alanı için uyarı mesajı görüntülenir")
    public void phone_number_uyarı_mesajı_görüntülenir() {
        // Phone Number boş bırakılır, diğer alanlar doldurulur
        logInPage.phoneNumberBox.click();
        logInPage.emailBox1.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.invalidPhoneNumber));
        Assert.assertTrue("Phone Number için uyarı mesajı görüntülenmelidir",
                logInPage.invalidPhoneNumber.isDisplayed());
    }

    // TC04: Email alanı boş bırakıldığında uyarı verilmesi
    @Then("Email alanı için uyarı mesajı görüntülenir")
    public void email_uyarı_mesajı_görüntülenir() {
        // Email boş bırakılır, diğer alanlar doldurulur
        logInPage.emailBox1.click();
        logInPage.passwordBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.isEmailRequiredWarningDisplayed));
        Assert.assertTrue("Email için uyarı mesajı görüntülenmelidir",
                logInPage.isEmailRequiredWarningDisplayed.isDisplayed());
    }

    // TC05: Geçersiz Email formatı girildiğinde uyarı verilmesi
    @Then("Email formatı için uyarı mesajı görüntülenir")
    public void email_formatı_uyarı_mesajı_görüntülenir() {
        // Geçersiz email formatı girilir, diğer alanlar doldurulur
        logInPage.emailBox1.click();
        logInPage.emailBox1.sendKeys("abc");
        logInPage.passwordBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.invalidEmail));
        Assert.assertTrue("Geçersiz Email formatı için uyarı mesajı görüntülenmelidir",
                logInPage.invalidEmail.isDisplayed());
    }

    // TC06: Password alanı boş bırakıldığında uyarı verilmesi
    @Then("Password alanı için uyarı mesajı görüntülenir")
    public void password_uyarı_mesajı_görüntülenir() {
        // Password boş bırakılır, diğer alanlar doldurulur
        logInPage.passwordBox.click();
        logInPage.confirmPasswordBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.isPasswordWarningDisplayed));
        Assert.assertTrue("Password için uyarı mesajı görüntülenmelidir",
                logInPage.isPasswordWarningDisplayed.isDisplayed());
    }

    // TC07: Zayıf şifre girildiğinde uyarı verilmesi
    @Then("Zayıf şifre için uyarı mesajı görüntülenir")
    public void zayıf_şifre_uyarı_mesajı_görüntülenir() {
        // Zayıf şifre girilir, diğer alanlar doldurulur
        logInPage.passwordBox.sendKeys("123");
        logInPage.confirmPasswordBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.isWeakPasswordWarningDisplayed));
        Assert.assertTrue("Zayıf şifre için uyarı mesajı görüntülenmelidir",
                logInPage.isWeakPasswordWarningDisplayed.isDisplayed());
    }

    // TC08: Confirm Password alanı boş bırakıldığında uyarı verilmesi
    @Then("Confirm Password alanı için uyarı mesajı görüntülenir")
    public void confirm_password_uyarı_mesajı_görüntülenir() {
        // Confirm Password boş bırakılır, diğer alanlar doldurulur
        String password = faker.internet().password();
        logInPage.passwordBox.sendKeys(password);
        logInPage.confirmPasswordBox.click();
        logInPage.confirmPasswordBox.sendKeys("12345");
        logInPage.passwordBox.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.confirmPasswordMustMatchWarningDisplayed));
        Assert.assertTrue("Confirm Password için uyarı mesajı görüntülenmelidir",
                logInPage.confirmPasswordMustMatchWarningDisplayed.isDisplayed());
    }

    // TC09: Checkbox işaretlenmeden Register tıklanamaz
    @Then("Checkbox işaretlenmeden kayıt olma işlemi başarısız olur")
    public void checkbox_kayıt_işlemi_başarısız_olur() {
        // Checkbox işaretlenmez, diğer alanlar doldurulur
        String password = faker.internet().password();
        logInPage.firstNameBox.sendKeys(faker.name().firstName());
        logInPage.lastNameBox.sendKeys(faker.name().lastName());
        logInPage.phoneNumberBox.sendKeys(faker.phoneNumber().cellPhone());
        logInPage.phoneNumberBox.click();
        logInPage.emailBox1.sendKeys(faker.internet().emailAddress());
        logInPage.passwordBox.sendKeys(password);
        logInPage.confirmPasswordBox.sendKeys(password);
        // Checkbox işaretlenmez

        // Register butonu disabled olmalı veya tıklandığında hata vermeli
        Assert.assertFalse("Checkbox seçilmeden kayıt butonu aktif olmamalı",
                logInPage.registerButton.isEnabled());
    }

    // TC10: Tüm bilgiler doğru girildiğinde başarılı kayıt işlemi
    @Then("Başarılı kayıt işlemi gerçekleşir")
    public void başarılı_kayıt_işlemi_gerçekleşir() {
        // Tüm alanlar doğru şekilde doldurulur
        Driver.getDriver().get("http://64.227.123.49/register");
        String email = faker.internet().emailAddress();

        logInPage.firstNameBox.sendKeys(faker.name().firstName());
        logInPage.lastNameBox.sendKeys(faker.name().lastName());
        logInPage.phoneNumberBox.click();
        logInPage.phoneNumberBox.sendKeys(faker.phoneNumber().cellPhone());
        logInPage.emailBox1.sendKeys(email);
        logInPage.passwordBox.sendKeys("Password123?");
        logInPage.confirmPasswordBox.sendKeys("Password123?");
        logInPage.iUnderstandAndAgreeButton.click();
        logInPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(logInPage.successMessage));
        Assert.assertTrue("Başarılı kayıt mesajı görüntülenmelidir",
                logInPage.successMessage.isDisplayed());
        Driver.closeDriver();
    }
}