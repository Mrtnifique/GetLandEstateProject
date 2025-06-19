package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.AddsPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddsStepDefinition {
    Actions actions = new Actions( Driver.getDriver() );
    DashBoardPage dashBoardPage = new DashBoardPage();
    LogInPage logInPage = new LogInPage();
    AddsPage addsPage=new AddsPage();
    private By driver;

    @Given("Siteye admin olarak giriş yapılır")
    public void siteyeAdminGirisYapilir() {
        Driver.getDriver().get("http://64.227.123.49");

        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("b307admin@gmail.com");
        logInPage.passwordBox.sendKeys("B307admin@");
        logInPage.loginButton.click();
    }
    @When("Profilime tiklar")
    public void ProfilimeTiklar(){
        AddsPage.ProfileButton.click();

public class AddsStepDefinition {
    @Given("Kullanici {string} olarak giris yapar")
    public void kullaniciOlarakGirisYapar(String arg0) {
    }

    @When("{string}e tiklar")
    public void eTiklar(String arg0) {
      
    }

    @Then("Ilanlarima tiklar")
    public void IlanlarimaTiklar() {
        AddsPage.addsButon.click();
    }

    @And("Kayitli ilanlarim'da duzenleme islemi yapar")
    public void kayitliIlanlarimDaDuzenlemeIslemiYapar() {
      AddsPage.addsChangeButton.click();
      AddsPage.addsActivateButton.click();
        WebElement addsUpdateButton = driver.findElement((SearchContext) By.xpath("(//*[@type='submit'])[1]"));
        actions.moveToElement( addsUpdateButton).click().perform();

    }

    @Then("{guncelleme basarili yazisini goruntuler.")
    public void guncellemeBasariliYazisiniGoruntuler() {

    }

    @And("Ilanlarimda silme islemi yapar")
    public void ılanlarimdaSilmeIslemiYapar() {
        //silip tekrar ilan olusturan bir method lazim
    }

    @And("Silme isleminin basariyla gerceklestigi mesajini goruntuler .")
    public void silmeIslemininBasariylaGerceklestigiMesajiniGoruntuler() {

    }

    @Then("Ilanlarin goruntulendigi sayfada guncelleye tiklar")
    public void ılanlarinGoruntulendigiSayfadaGuncelleyeTiklar() {
        AddsPage.addsChangeButton.click();

    }

    @When("Pasif butonu aktive eder")
    public void pasifButonuAktiveEder() {
        AddsPage.addsActivateButton.click();

    }

    @And("Guncelle butonuna tiklar")
    public void guncelleButonunaTiklar() {
        WebElement addsUpdateButton = driver.findElement((SearchContext) By.xpath("(//*[@type='submit'])[1]"));
        actions.moveToElement( addsUpdateButton).click().perform();


    }

    @Then("Guncelleme basarili mesajini goruntuler")
    public void guncellemeBasariliMesajiniGoruntuler() {

    }

    @When("Guncellenen sayfada butonun aktif oldugu goruntulenir")
    public void guncellenenSayfadaButonunAktifOlduguGoruntulenir() {
      Boolean ButonDogrulama=  driver.getClass(ConfigReader.getProperty(AddsPage.addsUpdateVerifyButton.getText()));
    }

    @And("Arama yapar")
    public void aramaYapar() {
    }

    @And("Arama butonu bulunmamalidir")
    public void aramaButonuBulunmamalidir() {
    }
}
