package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class ControlPanelStepDefs {
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
        WaitUtils.waitFor(5);

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
}
