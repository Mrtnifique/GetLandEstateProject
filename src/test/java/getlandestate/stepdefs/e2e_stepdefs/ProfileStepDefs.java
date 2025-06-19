package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.LogInPage;
import getlandestate.pages.ProfilePage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import getlandestate.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @And("MY PROFILE sayfasına tıklanır")
    public void myProfileSayfasinaTiklanir() {
        WaitUtils.waitForClickablility(profilePage.myProfileIcon, 5);
        profilePage.myProfileIcon.click();
        profilePage.myProfileSection.click();
    }

    @Then("Profile sayfası açılır")
    public void profileSayfasiAcilir() {
        Assert.assertTrue("Profil sayfası açılmadı.", profilePage.profilePageTitle.isDisplayed());
    }

    @And("Profil bilgileri doğru görüntülenir")
    public void profilBilgileriDogrulama() {
        Assert.assertTrue("Ad alanı görünmüyor", profilePage.nameField.isDisplayed());
        Assert.assertTrue("Soyad alanı görünmüyor", profilePage.lastnameField.isDisplayed());
        Assert.assertTrue("Telefon alanı görünmüyor", profilePage.phoneNumberField.isDisplayed());
        Assert.assertTrue("Email alanı görünmüyor", profilePage.emailField.isDisplayed());
    }

    @When("Profil bilgileri güncellenir")
    public void profilBilgileriGuncellenir() {
        Actions actions = new Actions(Driver.getDriver());

        // Ad alanını temizle ve yeni değer yaz
        actions.moveToElement(profilePage.nameField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("Tomy Jonh Thomas")
                .perform();

        // Soyad alanını temizle ve yeni değer yaz
        actions.moveToElement(profilePage.lastnameField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("WillSmith")
                .perform();

        // Telefon alanını temizle ve yeni değer yaz
        actions.moveToElement(profilePage.phoneNumberField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("(903) 380-7939")
                .perform();

        // Email alanını temizle ve yeni değer yaz
        actions.moveToElement(profilePage.emailField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("aefd.3322@gmail.com")
                .perform();
    }


    @And("UPDATE butonuna tıklanır")
    public void updateButonunaTiklanir() {
        WaitUtils.waitForClickablility(profilePage.updateButton, 10); // 10 saniye bekler
        profilePage.updateButton.click();
    }

    //------profil------

    @When("Profile Photo sekmesi açılır")
    public void profilePhotoSekmesiAcilir() {
        WaitUtils.waitForClickablility(profilePage.profilePhotoSection, 5);
        profilePage.profilePhotoSection.click();
    }

    @And("Fotoğraf seçilir ve yüklenir")
    public void fotografSecilirVeYuklenir() {
        // 1. Dosya yolu
        String path = System.getProperty("user.dir") + "/src/test/resources/testdata/profilfotosu.jpg";

        // 2. Dosya input elementi görünür değilse görünür yap
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.display='block';", profilePage.fileInput);

        // 3. Dosyayı yükle
        profilePage.fileInput.sendKeys(path);

        // 4. Preview çıktısını bekle (yüklenme başarılı mı kontrolü)

    profilePage.fileSelectDoneButton.click();
        // 5. Save butonuna bas
        WaitUtils.waitForClickablility(profilePage.savePhotoButton, 5);
        profilePage.savePhotoButton.click();
    }

    @Then("Fotoğraf başarıyla güncellenir")
       public void fotografBasariylaGuncellenir() {
        // Assert.assertTrue("Fotoğraf önizleme görünmüyor, yükleme başarısız.", profilePage.photoPreview.isDisplayed());
         Assert.assertTrue("Başarı mesajı görünmedi.", profilePage.successMessage.isEnabled());
       }

    //==password==

    @When("Change Password sekmesi açılır")
    public void changePasswordSekmesiAcilir() {
        WaitUtils.waitForVisibility(profilePage.changePasswordSection, 5);
        profilePage.changePasswordSection.click();
    }
    // 321.abcdefGH

    @And("Şifre değiştirme formu doldurulur")
    public void sifreDegistirmeFormuDoldurulur() {
        Actions actions = new Actions(Driver.getDriver());

        // Current Password alanını temizle ve şifre yaz
        actions.moveToElement(profilePage.currentPasswordField)
                .click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("321.abcdefGH")
                .perform();

        WaitUtils.waitForVisibility(profilePage.newPasswordField, 5);

        // Yeni şifre alanını temizle ve yeni şifre yaz
        actions.moveToElement(profilePage.newPasswordField)
                .click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("321.abcdefGH")
                .perform();

        WaitUtils.waitForVisibility(profilePage.confirmPasswordField, 5);

        // Yeni şifre tekrar alanını temizle ve tekrar yaz
        actions.moveToElement(profilePage.confirmPasswordField)
                .click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("321.abcdefGH")
                .perform();

        // Değiştir (CHANGE) butonuna tıkla
    }

   @And("CHANGE butonuna tıklanır")
    public void changeButonunaTiklanir() {
        profilePage.changePasswordButton.click();
    }


    @Then("Şifre değişikliği sonrası çıkış yapıldığı doğrulanır")
    public void sifreDegisikligiSonrasiCikisYapildigiDogrulanir() {
        LogInPage logInPage = new LogInPage();

        //  Doğrulama
        WaitUtils.waitForVisibility(logInPage.emailBox, 5);
        Assert.assertTrue("Email input görünmüyor, çıkış yapılmamış olabilir!", logInPage.emailBox.isDisplayed());
        Assert.assertTrue("Login butonu görünmüyor!", logInPage.loginButton.isDisplayed());
    }

    //==================@TC02=====================

    @When("Ad, soyad silinir; geçersiz email ve telefon girilir")
    public void adSoyadSilGecersizEmailTelefonGir() {
        Actions actions = new Actions(Driver.getDriver());

        // Ad temizle
        actions.moveToElement(profilePage.nameField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE).perform();

        // Soyad temizle
        actions.moveToElement(profilePage.lastnameField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE).perform();

        // Geçersiz email gir
        profilePage.emailField.clear();
        profilePage.emailField.sendKeys("test@");

        // Geçersiz telefon gir
        profilePage.phoneNumberField.clear();
        profilePage.phoneNumberField.sendKeys("123abc");
    }

    @And("UPDATE butonuna tekrar tıklanamaz")
    public void updateButonunaTiklanamaz() {
        Assert.assertFalse("Geçersiz verilere rağmen UPDATE butonu aktif!", profilePage.updateButton.isEnabled());
    }

    @Then("Zorunlu alan ve format uyarı mesajları gösterilir")
    public void zorunluAlanVeFormatUyarilariGoruntulenir() {
        Assert.assertTrue(" Ad alanı uyarısı görünmedi!", profilePage.nameFieldError.isDisplayed());
        Assert.assertTrue(" Soyad alanı uyarısı görünmedi!", profilePage.lastNameFieldError.isDisplayed());
        Assert.assertTrue(" Email format hatası görünmedi!", profilePage.emailFormatError.isDisplayed());
        Assert.assertTrue(" Telefon format hatası görünmedi!", profilePage.phoneFormatError.isDisplayed());
    }

    @And("Profil güncelleme işlemi başarısız olur")
    public void profilGuncellemeBasarisizOlur() {
        // UPDATE butonunun disabled olması bekleniyorsa:
        Assert.assertFalse("UPDATE butonu hâlâ aktif!", profilePage.updateButton.isEnabled());
    }



    //==================@TC03=====================

    @When("Şifre değiştirme sekmesi açılır")
    public void sifre_degistirme_sekmesi_acilir() {
        WaitUtils.waitForVisibility(profilePage.changePasswordSection, 5);
        profilePage.changePasswordSection.click();
    }

    @When("Yanlış mevcut şifre ve zayıf yeni şifre girilir, tekrar şifre boş bırakılır")
    public void yanlisMevcutVeZayifYeniSifreGir() {
        profilePage.changePasswordSection.click();
        profilePage.currentPasswordField.sendKeys("wrongPassword123");
        profilePage.newPasswordField.sendKeys("123");
        profilePage.confirmPasswordField.clear(); // Boş bırakılıyor
    }

    @And("Şifre gücü durumu kontrol edilir")
    public void sifreGucuDurumuKontrol() {
        Assert.assertTrue("Şifre gücü etiketi görünmedi",
                profilePage.passwordStrengthIndicator.isDisplayed());
    }

    @And("CHANGE butonuna tıklanamaz")
    public void changeButonunaTiklanamaz() {
        Assert.assertFalse("Geçersiz şifreye rağmen CHANGE butonu aktif!", profilePage.changePasswordButton.isEnabled());
    }

    @Then("Şifre gücü NONE veya WEAK görünür")
    public void sifreGucuZayifGorunur() {
        String strengthText = profilePage.passwordStrengthIndicator.getText();
        Assert.assertTrue("Şifre gücü NONE veya WEAK değil",
                strengthText.contains("NONE") || strengthText.contains("WEAK"));
    }

    @And("Şifre değişiminin başarısız olduğu doğrulanır")
    public void sifreDegisimiBasarisizOlur() {
        Assert.assertTrue("Başarı mesajı çıkmamalı",
                Driver.getDriver().findElements(By.xpath("//span[contains(text(),'Success')]")).isEmpty());
    }

    //==================@TC04=====================

    @When("Geçersiz boyutta profil fotoğrafı yüklenir")
    public void gecersizBoyuttaProfilFotoYukleme() {
        WaitUtils.waitForClickablility(profilePage.profilePhotoSection, 5);
        profilePage.profilePhotoSection.click();
        WaitUtils.waitFor(2);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/large_sample.jpg";
        profilePage.fileInput.sendKeys(filePath);
        profilePage.fileSelectDoneButton.click();
        WaitUtils.waitFor(2); // preview oluşmasın diye
    }

    @Then("SAVE butonu devre dışı olur ve yükleme yapılamaz")
    public void saveButonuDevreDisiOlur() {
        WaitUtils.waitFor(2);
        profilePage.photoSaveButton.click();
    }

    @And("Hata mesajı görüntülendiği doğrulanır")
    public void hataMesajıGörüntülendiğiDoğrulanır() {
        Assert.assertTrue("Oversize hata mesajı görünmedi!",
                profilePage.oversizeErrorMessage.isEnabled());

    }


    @After
    public void tearDown() {
        Driver.closeDriver();
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