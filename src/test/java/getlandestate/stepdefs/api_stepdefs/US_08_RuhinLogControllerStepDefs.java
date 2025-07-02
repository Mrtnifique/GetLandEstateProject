package getlandestate.stepdefs.api_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_08_RuhinLogControllerStepDefs {
    
    Response response;
    @Given("Adim GET icin URL alir")
    public void adimIcinURLAlir() {
        spec.pathParams("first", "logs", "second", "1761");
    }

    @When("Send Request ve get Response alinir")
    public void sendRequestVeGetResponseAlinir() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("Status Code {int} oldugunu dogrular")
    public void statusCodeOldugunuDogrular(int nummber) {
        int statusCode = response.getStatusCode();
        assertEquals(nummber, statusCode);
    }
}

