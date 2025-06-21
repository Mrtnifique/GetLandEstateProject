package getlandestate.stepdefs.e2e_stepdefs;

import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import io.cucumber.java.en.When;

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






}
