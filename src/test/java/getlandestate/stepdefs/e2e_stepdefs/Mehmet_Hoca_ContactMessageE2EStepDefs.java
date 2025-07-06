package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.ContactMessageE2EPage;
import getlandestate.pojos.Mehmet_Hocanin_POJOsu;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.DBUtils;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static getlandestate.base_url.BaseUrl.spec;
import static getlandestate.utilities.WaitUtils.waitForClickablility;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Mehmet_Hoca_ContactMessageE2EStepDefs {
    Response response;
    Mehmet_Hocanin_POJOsu payload;
    Connection connection;

    @Given("{string}, {string},{string},{string}, ile Yeni bir mesaj olusturulur")
    public void ileYeniBirMesajOlusturulur(String firstName, String lastName, String email, String message) {
        spec.pathParam("first", "contact-messages");
        payload = new Mehmet_Hocanin_POJOsu(firstName, lastName, email, message, true);
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

    }

    @Then("status code {int} oldugu dogrulanir end to end")
    public void statusCodeOlduguDogrulanirEndToEnd(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("contact message basarili bir sekilde olusturuldugu test edilir end to end")
    public void contactMessageBasariliBirSekildeOlusturulduguTestEdilirEndToEnd() {
        String expectedMessage = "Contact message saved successfully.";
        String actualMessage = response.asString();
        assertEquals(expectedMessage, actualMessage);
    }


    @Given("admin ana sayfaya gider")
    public void girişSayfasında() {
        //String url= "http://64.227.123.49/";
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WaitUtils.waitForPageToLoad(1); // Sayfanın yüklenmesini beklemek için 3 saniye
    }

    @When("admin olarak {string} ve {string} bilgileri ile login olur")
    public void adminOlarakVeBilgileriIleLoginOlur(String email, String password) {
        ContactMessageE2EPage contactMessageE2EUI = new ContactMessageE2EPage();
        waitForClickablility(contactMessageE2EUI.loginLink, 3);
        contactMessageE2EUI.loginLink.click();
        WaitUtils.waitForVisibility(contactMessageE2EUI.emailBox, 3);
        contactMessageE2EUI.emailBox.click();
        contactMessageE2EUI.emailBox.sendKeys(email);
        contactMessageE2EUI.passwordBox.sendKeys(password);
        contactMessageE2EUI.accountLoginButton.click();
    }

    @And("Dashboard'da Contact Messages linkine tıklar")
    public void dashboardDaContactMessagesLinkineTıklar() {
        ContactMessageE2EPage contactMessageE2EUI = new ContactMessageE2EPage();
        waitForClickablility(contactMessageE2EUI.contactMessageLink, 10);
        contactMessageE2EUI.contactMessageLink.click();
    }

    @Then("admin contact message da {string} metnini dogrular")
    public void adminContactMessageDaMetniniDogrular(String message) {
        ContactMessageE2EPage contactMessageE2EUI = new ContactMessageE2EPage();
        WaitUtils.waitForVisibility(contactMessageE2EUI.emailButtonFirst, 5);
        contactMessageE2EUI.emailButtonFirst.click();
        WaitUtils.waitForVisibility(contactMessageE2EUI.messageTextFirst, 5);
        assertTrue(contactMessageE2EUI.messageTextFirst.getText().contains(message));
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Given("kullanici database e baglanir")
    public void kullaniciDatabaseEBaglanir() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://64.227.123.49:5432/prettierhomes", "techprotester", "myPassword");
    }

    @Then("girilen {string}, {string}, {string}, {string} bilgiler database uzerinden dogrulanir")
    public void girilenBilgilerDatabaseUzerindenDogrulanir(String firstName, String lastName, String email, String message) throws SQLException {
        String sql = "Select email, first_name, last_name, message" + " from contacts" + " ORDER BY id DESC" + " LIMIT 1";
        connection.createStatement().executeQuery(sql);
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        resultSet.next();
        Assert.assertEquals(email, resultSet.getString("email"));
        Assert.assertEquals(firstName, resultSet.getString("first_name"));
        Assert.assertEquals(lastName, resultSet.getString("last_name"));
        Assert.assertEquals(message, resultSet.getString("message"));
    }

    @And("database baglantisi kapatilir")
    public void databaseBaglantisiKapatilir() {
        DBUtils.closeConnection();
    }
}
