package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class UsersStepDefs {

    ControlPanelPage controlPanelPage = new ControlPanelPage();

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
}
