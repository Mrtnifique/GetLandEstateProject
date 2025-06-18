package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.AddsPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class AddsStepDefinition {
    Actions actions = new Actions( Driver.getDriver() );
    DashBoardPage dashBoardPage = new DashBoardPage();
    LogInPage logInPage = new LogInPage();
    AddsPage addsPage=new AddsPage();
    @Given("Siteye admin olarak giriş yapılır")
    public void siteyeAdminGirisYapilir() {
        Driver.getDriver().get("http://64.227.123.49");

        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("b307admin@gmail.com");
        logInPage.passwordBox.sendKeys("B307admin@");
        logInPage.loginButton.click();
    }
    @When("{string}e tiklar")
    public void eTiklar(String arg0) {
        AddsPage.ProfileButton.click();
    }

    @Then("{string} a tiklar")
    public void aTiklar(String arg0) {
    }

    @And("Kayitli ilanlarim'da duzenleme islemi yapar")
    public void kayitliIlanlarimDaDuzenlemeIslemiYapar() {
    }

    @Then("{string} yazisini goruntuler.")
    public void guncellemeBasariliYazisiniGoruntuler() {
    }

    @And("Ilanlarimda silme islemi yapar")
    public void ılanlarimdaSilmeIslemiYapar() {
    }

    @And("Silme isleminin basariyla gerceklestigi mesajini goruntuler .")
    public void silmeIslemininBasariylaGerceklestigiMesajiniGoruntuler() {
    }

    @Then("Ilanlarin goruntulendigi sayfada guncelleye tiklar")
    public void ılanlarinGoruntulendigiSayfadaGuncelleyeTiklar() {
    }

    @When("Pasif butonu aktive eder")
    public void pasifButonuAktiveEder() {
    }

    @And("Guncelle butonuna tiklar")
    public void guncelleButonunaTiklar() {
    }

    @Then("Guncelleme basarili mesajini goruntuler")
    public void guncellemeBasariliMesajiniGoruntuler() {
    }

    @When("Guncellenen sayfada butonun aktif oldugu goruntulenir")
    public void guncellenenSayfadaButonunAktifOlduguGoruntulenir() {
    }

    @And("Arama yapar")
    public void aramaYapar() {
    }

    @And("Arama butonu bulunmamalidir")
    public void aramaButonuBulunmamalidir() {
    }
}
