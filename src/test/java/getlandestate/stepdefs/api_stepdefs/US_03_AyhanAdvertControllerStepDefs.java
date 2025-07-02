package getlandestate.stepdefs.api_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pojos.US_03_AyhanAdvertPost;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US_03_AyhanAdvertControllerStepDefs {
    US_03_AyhanAdvertPost payload;
    Faker faker = new Faker();
    Response response;



}
