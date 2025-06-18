package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.LogInPage;
import getlandestate.pages.ProfilePage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import getlandestate.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class ProfileStepDefs {

    ProfilePage profilePage = new ProfilePage();

    @Given("Siteye customer olarak giriş yapılır")
    public void siteyeCustomerOlarakGirişYapılır() {
        LogInPage logInPage = new LogInPage();
        Driver.getDriver().get("http://64.227.123.49");
        profilePage.loginIcon.click();

        logInPage.emailBox.sendKeys("aefd.3322@gmail.com");
        logInPage.passwordBox.sendKeys("321.abcdefGH");
        logInPage.loginButton.click();
        // Login işlemi burada yapılacak
        WaitUtils.waitFor(2);
    }

    @When("MY PROFILE sayfasına tıklanır")
    public void myProfileSayfasınaTıklanır() {
        profilePage.myProfileIcon.click();
        profilePage.myProfileSection.click();
    }

    @Then("Profile sayfası açılır")
    public void profileSayfasıAçılır() {
        Assert.assertTrue("Profile page should be opened",
                profilePage.isProfilePageOpened());
    }

    @And("Profil bilgileri doğru görüntülenir")
    public void profilBilgileriDoğruGörüntülenir() {
        Assert.assertEquals("Tom", profilePage.getNameFieldValue());
        Assert.assertEquals("(055) 334-5848", profilePage.getPhoneNumberFieldValue());
        Assert.assertEquals("tomdoe@example.com", profilePage.getEmailFieldValue());
    }

    @When("Profil bilgileri güncellenir")
    public void profilBilgileriGüncellenir() {
        // Ad, telefon, email alanlarını güncelle
        profilePage.updateProfileFields("Tom Updated", "(055) 334-5849", "tomdoe.updated@example.com");
    }

    @And("UPDATE butonuna tıklanır")
    public void updateButonunaTıklanır() {
        profilePage.clickUpdateButton();
    }

    @Then("Güncelleme başarı mesajı görüntülenir")
    public void güncellemeBaşarıMesajıGörüntülenir() {
        Assert.assertTrue("Update success message should be displayed",
                profilePage.isSuccessMessageDisplayed());
    }

    @When("Change Password sekmesi açılır")
    public void changePasswordSekmesiAçılır() {
        profilePage.clickChangePasswordSection();
    }

    @And("Şifre değiştirme formu doldurulur")
    public void şifreDeğiştirmeFormuDoldurulur() {
        profilePage.enterCurrentPassword(ConfigReader.getProperty("validPassword"));
        profilePage.enterNewPassword("NewPassword123!");
        profilePage.enterConfirmPassword("NewPassword123!");
    }

    @And("CHANGE butonuna tıklanır")
    public void changeButonunaTıklanır() {
        profilePage.clickChangePasswordButton();
    }

    @Then("Şifre değiştirme başarı mesajı görüntülenir")
    public void şifreDeğiştirmeBaşarıMesajıGörüntülenir() {
        Assert.assertTrue("Password change success message should be displayed",
                profilePage.isSuccessMessageDisplayed());
    }

    @And("Password strength STRONG olarak görüntülenir")
    public void passwordStrengthSTRONGOlarakGörüntülenir() {
        Assert.assertTrue("Password strength should be STRONG",
                profilePage.isStrongPasswordIndicatorDisplayed());
    }

    @When("Profile Photo sekmesi açılır")
    public void profilePhotoSekmesiAçılır() {
        profilePage.clickProfilePhotoSection();
    }

    @And("Fotoğraf seçilir ve yüklenir")
    public void fotoğrafSeçilirVeYüklenir() {
        String imagePath = System.getProperty("user.dir") + "/src/test/resources/testdata/sample.jpg";
        profilePage.selectPhoto(imagePath);
        profilePage.clickEditPhotoButton();
        profilePage.clickSavePhotoButton();
    }

    @Then("Fotoğraf başarıyla güncellenir")
    public void fotoğrafBaşarıylaGüncellenir() {
        Assert.assertTrue("Photo update success message should be displayed",
                profilePage.isSuccessMessageDisplayed());
    }

    //==================@TC02=====================
    @When("Delete Account sekmesi açılır")
    public void deleteAccountSekmesiAçılır() {
    }

    @Then("Uyarı mesajı görüntülenir")
    public void uyarıMesajıGörüntülenir() {
    }

    @And("Form validasyonu çalışır")
    public void formValidasyonuÇalışır() {
    }

    @When("Firstname ve Lastname alanını tamamen sil")
    public void firstnameVeLastnameAlanınıTamamenSil() {
    }

    @And("Email alanına geçersiz format gir")
    public void emailAlanınaGeçersizFormatGir() {
    }

    @And("Telefon alanına geçersiz format gir")
    public void telefonAlanınaGeçersizFormatGir() {
    }

    @Then("Ad alanı boş bırakılamaz hata mesajı gösterilir")
    public void adAlanıBoşBırakılamazHataMesajıGösterilir() {
    }

    @And("Geçerli email adres giriniz hata mesajı gösterilir")
    public void geçerliEmailAdresGirinizHataMesajıGösterilir() {
    }

    @And("Telefon numarası geçersiz format hata mesajı gösterilir")
    public void telefonNumarasıGeçersizFormatHataMesajıGösterilir() {
    }

    @And("Profil bilgileri güncellenmez")
    public void profilBilgileriGüncellenmez() {
    }
/*
    @When("Delete Account sekmesi açılır")
    public void deleteAccountSekmesiAçılır() {
        profilePage.clickDeleteAccountSection();
    }

    @Then("Uyarı mesajı görüntülenir")
    public void uyarıMesajıGörüntülenir() {
        Assert.assertTrue("Warning message should be displayed",
                profilePage.isWarningMessageDisplayed());
    }

    @And("Form validasyonu çalışır")
    public void formValidasyonuÇalışır() {
        Assert.assertTrue("Form validation should be working",
                profilePage.isFormValidationWorking());
    }*/
}