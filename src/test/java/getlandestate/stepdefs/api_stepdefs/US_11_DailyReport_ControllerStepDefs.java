package getlandestate.stepdefs.api_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_11_DailyReport_ControllerStepDefs {
    Response response;
    @Given("DailyReport Controller Get icin URL düzenlenir")
    public void dailyreportControllerGetIcinURLDüzenlenir() {
        spec.pathParam("first","daily-report");
    }

    @When("DailyReport Get Request gönderilir ve Respond alınır")
    public void dailyreportGetRequestGönderilirVeRespondAlınır() {
        response = given(spec).when().get("{first}");
        response.prettyPrint();
    }

    @Then("Dogrulama kodun 200 olduğu doğrulanır")
    public void statusCodeInOlduğuDoğrulanır() {
        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + response.getBody().asString());
        assertEquals(200, statusCode);
    }
}
