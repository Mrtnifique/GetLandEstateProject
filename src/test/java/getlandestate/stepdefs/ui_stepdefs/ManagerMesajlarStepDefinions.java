package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ManagerMesajlarStepDefinions {
    LogInPage logInPage = new LogInPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
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
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("venusnonova@gmail.com");
        logInPage.passwordBox.sendKeys("Venus11Nova*");
        logInPage.loginButton.click();


    }

    @When("ContactMessages butonuna tıkla")
    public void contact_messages_butonuna_tıkla() {
        logInPage.contactMessgeButonu.click();
    }
    @When("Messajlarda arama yap")
    public void messajlarda_arama_yap() {
        logInPage.contactMessageAramaButonu.sendKeys("fustun@ggmail.com");
        logInPage.contactMesssageSearchButonu.click();

    }

    @Then("Manager ContactMessages görebildiğini doğrula")
    public void manager_contact_messages_görebildiğini_doğrula() {
        Assert.assertTrue(logInPage.aradıgimizMesaj.getText().contains("fustun@ggmail.com"));



    }



}