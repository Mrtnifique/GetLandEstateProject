package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogInPageStepDefs {
    private static final Log log = LogFactory.getLog(LogInPageStepDefs.class);
    LogInPage logInPage = new LogInPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

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
        Driver.getDriver().get("http://64.227.123.49");
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("bilen@cimail.com");
        logInPage.passwordBox.sendKeys("Aa123456.");

    }

    @When("Login butonuna tıklanır")
    public void loginButonunaTıklanır() {
        logInPage.loginButton.click();
    }

    @When( "Manager hesabı ile sisteme giriş yapılır18")
    public void managerHesabıileSistemeGirişYapılır18() {
        Driver.getDriver().get("http://64.227.123.49");
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("selinneliff0@gmail.com");
        logInPage.passwordBox.sendKeys("A7979a,0");
        logInPage.loginButton.click();
        WaitUtils.waitFor(3);

    }

    @Given("Siteye manager olarak giris yapilir")
    public void siteyeManagerOlarakGirisYapilir() {
        Driver.getDriver().get("http://64.227.123.49");

        logInPage.loginButton1.click();

        logInPage.emailBox.sendKeys("cemsit@gmail.com");
        logInPage.passwordBox.sendKeys("123Cemsit.");
        logInPage.loginButton.click();
    }

    @Given("Siteye {string} username {string} password ile giriş yapılır")
    public void siteyeUsernamePasswordIleGirişYapılır(String username, String password) {
        Driver.getDriver().get("http://64.227.123.49");
        logInPage.loginButton.click();

        logInPage.emailBox.sendKeys(username);
        logInPage.passwordBox.sendKeys(password);
        logInPage.loginButton.click();

    }

    @Given("Manager olarak sayfaya giris yapılır")
    public void siteyeManagerGirisYapilir() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        LogInPage logInPage = new LogInPage();
        Driver.getDriver().get("http://64.227.123.49");

        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("davidbeckham@gmail.com");
        logInPage.passwordBox.sendKeys("Davidbeckham35.");
        logInPage.loginButton.click();
    }












}

