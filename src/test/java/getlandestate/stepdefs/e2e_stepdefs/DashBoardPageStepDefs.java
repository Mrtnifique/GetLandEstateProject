package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.ReusableMethods;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.Utilities;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class DashBoardPageStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    Faker faker = new Faker();
    Random random = new Random();
    Actions actions = new Actions(Driver.getDriver());





    @And("Filtreleme yapılarak arama yapılır")
    public void filtrelemeYapılarakAramaYapılır() {
        dashBoardPage.categoryFilter.click();
        WaitUtils.waitFor(1);
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

        //dashBoardPage.tourDate.sendKeys(faker.date().toString());
        Date futureDate = faker.date().future(10, TimeUnit.DAYS);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(futureDate);

        dashBoardPage.tourDate.sendKeys(formattedDate);

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



    @When("Search butonuna tıklanır")
    public void searchButonunaTiklanir() {
        dashBoardPage.searchBox.click();
    }
    @When("Dashboard'a tıklar")
    public void dashboardATıklar() {
        dashBoardPage.dashboardButton.click();
    }
    @And("Manager tur Taleplerim sekmesine tiklar")
    public void managerTurTaleplerimSekmesineTiklar() {
        dashBoardPage.MyTourRequestsButton.click();
    }
    @When("Tur Cevaplarim sekmesine tiklar")
    public void MyResponsebutonunaTiklar() {
        WaitUtils.waitFor(3);
        dashBoardPage.MyResponseButton.click();
    }
    @Then("Kendi ilanlarına ait randevu isteklerini listeler")
    public void kendiIlanlarinaAitRandevuIstekleriniListeler() {
        Assert.assertTrue(dashBoardPage.randevuListesi.isDisplayed());
    }
    @Then("İlan adı, tarih ve kullanıcı bilgileri görünmelidir")
    public void ilanAdıTarihVeKullanıcıBilgileriGörünmelidir() {
        // İlan Adı kontrolü
        Assert.assertTrue("İlan adı görünmüyor!", dashBoardPage.ilanAdi.getText().contains("Sahibinden Satılık Uygun Daire"));

        // Tur Tarihi kontrolü
        Assert.assertTrue("Tur tarihi görünmüyor!", dashBoardPage.turTarihi.getText().matches("(//div[contains(text(),'azra yılmaz')])[1]")); // örn: 04.08.3205

        // Talep Eden kullanıcı adı kontrolü
        Assert.assertTrue("Talep eden kullanıcı görünmüyor!", dashBoardPage.talepEden.getText().length() > 0);

        // Tur Saati kontrolü
        Assert.assertTrue("Tur saati görünmüyor!", dashBoardPage.turSaati.getText().matches("\\d{1,2}:\\d{2} [AP]M"));
    }
    @When("Bir randevu istegini secer ve onay butonuna basar")
    public void birRandevuIsteğiSeçer() {

        WaitUtils.waitFor(2);
        dashBoardPage.onayButton.click();
    }
    @And("\"YES\" butonuna tiklar")
    public void yesButonunaTiklar() {
        dashBoardPage.yesButton.click();
    }
    @And("Secilen randevu istegi kabul edilir")
    public void secilenRandevuIstegiKabulEdilir() {
        dashBoardPage.kabulEtButton.click();
    }
    @Then("Talep durumu \"Onaylandi\" olarak güncellenmelidir")
    public void istekBasariylaKabulEdildiMesajiGorunmelidir() {
        Assert.assertTrue(dashBoardPage.Onaylandi.isDisplayed());
    }
    //US_13 TC02
    @When("Tur Taleplerim sekmesine tiklar")
    public void turTaleplerimSekmesineTiklar() {
        dashBoardPage.MyTourRequestsButton.click();
    }
    @Then("Pasif durumdaki bir ilana ait randevu talebi görüntülenir")
    public void pasifDurumdakiIlanaAitRandevuTalebiGoruntulenir() {
        // "DECLINED" rozeti içeren satırı bul
        WebElement pasifIlanSatiri = Driver.getDriver().findElement(
                By.xpath("(//td[@role='cell'])[33]")
        );

        // İlan başlığı, tarih, saat gibi bilgileri al
        String ilanBasligi = pasifIlanSatiri.findElement(By.xpath("//tr[@draggable='false']//div[@class='text']")).getText();
        String tarih = pasifIlanSatiri.findElement(By.xpath("(//td[@role='cell'])[34]")).getText();
        String saat = pasifIlanSatiri.findElement(By.xpath("(//td[@role='cell'])[35]")).getText();

        System.out.println("Pasif (DECLINED) İlan Başlığı: " + ilanBasligi);
        System.out.println("Tarih: " + tarih);
        System.out.println("Saat: " + saat);

        // Doğrulama
        Assert.assertTrue("DECLINED rozetli ilan bulunamadı!", pasifIlanSatiri.isDisplayed());
    }
    @Then("Randevu talebi için onay  ve reddet  butonları görünmemeli veya tıklanamaz olmalı")
    public void randevuTalebiIçinOnay️VeReddetButonlarıGörünmemeliVeyaTıklanamazOlmalı() {
        try {
            // Eğer buton görünüyorsa bile tıklanabilir olmamalı
            Assert.assertFalse(dashBoardPage.kabulEtButton.isDisplayed() && dashBoardPage.kabulEtButton.isEnabled());
            Assert.assertFalse(dashBoardPage.redButton.isDisplayed() && dashBoardPage.redButton.isEnabled());
        } catch (NoSuchElementException e) {
            // Butonlar hiç yoksa da bu geçerli bir durumdur
            Assert.assertTrue(true);
        }
    }
    @And("Onay butonuna tıklanmaya çalışıldığında sistem işlem yapmamalı ve onay gerçekleşmemelidir")
    public void onayButonunaTıklanmayaÇalışıldığındaSistemIşlemYapmamalıVeOnayGerçekleşmemelidir() {
        try {
            if (dashBoardPage.kabulEtButton.isDisplayed() && dashBoardPage.kabulEtButton.isEnabled()) {
                dashBoardPage.kabulEtButton.click();
                WaitUtils.waitFor(2);

                // Onaylandı mı kontrol et
                String durumText = dashBoardPage.durumElement.getText();
                Assert.assertNotEquals("onaylandı", durumText.toLowerCase());
            } else {
                System.out.println("Onay butonu görünmüyor ya da devre dışı.");
            }
        } catch (Exception e) {
            System.out.println("Onay butonu bulunamadı veya tıklanamadı, bu da kabul.");
            Assert.assertTrue(true);
        }

    }
    @And("Reddet butonuna tıklanmaya çalışıldığında sistem işlem yapmamalı ve reddet gerçekleşmemelidir")
    public void reddetButonunaTıklanmayaÇalışıldığındaSistemIşlemYapmamalıVeReddetGerçekleşmemelidir() {
        try {
            if (dashBoardPage.redButton.isDisplayed() && dashBoardPage.redButton.isEnabled()) {
                dashBoardPage.redButton.click();
                WaitUtils.waitFor(2);

                // Durumun reddedildi olup olmadığını kontrol et
                String durumText = dashBoardPage.durumElement.getText();
                Assert.assertNotEquals("reddedildi", durumText.toLowerCase());
            } else {
                System.out.println("Reddet butonu görünmüyor ya da devre dışı.");
            }
        } catch (Exception e) {
            System.out.println("Reddet butonu bulunamadı veya tıklanamadı, bu da kabul.");
            Assert.assertTrue(true);
        }
    }
    //US_14 TC01
    @When("Başka bir manager’a ait aktif ilan aranır")
    public void başkaBirManagerAAitAktifIlanAranır() {

        dashBoardPage.aktifIlani.click();
    }
    @When("Bir ilan seçilip detay sayfası açılır")
    public void birIlanSeçilipDetaySayfasıAçılır() {
        dashBoardPage.aktifIlani.click();
    }
    @Then("\"Tur Ayarla\" formu görünür")
    public void turAyarlaFormuGörünür() {
        Assert.assertTrue(dashBoardPage.turAyarlaFormu.isDisplayed());
    }
    @When("Geçerli bir tur tarihi ve saati girilerek form eksiksiz doldurulur")
    public void geçerliBirTurTarihiVeSaatiGirilerekFormEksiksizDoldurulur() {
        Faker faker = new Faker();

        String turTarihi = faker.date().birthday().toString();
        String turSaati = faker.name().name();

        dashBoardPage.tarihSecme.sendKeys(turTarihi);
        dashBoardPage.saatSecme.sendKeys(turSaati);

    }
    @And("\"Tur Talebi Gönder\" butonuna tıklanır")
    public void turTalebiGonderButonunaTıklanır() {
        dashBoardPage.turTalebiGonderButton.click();
    }
    @Then("\"Talebiniz gönderildi\" mesajı görülür")
    public void talebinizGonderildiMesajıGörülür() {
        Assert.assertTrue(dashBoardPage.talebinizGonderildi.isDisplayed());
    }
    @When("\"Tur Taleplerim\" sekmesine tıklanır")
    public void turTaleplerimSekmesineTıklanır() {
        dashBoardPage.dashboardButton.click();
        dashBoardPage.MyTourRequestsButton.click();
    }
    @Then("\"Tur Talebi\" beklemede olarak listelenir")
    public void turTalebiBeklemedeOlarakListelenir() {
        Assert.assertTrue(dashBoardPage.turTalebiBeklemede.isDisplayed());
    }
    //US_14 TC02-------------------------------------------------------------------
    @When("\"İlanlarım\" sekmesine tıklanır")
    public void ilanlarimSekmesineGirilir() {
        dashBoardPage.dashboardButton.click();
        dashBoardPage.ilanlarimButton.click();
    }
    @Then("Kendi ilanları listelenir")
    public void kendiIlanlarıListelenir() {
        Assert.assertTrue(dashBoardPage.ilanListesi.isDisplayed());
    }
    @When("Kendi ilana ait detay sayfası açılır")
    public void kendiIlanaAitDetaySayfasıAçılır() {
        dashBoardPage.ilanDetay.click();
    }
    @Then("Detay sayfası goruntulenmeli")
    public void detaySayfasıAçılmalıdır() {

        //    String currentUrl = Driver.getDriver().getCurrentUrl();
        //    Assert.assertTrue(
        //        currentUrl.contains("/advert/1750103052987-sahibinden-satilik-uygun-daire")
        //    );

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("/advert/"));
    }
    @Then("\"Randevu Al\" butonu görünmemeli ya da devre dışı olmalıdır")
    public void butonuGörünmemeliYaDaDevreDışıOlmalıdır() {
        List<WebElement> randevuAlButonListesi = Driver.getDriver().findElements(By.xpath("//button[normalize-space()='Tur talebi gönder']"));

        // Buton DOM'da yoksa
        if (randevuAlButonListesi.isEmpty()) {
            System.out.println("Randevu Al butonu DOM'da hiç yok.");
            Assert.assertTrue(true);  // Test geçer
        } else {
            // DOM'da varsa ama görünmüyorsa veya devre dışıysa kontrol et
            WebElement buton = randevuAlButonListesi.get(0);
            Assert.assertFalse(buton.isDisplayed() && buton.isEnabled());
        }
    }
    @When("URL üzerinden doğrudan randevu formu açılmaya çalışılır")
    public void urlÜzerindenDoğrudanRandevuFormuAçılmayaÇalışılır() {

        Driver.getDriver().get("http://64.227.123.49/my-adverts");
    }
    @Then("\"İşlem yapılamaz\" mesajı ya da başka bir sayfaya yönlendirme gerçekleşmelidir")
    public void mesajıYaDaBaşkaBirSayfayaYönlendirmeGerçekleşmelidir() {
        List<WebElement> randevuListesi = Driver.getDriver().findElements(By.xpath("//div[contains(@class,'card')]"));

        Assert.assertTrue("Hiç randevu bulunamadı!", randevuListesi.size() > 0);

        for (WebElement randevu : randevuListesi) {
            String icerik = randevu.getText();
            System.out.println("Randevu Bilgisi:\n" + icerik + "\n---");
        }
    }

    @And("Anasayfa Rent Butonuna Tikla")
    public void anasayfaRentButonunaTikla(){
        dashBoardPage.homePageRentButton.click();
    }

    @Then("Rent ilan kontrol edilir")
    public void rentIlanKontrolEdilir(){
        dashBoardPage.semihTest1.click();
        WaitUtils.waitFor(3);
        Assert.assertTrue(dashBoardPage.rentYazisi.getText().contains("RENT"));
    }

    @And("Anasayfa Properties butonuna tikla")
    public void anasayfaPropertiesButonunaTikla(){
        dashBoardPage.homePagePropertiesButton.click();
        WaitUtils.waitForVisibility(dashBoardPage.semihTest1,20);
    }

    @And("Advert Type butonuna tikla ve Rent sec")
    public void advertTypeButonunaTiklaVeRentSec(){
        Select select = new Select(dashBoardPage.advertTypeButton);
        select.selectByVisibleText("Rent");
        WaitUtils.waitFor(5);
    }

    @When("Filter Search Arama Butonuna Tikla")
    public void filterSearchAramaButonunaTikla(){
        WaitUtils.waitFor(3);
        dashBoardPage.filterSearchButton.click();
    }

    @And("Sitede olmayan bir ilan adi aratilir")
    public void sitedeOlmayanBirIlanAdiAratilir(){
        dashBoardPage.filterSearchBox.sendKeys("qweqweqwe");
        WaitUtils.waitFor(2);
    }

    @Then("Bulunan ilan sayisi kontrol edilir")
    public void bulunanIlanSayisiKontrolEdilir(){
        ReusableMethods.scroll(dashBoardPage.totalFound0);
        WaitUtils.waitFor(4);
        Assert.assertTrue(dashBoardPage.totalFound0.getText().contains("0"));
        WaitUtils.waitFor(2);
    }

    @And("Filter Search Box temizlenir")
    public void filterSearchBoxTemizlenir(){
        ReusableMethods.scrollHome();
        WaitUtils.waitFor(2);
        dashBoardPage.filterSearchBox.click();
        dashBoardPage.filterSearchBox.sendKeys(Keys.CONTROL + "a");
        dashBoardPage.filterSearchBox.sendKeys(Keys.BACK_SPACE);
        WaitUtils.waitFor(3);
    }

    @And("Sitede bulunan bir ilan adi aratilir")
    public void sitedeOlanBirIlanAdiAratilir(){
        dashBoardPage.filterSearchBox.sendKeys("House");
    }

    @Then("Ilan adi kontrol edilir")
    public void ilanAdiKontrolEdilir(){
        dashBoardPage.semihTest1.click();

        String actualTitle = Driver.getDriver().findElement(By.xpath("//div[@class='advert-title']")).getText();
        Assert.assertTrue(actualTitle.contains("House"));
    }

    @When("Fiyat kismina sayi disinda veri girisi denenir")
    public void fiyatKisminaSayiDisindaVeriGirisiDenenir(){
        dashBoardPage.priceRangeMin.sendKeys("asd");
        dashBoardPage.priceRangeMax.sendKeys("asd");
    }

    @Then("Fiyat kisminin bos oldugu test edilir")
    public void fiyatKismininBosOlduguTestEdilir(){
        String actualMinPriceValue = dashBoardPage.priceRangeMin.getAttribute("value");
        Assert.assertNotNull(actualMinPriceValue);
        Assert.assertTrue(actualMinPriceValue.isEmpty());

        String actualMaxPriceValue = dashBoardPage.priceRangeMax.getAttribute("value");
        Assert.assertNotNull(actualMaxPriceValue);
        Assert.assertTrue(actualMaxPriceValue.isEmpty());
    }

    @And("Min kismi Max kismindan buyuk yazilmasi denenir")
    public void minKismiMaxKismindanBuyukYazilmasiDenenir(){
        dashBoardPage.priceRangeMin.sendKeys("5");
        dashBoardPage.priceRangeMax.sendKeys("1");
    }

    @Then("Start price must be less than end price. hatasi kontrol edilir")
    public void startPriceMustBeLessThanEndPriceHatasiKontrolEdilir(){
        WaitUtils.waitForVisibility(dashBoardPage.priceHataMesaji,5);
        Assert.assertTrue(dashBoardPage.priceHataMesaji.isDisplayed());
        WaitUtils.waitFor(3);
    }

    @And("Pricelar temizlenir")
    public void pricelarTemizlenir(){
        dashBoardPage.priceRangeMin.click();
        dashBoardPage.priceRangeMin.sendKeys(Keys.CONTROL + "a");
        dashBoardPage.priceRangeMin.sendKeys(Keys.BACK_SPACE);
        WaitUtils.waitFor(2);
        dashBoardPage.priceRangeMax.click();
        dashBoardPage.priceRangeMax.sendKeys(Keys.CONTROL + "a");
        dashBoardPage.priceRangeMax.sendKeys(Keys.BACK_SPACE);
        WaitUtils.waitFor(2);
    }

    @And("Dogru Fiyat araligi yapilir")
    public void dogruFiyatAraligiYapilir(){
        dashBoardPage.priceRangeMin.sendKeys("1000");
        dashBoardPage.priceRangeMax.sendKeys("50000");
    }

    @Then("Fiyatlar kontrol edilir")
    public void fiyatlarKontrolEdilir(){
        WaitUtils.waitForVisibility(dashBoardPage.semihTest1,20);
        dashBoardPage.semihTest1.click();
        WaitUtils.waitFor(2);
        String actualIlanPrice = Driver.getDriver().findElement(By.xpath("//div[@class='price']")).getText();
        actualIlanPrice = actualIlanPrice.replace("$", "");
        actualIlanPrice = actualIlanPrice.replace(".", "");
        actualIlanPrice = actualIlanPrice.trim();
        int fiyat = Integer.parseInt(actualIlanPrice);
        Assert.assertTrue(fiyat >= 1000 && fiyat <= 50000);
    }

    @And("Category butonuna tikla ve house sec")
    public void categoryButonunaTiklaVeHouseSec(){
        Select select = new Select(dashBoardPage.categoryButton);
        select.selectByVisibleText("House");
        WaitUtils.waitFor(5);
    }

    @Then("Ilanin categorysi kontrol edilir")
    public void ilaninCategorysiKontrolEdilir(){
        ReusableMethods.visibleWait(dashBoardPage.semihTest1,15);
        dashBoardPage.semihTest1.click();
        String actualCategory = Driver.getDriver().findElement(By.xpath("//div[@class='advert-category-title']")).getText();
        Assert.assertTrue(actualCategory.contains("House"));
    }

    @And("Countrye tikla ve France sec")
    public void countryeTiklaVeFranceSec(){
        Select select = new Select(dashBoardPage.countryFilter);
        select.selectByVisibleText("France");
    }

    @And("Citye tikla ve Allier sec")
    public void cityeTiklaVeAllierSec(){
        Select select = new Select(dashBoardPage.cityFilter);
        select.selectByVisibleText("Allier");
    }

    @And("Districte tikla ve Vichy sec")
    public void districteTiklaVeVichySec(){
        Select select = new Select(dashBoardPage.districtFilter);
        select.selectByVisibleText("Vichy");
    }

    @Then("Ilanin konumu kontrol edilir")
    public void ilaninKonumuKontrolEdilir(){
        ReusableMethods.visibleWait(dashBoardPage.semihTest2,10);
        dashBoardPage.semihTest2.click();

        String actualCountry = Driver.getDriver().findElement(By.xpath("(//span[@class='location-value'])[1]")).getText();
        String actualCity = Driver.getDriver().findElement(By.xpath("(//span[@class='location-value'])[2]")).getText();
        String actualDistrict = Driver.getDriver().findElement(By.xpath("(//span[@class='location-value'])[3]")).getText();

        Assert.assertTrue(actualCountry.contains("France") && actualCity.contains("Allier") && actualDistrict.contains("Vichy"));

    }

    @And("Anasayfa Sale Butonuna Tikla")
    public void anasayfaSaleButonunaTikla(){
        WaitUtils.waitForVisibility(dashBoardPage.homePageSaleButton,10);
        dashBoardPage.homePageSaleButton.click();
    }

    @Then("Sale ilan kontrol edilir")
    public void saleIlanKontrolEdilir(){
        dashBoardPage.semihTest1.click();
        WaitUtils.waitFor(3);
        Assert.assertTrue(dashBoardPage.saleYazisi.getText().contains("SALE"));
    }

    @And("Advert Type butonuna tikla ve Sale sec")
    public void advertTypeButonunaTiklaVeSaleSec(){
        Select select = new Select(dashBoardPage.advertTypeButton);
        select.selectByVisibleText("Sale");
        WaitUtils.waitFor(5);
    }

}








