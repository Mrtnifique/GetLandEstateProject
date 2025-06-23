package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AdminMessagesStepDefinition {
    DashBoardPage dashBoardPage = new DashBoardPage();
    LogInPage logInPage = new LogInPage();

    @When("Admin girisi yapar")
    public void admin_girisi_yapar() {
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("b307admin@gmail.com");
        logInPage.passwordBox.sendKeys("B307admin@");
        logInPage.loginButton.click();
   }
    @When("Customer girisi yap")
    public void customer_girisi_yap() {
        dashBoardPage.loginButton.click();
        logInPage.emailBox.sendKeys("fatihcustomer@gmail.com");
        logInPage.passwordBox.sendKeys("77Af816-");
        logInPage.loginButton.click();
        WaitUtils.waitFor(5);
    }

    @When("customer profil menusune tıkla")
    public void customer_profil_menusune_tıkla() {
       logInPage.customerMenuButonu.click();
    }

    @Then("Control panel seçeneğinin olmadığını doğrula")
    public void control_panel_seçeneğinin_olmadığını_doğrula() {
        Assert.assertFalse(logInPage.customerMenuMyProfile.getText().contains("Control Panel"));
        Assert.assertFalse(logInPage.customerMenuMyAdverts.getText().contains("Control Panel"));
        Assert.assertFalse(logInPage.customerMenuMyFavorites.getText().contains("Control Panel"));
        Assert.assertFalse(logInPage.customerMenuMyTourRequest.getText().contains("Control Panel"));




    }
}
