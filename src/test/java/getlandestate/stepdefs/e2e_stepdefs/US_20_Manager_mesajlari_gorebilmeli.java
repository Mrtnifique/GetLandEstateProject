package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Wait;


public class US_20_Manager_mesajlari_gorebilmeli {
    LogInPage logInPage = new LogInPage();

    @When("sitesiye git")
    public void sitesiye_git() {
        Driver.getDriver().get("http://64.227.123.49/");
    }

    @When("Mail Us butonuna tıkla")
    public void mail_us_butonuna_tıkla() {
        logInPage.bizeMailAtinBox.click();

    }

    @When("Kutuları doldur")
    public void kutuları_doldur() {
        logInPage.bizeMailAd.sendKeys("Fatih");
        logInPage.bizeMailSoyad.sendKeys("Üstün");
        logInPage.bizeMailEmail.sendKeys("fustun@ggmail.com");
        logInPage.bizeMailMesaj.sendKeys("Test mesajı");
    }

    @When("Send butonuna tıkla")
    public void send_butonuna_tıkla() {
        logInPage.bizeMailGonderButonu.click();
    }

    @When("Manager girisi yapar")
    public void manager_girisi_yapar() {

    }

    @When("ContactMessages butonuna tıkla")
    public void contact_messages_butonuna_tıkla() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Mesajlardan birincisine tıkla")
    public void mesajlardan_birincisine_tıkla() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Mesajın mail adresini ve tarihini al")
    public void mesajın_mail_adresini_ve_tarihini_al() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Mesajı text olarak al")
    public void mesajı_text_olarak_al() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Manager ContactMessages görebildiğini doğrula")
    public void manager_contact_messages_görebildiğini_doğrula() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("mesajımızdaki test datalarıyla aynı olmalı")
    public void mesajımızdaki_test_datalarıyla_aynı_olmalı() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}