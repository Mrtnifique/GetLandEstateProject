package getlandestate.stepdefs.api_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pojos.US_04_MuratAdvertTypePost;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US_04_MuratAdvertTypeControllerStepDefs {
    US_04_MuratAdvertTypePost payload;
    String randomName = new Faker().funnyName().name();
    String sanitizedTitle = randomName.replaceAll("[^a-zA-Z\\- ]", "");
    Response response;

    @Given("URL ayarlanır: first {string}")
    public void URLAyarlanırFirstSecond(String first) {
        spec.pathParams("first", first);
    }

    @Given("URL ayarlanır: first {string} second {string}")
    public void URLAyarlanırFirstSecond(String first, String second) {
        spec.pathParams("first", first, "second", second);
    }

    @Given("URL ayarlanır: first {string} second {string} third {string}")
    public void urlAyarlanırFirstSecondThird(String first, String second, String third) {
        spec.pathParams("first", first, "second", second, "third", third);
    }

    @When("Get Request gönderilir ve Respond alınır | Tek URL")
    public void GetRequestGönderilirVeRespondAlınırTek() {
        response = given(spec).when().get("{first}");
        response.prettyPrint();
    }

    @When("Get Request gönderilir ve Respond alınır | İki URL")
    public void GetRequestGönderilirVeRespondAlınırİki() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @When("Get Request gönderilir ve Respond alınır | Üç URL")
    public void getRequestGönderilirVeRespondAlınırÜç() {
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("Status Code'ın {int} olduğu doğrulanır")
    public void statusCodeInOlduğuDoğrulanır(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("Advert Type için payload ayarlanır")
    public void advertTypeIçinPayloadAyarlanır() {
        payload = new US_04_MuratAdvertTypePost(sanitizedTitle);
    }


    @When("Post Request gönderilir ve Respond alınır | Tek URL")
    public void PostRequestGönderilirVeRespondAlınırTek() {
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }

    @When("Post Request gönderilir ve Respond alınır | İki URL")
    public void PostRequestGönderilirVeRespondAlınırİki() {
        response = given(spec).body(payload).when().post("{first}/{second}");
        response.prettyPrint();
    }

    @When("Post Request gönderilir ve Respond alınır | Üç URL")
    public void PostRequestGönderilirVeRespondAlınırÜç() {
        response = given(spec).body(payload).when().post("{first}/{second}/{third}");
        response.prettyPrint();
    }


    @When("Put Request gönderilir ve Respond alınır | Tek URL")
    public void putRequestGönderilirVeRespondAlınırTek() {
        response = given(spec).body(payload).when().put("{first}");
        response.prettyPrint();
    }

    @When("Put Request gönderilir ve Respond alınır | İki URL")
    public void putRequestGönderilirVeRespondAlınırİki() {
        response = given(spec).body(payload).when().put("{first}/{second}");
        response.prettyPrint();
    }

    @When("Put Request gönderilir ve Respond alınır | Üç URL")
    public void putRequestGönderilirVeRespondAlınırÜç() {
        response = given(spec).body(payload).when().put("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @When("Delete Request gönderilir ve Respond alınır | Tek URL")
    public void deleteRequestGönderilirVeRespondAlınırTek() {
        response = given(spec).when().delete("{first}");
        response.prettyPrint();
    }

    @When("Delete Request gönderilir ve Respond alınır | İki URL")
    public void deleteRequestGönderilirVeRespondAlınırİki() {
        response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
    }

    @When("Delete Request gönderilir ve Respond alınır | Üç URL")
    public void deleteRequestGönderilirVeRespondAlınırÜç() {
        response = given(spec).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
    }

}
