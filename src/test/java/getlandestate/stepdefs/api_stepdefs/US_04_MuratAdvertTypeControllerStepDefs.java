package getlandestate.stepdefs.api_stepdefs;

import getlandestate.pojos.US_04_MuratAdvertTypePost;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US_04_MuratAdvertTypeControllerStepDefs {
    US_04_MuratAdvertTypePost payload;

    @Given("Advert Type için URL ayarlanır")
    public void advertTypeIçinURLAyarlanır() {
        spec.pathParams("first", "advert-types");
    }

    @And("Advert Type için payload ayarlanır")
    public void advertTypeIçinPayloadAyarlanır() {
        payload = new US_04_MuratAdvertTypePost("hakhukukadalethakhukukadalet");
    }

    @When("Advert Type için get Request gönderilir ve Respond alınır")
    public void advertTypeIçinGetRequestGönderilirVeRespondAlınır() {
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }

    @Then("Status Code'ın {int} olduğu doğrulanır")
    public void statusCodeInOlduğuDoğrulanır(int arg0) {
    }
}
