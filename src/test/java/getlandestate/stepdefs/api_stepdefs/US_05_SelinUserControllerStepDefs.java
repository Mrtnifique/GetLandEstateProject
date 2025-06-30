package getlandestate.stepdefs.api_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pojos.US_05_SelinUserController;
import getlandestate.pojos.US_05_SelinUserLogin;
import getlandestate.pojos.US_05_SelinUserPatch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class US_05_SelinUserControllerStepDefs {

    US_05_SelinUserPatch patch;
    US_05_SelinUserLogin login;
    US_05_SelinUserController payload;
    Response response;
    String token;
    Integer userId;


    // --------------Register--------------------

    @Given("User Register için URL düzenlenir")
    public void userRegisterIçinURLDüzenlenir() {
        spec.pathParams("first", "users", "second", "register");

    }

    @And("User Register için payload düzenlenir")
    public void userRegisterIcinPayloadDuzenlenir() {

          payload = new US_05_SelinUserController();
            payload.setFirstName("Senem");
            payload.setLastName("Yılmaz");
            payload.setPhone("(124) 976-4400");
            payload.setEmail("abcdd@test.com");
            payload.setPassword("12345BBbb.");
            payload.setPasswordAgain("12345BBbb.");

            // Müşteri rolü
            payload.setTitle("Customer");

    }
        @When("User Register için POST request gönderilir ve response alınır")
    public void userRegisterIcinPOSTRequestGonderilir() {
            response = given(spec).body(payload).when().post("{first}/{second}");
            response.prettyPrint();


        }

    @Then("User Register için Status kodunun {int} olduğu doğrulanır")
    public void userRegisterStatusKodDogrulanir(int statusCode) {
        assertEquals(200, response.getStatusCode());
    }


    // -------------Login--------------

    @Given("User Login için URL düzenlenir")
    public void userLoginIçinURLDüzenlenir() {
        spec.pathParams("first","users", "second", "login");
    }


    @And("User Login için payload düzenlenir")
    public void userLoginIcinPayloadDuzenlenir() {
        login = new US_05_SelinUserLogin("12345BBbb.","abcdd@test.com");

    }

    @When("User Login için POST request gönderilir ve response alınır")
    public void userLoginIcinPOSTRequestGonderilir() {
        response = given(spec).body(login).when().post("{first}/{second}");
        response.prettyPrint();

        // Login başarılıysa token'ı güncelle
        if (response.statusCode() == 200) {
            token = response.jsonPath().getString("token");
        }
    }

    @Then("User Login için Status kodunun {int} olduğu doğrulanır")
    public void userLoginStatusKoduDogrulanir(int statusCode) {
        assertEquals(200, response.getStatusCode());
    }


    //--------------- GET Auth User ----------------

    @When("Auth User için GET request gönderilir ve response alınır")
    public void authUserIcinGETRequestGonderilir() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("Auth User için Status kodunun {int} olduğu doğrulanır")
    public void authUserStatusKodDogrulanir(int statusCode) {
        assertEquals(200, response.getStatusCode());
    }


    // --------------PATCH Auth User ----------------

    @Given("Auth User için URL düzenlenir")
    public void authUserIçinURLDüzenlenir() {
        spec.pathParams("first", "users", "second", "605", "third", "admin");
    }

    @And("Auth User için güncelleme payload düzenlenir")
    public void authUserIcinGuncellemePayloadDuzenlenir() {
        patch = new US_05_SelinUserPatch();

    }

    @When("Auth User için PATCH request gönderilir ve response alınır")
    public void authUserIcinPATCHRequestGonderilir() {
        response = given(spec).body(payload).when().patch("{first}/{second}/{third}");
        response.prettyPrint();
    }


    // ------------- DELETE Auth User ----------------

    @When("Auth User için DELETE request gönderilir ve response alınır")
    public void authUserIcinDELETERequestGonderilir() {
        response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();
    }



}
