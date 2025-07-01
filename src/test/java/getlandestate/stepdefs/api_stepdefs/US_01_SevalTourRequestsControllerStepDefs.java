package getlandestate.stepdefs.api_stepdefs;

import getlandestate.base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_01_SevalTourRequestsControllerStepDefs extends BaseUrl {

    private Response response;

    @Given("Tour-Request_Controller Get icin URL düzenlenir")
    public void tourRequest_ControllerGetIcinURLDüzenlenir() {
        // URL hazırlığı gerekiyorsa burada yapılır, şu an boş bırakabilirsin.
    }

    @When("GET request gönderilir ve response alınır")
    public void getRequestGonderilirVeResponseAlinir() {
        response = given()
                .spec(spec)
                .when()
                .get("/tour-requests/admin/count");
        response.prettyPrint();
    }

    @Then("status code {int} olmali")
    public void statusCodeOlmali(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}