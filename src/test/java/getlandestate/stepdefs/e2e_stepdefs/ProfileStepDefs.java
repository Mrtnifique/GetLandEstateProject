package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
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
                .sendKeys("Tomasy Cana fghjk")
                .perform();

        // Soyad alanını temizle ve yeni değer yaz
        actions.moveToElement(profilePage.lastnameField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("ABertyuıopcvbnmH")
                .perform();

        // Telefon alanını temizle ve yeni değer yaz
        actions.moveToElement(profilePage.phoneNumberField).click()
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys("(903) 380-9939")
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

   /* @Then("Güncelleme başarı mesajı görüntülenir")
    public void guncellemeBasariMesajiGoruntulenir() throws InterruptedException {
        Thread.sleep(2000);  // 2 saniye bekle
        Assert.assertTrue("Güncelleme mesajı görünmedi!",
                profilePage.successMessage.isDisplayed());

    } */

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
  /*
    @Then("Fotoğraf başarıyla güncellenir")
       public void fotografBasariylaGuncellenir() {
         Assert.assertTrue("Fotoğraf önizleme görünmüyor, yükleme başarısız.", profilePage.photoPreview.isDisplayed());
         Assert.assertTrue("Başarı mesajı görünmedi.", profilePage.successMessage.isDisplayed());
       }
 */
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
        profilePage.changePasswordButton.click();
    }

    @And("Password strength STRONG olarak görüntülenir")
    public void passwordStrengthStrongOlarakGoruntulenir() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(profilePage.strongPasswordIndicator));
        Assert.assertTrue("Şifre güçlü değil (STRONG etiketi görünmedi)", profilePage.strongPasswordIndicator.isDisplayed());
    }

    @And("CHANGE butonuna tıklanır")
    public void changeButonunaTiklanir() {
        profilePage.changePasswordButton.click();
    }




   //==================@TC02=====================
   @When("Ad, soyad silinir; geçersiz email ve telefon girilir")
   public void adSoyadSilGecersizEmailTelefonGir() {
       Actions actions = new Actions(Driver.getDriver());

       // Ad alanını temizle
       actions.moveToElement(profilePage.nameField)
               .click()
               .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
               .sendKeys(Keys.DELETE)
               .perform();

       // Soyad alanını temizle
       actions.moveToElement(profilePage.lastnameField)
               .click()
               .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
               .sendKeys(Keys.DELETE)
               .perform();

       // Geçersiz email
       profilePage.emailField.clear();
       profilePage.emailField.sendKeys("test@");

       // Geçersiz telefon
       profilePage.phoneNumberField.clear();
       profilePage.phoneNumberField.sendKeys("123abc");
   }

    @And("UPDATE butonuna tekrar tıklanır")
    public void updateButonunaTiklanir_TC02() {
        profilePage.updateButton.click();
    }

    @Then("Zorunlu alan ve format uyarı mesajları gösterilir")
    public void zorunluAlanVeFormatUyarilariGoruntulenir() {
        Assert.assertTrue("Ad alanı uyarısı görünmedi!", profilePage.nameFieldError.isDisplayed());
        Assert.assertTrue("Soyad alanı uyarısı görünmedi!", profilePage.lastNameFieldError.isDisplayed());
        Assert.assertTrue("Email formatı hatası görünmedi!", profilePage.emailFormatError.isDisplayed());
        Assert.assertTrue("Telefon formatı hatası görünmedi!", profilePage.phoneFormatError.isDisplayed());
    }

    @And("Profil güncelleme işlemi başarısız olur")
    public void profilGuncellemeBasarisizOlur() {
        Assert.assertFalse("Update butonu hâlâ aktif, validasyon hatası uygulanmadı!", profilePage.updateButton.isEnabled());
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

    @And("CHANGE butonuna basılır")
    public void changeButonunaBasilir() {
        profilePage.changePasswordButton.click();
    }

    @Then("Şifre gücü NONE veya WEAK görünür")
    public void sifreGucuZayifGorunur() {
        String strengthText = profilePage.passwordStrengthIndicator.getText();
        Assert.assertTrue("Şifre gücü NONE veya WEAK değil",
                strengthText.contains("NONE") || strengthText.contains("WEAK"));
    }

    @And("Şifreler eşleşmiyor uyarısı çıkar")
    public void sifrelerEslesmiyorUyarisiCikar() {
        WebElement mismatchError = Driver.getDriver().findElement(
                By.xpath("//small[contains(text(),'do not match')]"));
        Assert.assertTrue("Şifreler eşleşmiyor hatası çıkmadı", mismatchError.isDisplayed());
    }

    @And("Şifre değişimi başarısız olur")
    public void sifreDegisimiBasarisizOlur() {
        Assert.assertTrue("Başarı mesajı çıkmamalı",
                Driver.getDriver().findElements(By.xpath("//span[contains(text(),'Success')]")).isEmpty());
    }

    //==================@TC04=====================

    @When("Geçersiz boyutta profil fotoğrafı yüklenmeye çalışılır")
    public void gecersizBoyuttaProfilFotoYukleme() {
        // Profile Photo sekmesine geç
        WaitUtils.waitForClickablility(profilePage.profilePhotoSection, 5);
        profilePage.profilePhotoSection.click();

        // SELECT butonuna tıkla
        WaitUtils.waitForClickablility(profilePage.selectPhotoButton, 5);
        profilePage.selectPhotoButton.click();

        // 3MB üzeri dosyayı yükle (örnek: large_sample.jpg)
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/large_sample.jpg";
        profilePage.fileInput.sendKeys(filePath);

        // Küçük bekleme (preview oluşmasın)
        WaitUtils.waitFor(1);

        // SAVE butonuna tıkla
        profilePage.savePhotoButton.click();
    }

    @Then("Yükleme reddedilir ve hata mesajı gösterilir")
    public void yuklemeReddedilirVeHataMesajiGoruntulenir() {
        WebElement hataMesaji = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'upload') or contains(text(),'valid photo')]"));
        Assert.assertTrue("Geçersiz dosya yükleme uyarısı görünmedi!", hataMesaji.isDisplayed());

        // Alternatif olarak profil resmi yüklenmemeli
        Assert.assertFalse("Fotoğraf önizlemesi oluştu, yükleme hatası gözükmedi!",
                profilePage.photoPreview.isDisplayed());
    }

    @Given("Web sitesine erişim sağlanabilmeli")
    public void webSitesineErişimSağlanabilmeli() {
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