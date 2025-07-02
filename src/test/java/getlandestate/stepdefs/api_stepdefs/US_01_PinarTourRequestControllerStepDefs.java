package getlandestate.stepdefs.api_stepdefs;


import getlandestate.pojos.US_01_PinarTourRequestPost;
import getlandestate.pojos.US_01_PinarTourRequestPut;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
public class US_01_PinarTourRequestControllerStepDefs {


    US_01_PinarTourRequestPost payload;
    US_01_PinarTourRequestPut put;

    Response response;


    //Post Test-----------------------------------
    @Given("Tur isteği oluşturmak için URL düzenlenir")
    public void turIsteğiOluşturmakIçinURLDüzenlenir() {

        spec.pathParams("first", "tour-requests");
    }

    @And("Tur isteği için payload verisi hazırlanır")
    public void turIsteğiIçinPayloadVerisiHazırlanır() {
        payload = new US_01_PinarTourRequestPost();
        payload.setAdvertId(71);
        payload.setTourDate("2027-09-15");
        payload.setTourTime("20:30");
        payload.setMessage("Tur hakkında bilgi almak istiyorum");

    }

    @When("Tur isteği için POST request gönderilir ve response alınır")
    public void turIsteğiIçinPOSTRequestGönderilirVeResponseAlınır() {
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();
    }


    @Then("Tur isteği için durum kodunun {int} olduğu doğrulanır")
    public void durumKoduOlmalıdır(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }





    //Put Test-----------------------------------

    @Given("Customer url düzenler")
    public void customerUrlDüzenler() {
        spec.pathParams("first", "tour-requests", "second", "1110", "third", "auth");
    }


    @And("customer payload düzenler")
    public void customerPayloadDüzenler() {

        put = new US_01_PinarTourRequestPut();
        put.setTourDate("2028-09-15");
        put.setTourTime("19:30");
        put.setMessage("Tur hakkında bilgi almak isterim.");
        put.setAdvertId(71);

    }


    @When("Customer Put request gönderir ve response alınır")
    public void customerPutRequestGönderirVeResponseAlınır() {
        response = given(spec).body(put).when().put("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("status code {int} olmalı")
    public void statusCodeOlmalı(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }



}
