package getlandestate.stepdefs.api_stepdefs;

import getlandestate.base_url.BaseUrl;
import getlandestate.pojos.US_01_PinarTourRequestPayload;
import getlandestate.pojos.US_01_PinarTourRequestResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_01_PinarTourRequestControllerStepDefs extends BaseUrl {
    US_01_PinarTourRequestPayload payload;

    Response response;

    @Given("customer aşağıdaki verilerle {string} adresine POST isteği gönderir")
    public void customerAsagidakiVerilerleAdresinePOSTIstegiGonderir(String endpoint, String requestBody) {
        spec.pathParams("first", endpoint);

        response = given(spec)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("{first}");

        response.prettyPrint();
    }

    @Then("durum kodu {int} olmalıdır")
    public void durumKoduOlmalıdır(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }



    @Then("tur isteği başarılı şekilde oluşturulmalı ve bilgiler doğru dönmeli")
    public void turIstegiBasariliSekildeOlusturulmaliVeBilgilerDogruDonmeli() {
        US_01_PinarTourRequestResponse tourRequestResponsePojo = response.as(US_01_PinarTourRequestResponse.class);

        // Örnek doğrulamalar (response içeriğine göre güncelle)
        assertTrue(tourRequestResponsePojo.getId() > 0);
        assertEquals("2025-07-30", tourRequestResponsePojo.getTourDate());
        assertEquals("15:30:00", tourRequestResponsePojo.getTourTime());
        assertEquals("PENDING", tourRequestResponsePojo.getStatus());

        System.out.println(tourRequestResponsePojo);
    }

    @Given("customer {string} adresine GET isteği gönderir")
    public void customerAdresineGETIsteğiGönderir(String endpoint) {
        // Base URL setup (BaseUrl sınıfından alınmış olmalı)

        BaseUrl.settingup("canan1@gmail.com", "12345678.Canan");
        spec.pathParams(
                "first", "tour-requests",
                "second", "page",
                "third", "71"
        ).queryParams(
                "page", 0,
                "size", 10,
                "sort", "tourDate",
                "type", "DESC"
        );

        response = given()
                .spec(spec)
                .when()
                .get("/{first}/{second}/{third}");

        response.prettyPrint();
    }


    @And("yanıt gövdesi {string} içermelidir")
    public void yanıtGövdesiIçermelidir(String responseBody) {
        String actualResponseBody = response.getBody().asString();
        assertTrue(actualResponseBody.contains(responseBody));
    }


    @Given("müşteri {string} id'li tour request için {string} adresine PUT isteği gönderir")
    public void müşteriIdLiTourRequestIçinAdresinePUTIsteğiGönderir(String id, String endpoint, String requestBody) {
        spec.pathParams("first", "tour-requests", "second", "1093");

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("{first}/{second}");
    }



    @Then("status code {int} olmalı")
    public void statusCodeOlmalı(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());

    }
}
