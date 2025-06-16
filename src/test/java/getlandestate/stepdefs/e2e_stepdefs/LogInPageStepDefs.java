package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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
    }

