package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.ControlPanelPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class ControlPanelStepDefs {
    Faker faker = new Faker();
    String randomWord = faker.book().title();


    @And("Yeni kategori eklenir")
    public void yeniKategoriEklenir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();

        controlPanelPage.categoriesAddNewButton.click();
        controlPanelPage.categoriesAddNewTitleBox.sendKeys("OhBoyWhataUniqueName");
        controlPanelPage.categoriesAddNewSequenceBox.sendKeys("3");
        controlPanelPage.categoriesAddNewIconBox.sendKeys("house");
        controlPanelPage.categoriesAddNewCreateButton.click();

    }

    @When("Categories butonuna tıklanır")
    public void categoriesButonunaTiklanir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();
        controlPanelPage.categoriesButton.click();
    }

    @Then("Kategorinin eklenmiş olması test edilir")
    public void kategorininEklenmişOlmasıTestEdilir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();
        Driver.getDriver().navigate().refresh();

        controlPanelPage.categoriesButton.click();
        controlPanelPage.categoriesSearchBox.sendKeys("OhBoyWhataUniqueName");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        Assert.assertTrue(controlPanelPage.muratAssertionData.isDisplayed());
        controlPanelPage.categoriesFirstCategoryDeleteButton.click();
        controlPanelPage.categoriesDeleteButtonConfirmButton.click();
        WaitUtils.waitFor(3);

    }

    @When("Advert types butonuna tıklanır")
    public void advertTypesButonunaTıklanır() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();
        controlPanelPage.advertTypeButton.click();
    }

    @And("Yeni advert type eklenir")
    public void yeniAdvertTypeEklenir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();

        controlPanelPage.categoriesAddNewButton.click();
        controlPanelPage.categoriesAddNewTitleBox.sendKeys(randomWord);
        controlPanelPage.advertTypeCreateButton.click();

    }

    @Then("Advert type eklenmiş olması test edilir")
    public void advertTypeEklenmişOlmasıTestEdilir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();

        controlPanelPage.categoriesSearchBox.sendKeys(randomWord);
        controlPanelPage.advertTypeSearchButton.click();
        controlPanelPage.advertTitleEditButton.click();
        Assert.assertEquals(randomWord, controlPanelPage.firstAdvertTitle.getDomProperty("value"));


    }

    @When("Users butonuna tıklanır")
    public void usersButonunaTıklanır() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();

        controlPanelPage.usersButton.click();
    }

    @Then("Kullanıcı aratılabilirliği test edilir")
    public void kullanıcıAratılabilirliğiTestEdilir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();

        controlPanelPage.categoriesSearchBox.sendKeys("Agent47");
        controlPanelPage.categoriesSearchBoxSearchButton.click();
        Assert.assertTrue(controlPanelPage.muratAssertionData2.isDisplayed());
    }

    @And("Kullanıcı rolü ve bilgileri güncellenir")
    public void kullanıcıRolüVeBilgileriGüncellenir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();
        controlPanelPage.usersEditButton.click();

        Select selectRole = new Select(controlPanelPage.userRole);
        selectRole.selectByIndex(1);
        controlPanelPage.userEditUpdateButton.click();
        WaitUtils.waitFor(2);
    }

    @Then("Kullanıcı bilgilerinin güncellenebilirliği test edilir")
    public void kullanıcıBilgilerininGüncellenebilirliğiTestEdilir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();
        Driver.getDriver().navigate().refresh();
        controlPanelPage.categoriesSearchBox.sendKeys("Agent47");
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
