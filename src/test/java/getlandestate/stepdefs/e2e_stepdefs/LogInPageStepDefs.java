package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LogInPageStepDefs {
    @Given("Siteye admin olarak giriş yapılır")
    public void siteyeAdminGirisYapilir() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        LogInPage logInPage = new LogInPage();
        Driver.getDriver().get("http://64.227.123.49");

        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("b307admin@gmail.com");
        logInPage.passwordBox.sendKeys("B307admin@");
        logInPage.loginButton.click();
    }

    @And("Sayfa kapatılır")
    public void sayfaKapatılır() {
        Driver.closeDriver();
    }

    @Given("Web adresine gidilir")
    public void webAdresineGidilir() {
        Driver.getDriver().get("http://64.227.123.49");



}

    @Given("Customer olarak sayfaya giris yapılır")
    public void customerOlarakSayfayaGirisYapılır() {
        LogInPage logInPage = new LogInPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        Driver.getDriver().get("http://64.227.123.49");
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("bilen@cimail.com");
        logInPage.passwordBox.sendKeys("Aa123456.");


    }
}

    @When("Login butonuna tıklanır")
    public void loginButonunaTıklanır() {
        LogInPage logInPage = new LogInPage();
        logInPage.loginButton.click();
    }
}

