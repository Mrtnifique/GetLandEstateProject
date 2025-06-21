package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class AdminMesajlariStepDefinion {
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
    @When("tüm seçenekleri al")
    public void tüm_seçenekleri_al() {
        Select select = new Select(logInPage.dropdownElementi);
        List<WebElement> customerMenuList = select.getOptions();
        for (int i=0 ;i<customerMenuList.size();i++ ){
            Assert.assertFalse("Control Panel".equalsIgnoreCase(customerMenuList.get(i).getText()));
        }
    }
    @Then("Control panel seçeneğinin olmadığını doğrula")
    public void control_panel_seçeneğinin_olmadığını_doğrula() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





}
