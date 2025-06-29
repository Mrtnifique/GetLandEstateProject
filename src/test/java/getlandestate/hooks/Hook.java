package getlandestate.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import getlandestate.utilities.Driver;

import static getlandestate.base_url.BaseUrl.settingup;

public class Hook {

    @Before
    public void setUp() throws Exception {
        //Hooks classtaki @Before methodu herbir scenariodan once calistirilir
    }

    @Before("x")
    public void setUp2() throws Exception {
        //Sadece x tagina sahip olan scenariolardan ONCE calistirilir
    }

    @Before("@ApiAdmin")
    public void apiAdmin() {
    settingup("b307admin@gmail.com", "B307admin@");

    }

    @Before("@ApiCustomer")
    public void apiCustomer() {
        settingup("canan1@gmail.com", "12345678.Canan");
    }


    @After("y")
    public void tearDown2() throws Exception {
        //Sadece y tagina sahip olan scenariolardan SONRA calistirilir

    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {//eğer scenario fail olursa calisacak
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", "scenario_" + scenario.getName());
            Driver.closeDriver();
        }
    }


}






