package getlandestate.stepdefs.api_stepdefs;

import getlandestate.pojos.US_06_ContactControllerPost;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_06_Tugberk_ContactControllerStepDefs {
    Response response;
    US_06_ContactControllerPost payload;

    @Given("Contact Controller icin URL düzenlenir")
    public void ContactControllericinURLdüzenlenir() {
        spec.pathParams("first","contact-messages");
    }

    @And("Contact Controller icin payload olusturulur")
    public void contactControllerIcinPayloadOlusturulur() {
        payload = new US_06_ContactControllerPost("camoluk", "otomotiv", "Rent a Car", "camoluk@gmail.com", true);
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }

    @Then("Status Code 200 olduğu doğrulanır")
    public void statusCodeOlduğuDoğrulanır() {
        assertEquals(200, response.getStatusCode());
    }

    @Then("Contact message saved successfully görünürlüğü doğrulanir")
    public void contactMessageSavedSuccessfullyGörünürlüğüDoğrulanir() {
        String expectedMessage = "Contact message saved successfully.";
        String actualMessage = response.asString();
        assertEquals(expectedMessage, actualMessage);
        System.out.println("Success Message :" + actualMessage);
    }


    @Given("Contact Controller Get icin URL düzenlenir")
    public void contactControllerGetIcinURLDüzenlenir() {
        spec.pathParams("first","contact-messages", "second", "2890");

    }

    @When("Get Request gönderilir ve Respond alınır")
    public void getRequestGönderilirVeRespondAlınır() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @Given("Contact Controller Delete icin URL düzenlenir")
    public void contactControllerDeleteIcinURLDüzenlenir() {
        spec.pathParams("first","contact-messages", "second", "2898");
    }

    @When("Delete Request gönderilir ve Respond alınır")
    public void deleteRequestGönderilirVeRespondAlınır() {
        response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
    }

    @Given("Contact Controller Patch icin URL düzenlenir")
    public void contactControllerPatchIcinURLDüzenlenir() {
        spec.pathParams("first","contact-messages", "second", "2895");
    }

    @When("Patch Request gönderilir ve Respond alınır")
    public void patchRequestGönderilirVeRespondAlınır() {
        response = given(spec).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();
    }

    @And("Contact Controller Patch icin payload olusturulur")
    public void contactControllerPatchIcinPayloadOlusturulur() {
        payload = new US_06_ContactControllerPost("camoluk", "motosiklet", "Rent a Car", "camoluk@gmail.com", true);
    }

    @Then("Response body deki lastName degeri kontrol edilmelidir")
    public void responseBodyDekiLastNameDegeriKontrolEdilmelidir() {
        String expectedLastName = "motorsiklet";
        String actualLastName = response.jsonPath().getString("lastName");
        assertEquals(expectedLastName, actualLastName);

    }
}



