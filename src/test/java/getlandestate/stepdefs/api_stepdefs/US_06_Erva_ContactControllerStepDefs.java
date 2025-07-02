package getlandestate.stepdefs.api_stepdefs;

import getlandestate.pojos.US06ErvaContactControllerPost;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_06_Erva_ContactControllerStepDefs {

    Response response;
    US06ErvaContactControllerPost payload;

    @Given("Contact controller icin URL olusturulur")
    public void contactControllerIcinURLOlusturulur() {
            spec.pathParams("first","contact-messages");
    }

    @And("Contact controller icin payload olusturulur")
    public void contactControllerIcinPayloadOlusturulur() {
        payload = new US06ErvaContactControllerPost("thebirthof", "venus", "thebirthofvenus", "thebirthofvenus", true);
    }

    @When("Contact controller icin POST request gonderilir ve response alinir")
    public void contactControllerIcinPOSTRequestGonderilirVeResponseAlinir() {
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }

    @Then("Contact controller icin status kodun {int} oldugu dogrulanir")
    public void contactControllerIcinStatusKodunOlduguDogrulanir(int statusCode) {
            assertEquals(statusCode, response.getStatusCode());
    }

    @Then("Contact message saved successfully gorunurlugu dogrulanir")
    public void contactMessageSavedSuccessfullyGorunurluguDogrulanir() {
        String expectedMessage = "Contact message saved successfully.";
        String actualMessage = response.asString();
        assertEquals(expectedMessage, actualMessage);
    }

}
