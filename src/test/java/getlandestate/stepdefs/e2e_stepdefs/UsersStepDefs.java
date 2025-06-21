package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersStepDefs {

    ControlPanelPage controlPanelPage = new ControlPanelPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    LogInPage logInPage = new LogInPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @And("Arama kutusuna yildiz isilti yazilir")
    public void aramaKutusunaYildizIsiltiYazilir() {
        //controlPanelPage.userSearchBox.click();
        WaitUtils.waitFor(3);
        controlPanelPage.categoriesSearchBox.sendKeys("yildiz");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(controlPanelPage.yildizDisplayed.isDisplayed());
    }

    @And("Ilgili kullanicinin yanindaki kalem kutucuguna tiklanir")
    public void ılgiliKullanicininYanindakiKalemKutucugunaTiklanir() {
        controlPanelPage.penButton.click();
    }

    @And("Roles kismindan admin secilir")
    public void rolesKismindanAdminSecilir() {
        controlPanelPage.userRole.sendKeys("ADMIN");
    }

    @And("Update butonuna tiklanir")
    public void updateButonunaTiklanir() {
        controlPanelPage.userUpdateButton.click();
    }

    @Then("Kullanicinin rolunun basariyla admin olarak guncellendigi dogrulanir")
    public void kullanicininRolununBasariylaAdminOlarakGuncellendigiDogrulanir() {
        controlPanelPage.categoriesSearchBox.sendKeys("yildiz");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        WaitUtils.waitFor(2);

        String actualResult = controlPanelPage.userRoleText.getText();
        String expectedResult = "ADMIN";
        Assert.assertEquals(expectedResult, actualResult);
        WaitUtils.waitFor(2);

        //Teardown
        controlPanelPage.usersEditButton.click();
        Select selectRole = new Select(controlPanelPage.userRole);
        selectRole.selectByIndex(2);
        controlPanelPage.userEditUpdateButton.click();
        WaitUtils.waitFor(2);
    }
    @And("Arama kutusuna Lady Yildiz yazilir")
    public void aramaKutusunaLadyYildizYazilir() {
        controlPanelPage.categoriesSearchBox.sendKeys("Lady");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(controlPanelPage.ladyYildizDisplayed.isDisplayed());
}
    @And("Ilgili kullanicinin yanindaki pen kutucuguna tiklanir")
    public void ılgiliKullanicininYanindakiPenKutucugunaTiklanir() {
        Assert.assertTrue(controlPanelPage.ladyYildizDisplayed.isDisplayed());
        controlPanelPage.penButton.click();
    }

    @And("Roles kismindan manager secilir")
    public void rolesKismindanManagerSecilir() {
        controlPanelPage.userRole.sendKeys("MANAGER");
    }

    @Then("Kullanicinin rolunun basariyla manager olarak guncellendigi assert edilir")
    public void kullanicininRolununBasariylaManagerOlarakGuncellendigiAssertEdilir() {
        controlPanelPage.categoriesSearchBox.sendKeys("Lady");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        WaitUtils.waitFor(2);

        String actualResult = controlPanelPage.userRoleText.getText();
        String expectedResult = "MANAGER";
        Assert.assertEquals(expectedResult, actualResult);
        WaitUtils.waitFor(2);

        //Teardown
        controlPanelPage.usersEditButton.click();
        Select selectRole = new Select(controlPanelPage.userRole);
        selectRole.selectByIndex(2);
        controlPanelPage.userEditUpdateButton.click();
        WaitUtils.waitFor(2);
    }

   /* @Given("Siteye manager olarak giris yapilir")
    public void siteyeManagerOlarakGirisYapilir() {
        Driver.getDriver().get("http://64.227.123.49");
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("venusnonova@gmail.com");
        logInPage.passwordBox.sendKeys("Venus11Nova*");
        logInPage.loginButton.click();
    }*/

    @And("Search boxtan ilgili admin kullanici aranir")
    public void searchBoxtanIlgiliAdminKullaniciAranir() {
        WaitUtils.waitFor(3);
        controlPanelPage.categoriesSearchBox.sendKeys("scarlett");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(controlPanelPage.scarlettDisplayed.isDisplayed());
    }

    @And("Roles kismindan customer secilir")
    public void rolesKismindanCustomerSecilir() {
        controlPanelPage.userRole.sendKeys("CUSTOMER");
    }

    @Then("Kullanicinin rolunun customer olarak guncellenmedigi dogrulanir")
    public void kullanicininRolununCustomerOlarakGuncellenmedigiDogrulanir() {
        wait.until(ExpectedConditions.visibilityOf(controlPanelPage.errorMessage));
        Assert.assertTrue(controlPanelPage.errorMessage.isDisplayed());
    }
}
