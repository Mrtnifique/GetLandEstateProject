package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class DashBoardPageStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    Faker faker = new Faker();
    Random random = new Random();
    Actions actions = new Actions(Driver.getDriver());


    @When("Search butonuna tıklanır")
    public void searchButonunaTiklanir() {
        dashBoardPage.searchBox.click();
        WaitUtils.waitFor(2);

    }


    @And("Filtreleme yapılarak arama yapılır")
    public void filtrelemeYapılarakAramaYapılır() {
        dashBoardPage.categoryFilter.click();
        Select selectCategory = new Select(dashBoardPage.categoryFilter);
        selectCategory.selectByVisibleText("House");

        dashBoardPage.countryFilter.click();
        Select selectCountry = new Select(dashBoardPage.countryFilter);
        selectCountry.selectByVisibleText("Türkiye");

        dashBoardPage.cityFilter.click();
        Select selectCity = new Select(dashBoardPage.cityFilter);
        selectCity.selectByVisibleText("Ankara");

        actions.moveToElement(dashBoardPage.districtFilter).click().perform();

        Select selectDistrict = new Select(dashBoardPage.districtFilter);
        selectDistrict.selectByVisibleText("Çankaya");

        dashBoardPage.filterSearchButton.click();


    }

    @Then("Aranan ilanın listelenmesi test edilir")
    public void arananIlanınListelenmesiTestEdilir() {
        assertTrue(dashBoardPage.houseDisplayed.isDisplayed());
        dashBoardPage.houseClick.click();

    }

    @Then("İletisim bilgilerine tıklayarak uyarı mesajı alınır")
    public void iletisimBilgilerineTıklayarakUyarıMesajıAlınır() {

        dashBoardPage.contactNumberEyesButton.click();

        Assert.assertTrue(dashBoardPage.contactAlert.isEnabled());
        dashBoardPage.contactAlertCloseButton.click();


    }

    @And("Tarih ve saat girilerek randevu olusturulur")
    public void tarihVeSaatGirilerekRandevuOlusturulur() {
        // Rastgele tarih

        dashBoardPage.tourDate.sendKeys(faker.date().toString());

        // Rastgele saat

        Select timeSelect = new Select(dashBoardPage.tourTime);
        int index = random.nextInt(timeSelect.getOptions().size());
        timeSelect.selectByIndex(index);

        //Submit Tour Request butonuna tıklanır
        actions.moveToElement(dashBoardPage.submitTourRequestButton).click().perform();
    }

    @Then("Randevu icin uyarı mesajı görünürlüğü test edilir")
    public void randevuIcinUyarıMesajıGörünürlüğüTestEdilir() {
        WaitUtils.waitFor(3);

        Assert.assertTrue(dashBoardPage.contactAlert2.isDisplayed());
    }




    @And("Create one now butonuna tıklanır")
    public void createOneNowButonunaTıklanır() {
        dashBoardPage.createOneNowButton.click();
    }


    @Then("Register sayfasına gidildiği test edilir")
    public void registerSayfasınaGidildiğiTestEdilir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://64.227.123.49/register";
        Assert.assertEquals(expectedUrl, actualUrl);
    }


    @And("Tarih ve saat boş bırakılarak submit butonuna tıklanır")
    public void tarihVeSaatBoşBırakılarakSubmitButonunaTıklanır() {
        actions.moveToElement(dashBoardPage.submitTourRequestButton).click().perform();
    }

        @When("Kullanıcı iletişim formuna tıklar")
        public void kullanıcı_iletişim_formuna_tıklar () {
            dashBoardPage.contact.click();
        }

        @And("Kullanıcı First Name alanına {string} yazar")
        public void kullanıcı_first_name_alanına_yazar (String firstName){
            dashBoardPage.firstName.sendKeys(firstName);
        }

        @And("Kullanıcı Last Name alanına {string} yazar")
        public void kullanıcı_last_name_alanına_yazar (String lastName){
            dashBoardPage.lastName.sendKeys(lastName);
        }

        @And("Kullanıcı geçersiz bir email adresi {string} yazar")
        public void kullanıcı_geçersiz_bir_email_adresi_yazar (String invalidEmail){
            dashBoardPage.email.sendKeys(invalidEmail);
            dashBoardPage.message.click();
        }

        @Then("Geçersiz email uyarısı görüntülenir")
        public void geçersiz_email_uyarısı_görüntülenir () {
            Assert.assertTrue(dashBoardPage.invalidEmailWarning.isDisplayed());
        }


        @When("Kullanıcı geçerli bir email adresi {string} yazar")
        public void kullanıcı_geçerli_bir_email_adresi_yazar (String email){
            dashBoardPage.email.clear();
            dashBoardPage.email.sendKeys(email);
        }


        @And("Kullanıcı mesaj kutusuna {string} yazar")
        public void kullanıcı_mesaj_kutusuna_yazar (String message){
            dashBoardPage.message.sendKeys(message);
        }

        @And("Kullanıcı mesaj kutusunu boş bırakır")
        public void kullanıcı_mesaj_kutusunu_boş_bırakır () {
            dashBoardPage.message.clear();
        }

        @And("Kullanıcı gönder butonuna tıklar")
        public void kullanıcı_gönder_butonuna_tıklar () {
            dashBoardPage.submitButton.click();
            WaitUtils.waitFor(2);
        }

        @Then("Mesaj başarıyla gönderildi uyarısı görüntülenir")
        public void mesaj_başarıyla_gönderildi_uyarısı_görüntülenir () {
            Assert.assertTrue(dashBoardPage.successMessage.isDisplayed());
        }

        @Then("First Name minimum 2 karakter uyarısı görüntülenir")
        public void first_name_minimum_2_karakter_uyarısı_görüntülenir () {
            Assert.assertTrue(dashBoardPage.firstNameWarning.isDisplayed());
        }

        @And("Last Name minimum 2 karakter uyarısı görüntülenir")
        public void last_name_minimum_2_karakter_uyarısı_görüntülenir () {
            Assert.assertTrue(dashBoardPage.lastNameWarning.isDisplayed());
        }

        @And("Kullanıcı email alanına {string} yazar")
        public void kullanıcıEmailAlanınaYazar (String messenger){
            dashBoardPage.message.sendKeys(messenger);

        }

        @Then("Email zorunlu alan uyarısı görüntülenir")
        public void email_zorunlu_alan_uyarısı_görüntülenir () {
            Assert.assertTrue(dashBoardPage.requiredEmailWarning.isDisplayed());
        }


        @And("Mesaj gönderilemez")
        public void mesaj_gönderilemez () {
            Assert.assertFalse(dashBoardPage.submitButton01.isEnabled());
        }


        @And("Tarih ve saat boş bırakılır")
        public void tarihVeSaatBoşBırakılır () {
            dashBoardPage.tourDate.sendKeys("  ");
            dashBoardPage.tourTime.sendKeys(" ");

        }





    @Then("Randevu icin tarih ve saat girmeden uyarı mesajı görünürlüğü test edilir")
    public void randevuIcinTarihVeSaatGirmedenUyarıMesajıGörünürlüğüTestEdilir() {
        Assert.assertTrue(dashBoardPage.tourDateIsRequired.isDisplayed());
        Assert.assertTrue(dashBoardPage.tourTimeIsRequired.isDisplayed());
    }




    @And( "Manager tour request tıklar")
    public void managertourRequestTıklar() {
        dashBoardPage.tourRequest18.click();
    }

    @And("Sayfadaki bir ilana tıklar")
    public void sayfadakBirİlanaTıklar() {
        dashBoardPage.firstProperties18.click();
        WaitUtils.waitFor(2);
    }

    @And("Tarih {int} ve Saat {int} girilerek randevu oluşturulur ")
    public void tarihVeSaatGirilerekRandevuOluşturulur(int tourDate, int tourtime) {
        dashBoardPage.tourDate.sendKeys("18.09.2025");
        dashBoardPage.tourTime.sendKeys("13:00");
        dashBoardPage.submitTourRequestButton.click();


    }

    @When("Manager menüye gelip adverts tıklar")
    public void managerMenuyeGelipAdvertsTıklar() {
        dashBoardPage.username18.click();
        dashBoardPage.advertsButton18.click();
    }

    @Then("Kendi verdiği ilanların isteklerini görebilmeli")
    public void kendiVerdiğiİlanlarınİstekleriniGörebilmeli() {
        Assert.assertTrue(dashBoardPage.myProperties18.isDisplayed());
        WaitUtils.waitFor(2);
    }

    @When("Manager menüye gelip tour request tıklar")
    public void managerMenuyeGelipTourRequestTıklar() {
        dashBoardPage.username18.click();
        dashBoardPage.tourRequestButton18.click();

    }

    @Then("Manager responses tıklayıp gelen gezme isteklerini yönetebilmeli")
    public void managerResponsesTıklayıpGelenGezmeİstekleriniYönetebilmeli() {
        dashBoardPage.managerResponses18.isEnabled();
        Assert.assertTrue(dashBoardPage.managerResponses18.isDisplayed());
        WaitUtils.waitFor(2);
        dashBoardPage.username18.click();
        dashBoardPage.logout18.click();
        WaitUtils.waitFor(2);
        dashBoardPage.logoutsubmitbutton18.click();
    }



    //Emine
    @When("Back To Site butonuna tıklanır")
    public void backToSiteButonunaTıklanır() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dashBoardPage.backToSiteButton)
                .click()
                .build()
                .perform();
    }

    @And("Profile butonuna tıklanır")
    public void profileButonunaTiklanir() {
        dashBoardPage.profileButton.click();
    }

    @And("My Adverts butonuna tıklanır")
    public void myAdvertsButonunaTıklanır() {
        dashBoardPage.myAdvertsButton.click();

    }

    @Then("Verilen ilanların listelendiği görülür")
    public void verilenIlanlarinListelendigiGorulur() {

        Assert.assertTrue(dashBoardPage.villageHouse01.isDisplayed());
    }

    //TC02

    @Then("Edit Advert butonuna tıklanır")
    public void editAdvertButonunaTıklar() {
        WaitUtils.waitFor(5);
        dashBoardPage.editAdvertButton.click();
//
//        And My Adverts butonuna tıklanır
//        Then  Edit Advert butonuna tıklanır
//        And Yeni bilgilerle ilan güncellenir(Fiyat 900000 yapılır)
//        And Update butonuna tıklanır
//        Then Günceleme basarıyla tamamlanmıstır mesajı gorulur.
//        And Sayfa kapatılır

    }

    @And("Fiyat 950000 yapılır")
    public void yeniBilgilerleIlanGuncellenir() {

       WaitUtils.waitFor(3);
       WebElement input = dashBoardPage.priceButton;
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys("900000");


    }

    @And("Update butonuna tıklanır")
    public void updateButonunaTiklanir() {
        dashBoardPage.updateButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dashBoardPage.updateButton)
                .click()
                .build()
                .perform();


    }


    @Then("Başarı mesajı gorulur")
    public void guncellemeBasariylaTamamlanmistirMesajiGorulur() {

        Assert.assertTrue("Başarı mesajı görünmedi.", dashBoardPage.mesageButton.isEnabled());


    }

   @And("Fiyat alanına -900000 yazılır")
    public void negatifDegerGirilir() {

       WebElement input = dashBoardPage.priceButton;
       input.sendKeys(Keys.CONTROL + "a");
       input.sendKeys(Keys.DELETE);
       input.sendKeys("-900000");

   }
    @And("Uyarı mesajı gorulur")
    public void uyarıMesajıGorulur() {

        Assert.assertTrue("Başarı mesajı görünmedi.", dashBoardPage.mustBePositive.isEnabled());




    }


   }














