package getlandestate.stepdefs.ui_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;

import java.time.Duration;


public class LogInPageStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    LogInPage logInPage = new LogInPage();

    @Given("Siteye admin olarak giriş yapılır")
    public void siteyeAdminGirisYapilir() {

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

    @When("Login butonuna tıklanır")
    public void loginButonunaTıklanır() {
        LogInPage logInPage = new LogInPage();
        logInPage.loginButton.click();
    }

    @When("Manager hesabı ile sisteme giriş yapılır18")
    public void managerHesabıileSistemeGirişYapılır18() {
        LogInPage logInPage = new LogInPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
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

        DashBoardPage dashBoardPage = new DashBoardPage();
        LogInPage logInPage = new LogInPage();

        logInPage.loginButton1.click();

        logInPage.emailBox.sendKeys("cemsit@gmail.com");
        logInPage.passwordBox.sendKeys("123Cemsit.");
        logInPage.loginButton.click();
    }


    @Given("Siteye {string} username {string} password ile giriş yapılır")
    public void siteyeUsernamePasswordIleGirişYapılır(String username, String password) {
        Driver.getDriver().get("http://64.227.123.49");
        dashBoardPage.loginButton.click();
    }


    @Given("siteye manager olarak giriş yapılır")
    public void siteyeManagerOlarakGirişYapılır() {

        Driver.getDriver().get("http://64.227.123.49");

        DashBoardPage dashBoardPage = new DashBoardPage();
        LogInPage logInPage = new LogInPage();

        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("cemsit@gmail.com");
        logInPage.passwordBox.sendKeys("123Cemsit.");
        logInPage.loginButton.click();


    }

    //Customer registerle Login olmalı
    Faker faker = new Faker();
    LogInPage registerLogin = new LogInPage();

    @Given("Web seyfesine get")
    public void webSeyfesineGet() {
        Driver.getDriver().get("http://64.227.123.49");
    }

    @When("Register seyfesine daxil olmali")
    public void registerSeyfesineDaxilOlmali() {
        registerLogin.RegisterButton.click();
    }

    @Then("Ad, Soyad ve telefon nomresi yazmali")
    public void adSoyadVeTelefonNomresiYazmali() {
        Duration.ofSeconds(5);
        registerLogin.firstname.sendKeys("Cavid");
        registerLogin.lastname.sendKeys("Qarayev");
        registerLogin.phone.sendKeys(faker.phoneNumber().phoneNumber());
    }

    @Then("Dogru email yazmali")
    public void dogruEmailYazmali() {
        registerLogin.emailBox.sendKeys("cavid88@mail.ru");
    }

    @Then("Dogru password yazmali")
    public void dogruPasswordYazmali() {
        registerLogin.passwordBox.sendKeys("1514Ruhin.");
        registerLogin.confirmPassword.sendKeys("1514Ruhin.");
    }

    @And("Register olmali")
    public void registerOlmali() {
        registerLogin.Register.click();
    }

    @And("Customer olaraq qeyd olmali")
    public void customerOlaraqQeydOlmali() {
        Assert.assertTrue("Customer olaraq qeyd olmali", registerLogin.Register.isDisplayed());
    }

    @Then("Ad, Soyad ve telefon nomresi xetali yazmali")
    public void adSoyadVeTelefonNomresiXetaliYazmali() {
        Duration.ofSeconds(5);
        String invalidFirstName = "Samir";
        String invalidLastName = "Aslanov";
        String invalidPhoneNumber = "1234567890";
        registerLogin.firstname.sendKeys(invalidFirstName);
        registerLogin.lastname.sendKeys(invalidLastName);
        registerLogin.phone.sendKeys(invalidPhoneNumber);
    }

    @Then("Fake email yazmali")
    public void fakeEmailYazmali() {
        faker.internet().emailAddress();
    }

    @Then("Fake password yazmali")
    public void fakePasswordYazmali() {
        faker.internet().password();
    }

    @And("Register olmamali")
    public void registerOlmamali() {
        registerLogin.Register.click();
    }

    @And("Customer olaraq qeyd olmamali")
    public void customerOlaraqQeydOlmamali() {
        Assert.assertTrue("Customer olaraq qeyd olmamali", registerLogin.Register.isDisplayed());
    }


}


