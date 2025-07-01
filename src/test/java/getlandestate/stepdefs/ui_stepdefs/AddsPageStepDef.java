package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.AddsPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;


public class AddsPageStepDef {

    DashBoardPage dashBoardPage = new DashBoardPage();
    LogInPage logInPage = new LogInPage();

    AddsPage addsPage = new AddsPage();

    @Given("kullanıcı ilanlar sayfasındadır")
    public void kullanıcıIlanlarSayfasındadır() {

        addsPage.addsOnAdverts.click();

    }

    @When("arama çubuğuna {string} yazılarak arama yapılır")
    public void aramaÇubuğunaYazılarakAramaYapılır(String arg0) {


        addsPage.searchBoxOnAdverts.sendKeys("seferihisar", Keys.ENTER);
        addsPage.searchButtonOnAdverts.submit();

    }

    @Then("sistem {string} ile ilgili ilanları listelemelidir")
    public void sistemIleIlgiliIlanlarıListelemelidir(String arg0) {
        Assert.assertTrue(addsPage.seferihisarAddVerify.getText().contains("seferihisar"));

    }


    @Then("arama çubugunun başarılı bir şekilde çalıştığı doğrulanır")
    public void aramaÇubugununBaşarılıBirŞekildeÇalıştığıDoğrulanır() {

        System.out.println("Arama cubugu basarili sekilde calisiyor");
    }

    @When("Aratma kutusuna Seferihisar yazıp aratılır")
    public void aratmaKutusunaSeferihisarYazıpAratılır() {

        addsPage.searchBoxOnAdverts.sendKeys("seferihisar", Keys.ENTER);
        addsPage.searchButtonOnAdverts.submit();

    }

    @And("Sayfada görüntülenen ilanın işlem menüsünden güncelleme butonuna basılır")
    public void sayfadaGörüntülenenIlanınIşlemMenüsündenGüncellemeButonunaBasılır() {

        addsPage.updateButtonOnAdverts.submit();
    }

    @Then("ilanın durum ddm den aktif seçeneği seçilir ve güncellenir")
    public void ilanınDurumDdmDenAktifSeçeneğiSeçilirVeGüncellenir() {

        Select durumSelect = new Select(addsPage.situationActiveButton);
        durumSelect.selectByVisibleText("Aktif");
        addsPage.updateButtonOnEdit.submit();
    }

    @Then("İlanın aktif olduğu doğrulanır")
    public void i̇lanınAktifOlduğuDoğrulanır() {

        Select durumSelect = new Select(addsPage.situationActiveButton);
        Assert.assertTrue(addsPage.seferihisarActiveVerify.isEnabled());

    }

    @When("Aratma kutusuna Bungalow yazıp aratılır")
    public void aratmaKutusunaBungalowYazıpAratılır() {

        addsPage.searchBoxOnAdverts.sendKeys("Bungalow", Keys.ENTER);
        addsPage.searchButtonOnAdverts.submit();
    }

    @When("İşlem başarılı şekilde güncellendi mesajı doğrulanır")
    public void i̇şlemBaşarılıŞekildeGüncellendiMesajıDoğrulanır() {

        Assert.assertTrue(addsPage.updateSuccesfulMessage.isEnabled());

    }

    @Then("ilanın durum ddm den Reddedildi seçeneği seçilir ve güncellenir")
    public void ilanınDurumDdmDenReddedildiSeçeneğiSeçilirVeGüncellenir() {

        Select durumSelect = new Select(addsPage.situationActiveButton);
        durumSelect.selectByVisibleText("Reddedildi");
        addsPage.updateButtonOnEdit.submit();

    }

    @Then("İlanın Reddedildi olduğu doğrulanır")
    public void i̇lanınReddedildiOlduğuDoğrulanır() {


        Assert.assertTrue(addsPage.statusRejectedButton.isEnabled());
    }
}