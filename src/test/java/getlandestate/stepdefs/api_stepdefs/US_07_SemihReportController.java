package getlandestate.stepdefs.api_stepdefs;

import getlandestate.base_url.BaseUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class US_07_SemihReportController extends BaseUrl {

    Response response;

    @Given("Report Controller GET icin URL duzenlenir")
    public void reportControllerGetIcınUrlDuzenlenır(){
        //specden otomatik geliyor
    }

    @When("Report Controller icin GET request gonderilir ve response alinir")
    public void reportControllerIcinGetRequestGonderilirVeResponseAlinir(){
        response = given().spec(spec).when().get("/report");
        response.prettyPrint();
    }

    @Then("Dogrulama kodu 200 dogrulamasi")
    public void dogrulamaKodu200Dogrulamasi(){
        Assert.assertEquals(200,response.getStatusCode());
    }

}
