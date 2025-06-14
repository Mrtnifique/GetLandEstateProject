package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ControlPanelStepDefs {
    @And("Yeni kategori eklenir")
    public void yeniKategoriEklenir() {

    }

    @When("Categories butonuna tıklanır")
    public void categoriesButonunaTiklanir() {
        ControlPanelPage controlPanelPage = new ControlPanelPage();
        controlPanelPage.categoriesButton.click();
        WaitUtils.waitFor(5);

    }

    @Then("Kategorinin eklenmiş olması test edilir")
    public void kategorininEklenmişOlmasıTestEdilir() {
    }
}
