package getlandestate.stepdefs.api_stepdefs;

import getlandestate.base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_07_ReportControllerStedDefs extends BaseUrl {

    private Response response;

    @Given("Report-Controller Get icin URL düzenlenir")
    public void reportControllerGetIcinURLDuzenlenir() {
        // spec base_url'dan otomatik gelir, path eklemeye gerek yok çünkü direkt /report çağrılacak
    }

    @When("Report-Controller Get Request gönderilir ve Response alınır")
    public void reportControllerGetRequestGonderilirVeResponseAlinir() {
        response = given()
                .spec(spec)
                .when()
                .get("/report");
        response.prettyPrint();
    }

    @Then("Dogrulama kodun 200 dogrulamasi yapilir")
    public void dogrulamaKodun200DogrulamasiYapilir() {
        assertEquals(200, response.getStatusCode());
    }
}