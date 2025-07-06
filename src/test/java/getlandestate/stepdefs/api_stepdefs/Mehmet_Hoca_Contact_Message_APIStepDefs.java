import getlandestate.pojos.Mehmet_Hocanin_POJOsu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static getlandestate.base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class Mehmet_Hoca_Contact_Message_APIStepDefs {
    Response response;
    static Mehmet_Hocanin_POJOsu payload;
    static Mehmet_Hocanin_POJOsu actualData;
    static int sonOlusturulanMesajIdsi;

    @Given("Yeni bir mesaj olarak {string} gönderilir")
    public void yeniBirMesajOlarakGönderilir(String message) {
        //set the url
        spec.pathParam("first", "contact-messages");

        //set the payload / expected data
        /*
        {
  "firstName": "ali",
  "lastName": "can",
  "email": "ali@can.com",
  "message": "bu bir test mesajidir",
  "status": true
}
         */
        payload = new Mehmet_Hocanin_POJOsu("ali", "can", "ali@can.com", "bu bir test mesajidir", true);

        //send request get response
        response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

    }

    @Then("status code {int} oldugu dogrulanir")
    public void statusCodeOlduguDogrulanir(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @And("contact message basarili bir sekilde olusturuldugu test edilir")
    public void contactMessageBasariliBirSekildeOlusturulduguTestEdilir() {
        String expectedMessage = "Contact message saved successfully.";
        String actualMessage = response.asString();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("Son olusturulan mesaji alabilmek icin request yapilir")
    public void sonOlusturulanMesajiAlabilmekIcinRequestYapilir() {
        //http://64.227.123.49:8092/contact-messages
        spec.pathParam("first", "contact-messages");
        response = given(spec).when().get("{first}");
        response.prettyPrint();

        List<Mehmet_Hocanin_POJOsu> actualDataList = response.jsonPath().getList("content", Mehmet_Hocanin_POJOsu.class);

        actualData = actualDataList.get(0);

        sonOlusturulanMesajIdsi = response.jsonPath().getInt("content[0].id");
    }

    @And("son olusturulan mesaj test edilir")
    public void sonOlusturulanMesajTestEdilir() {
        Assert.assertEquals(payload.getEmail(), actualData.getEmail());
        Assert.assertEquals(payload.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(payload.getLastName(), actualData.getLastName());
        Assert.assertEquals(payload.getMessage(), actualData.getMessage());
        Assert.assertEquals(payload.isStatus(), actualData.isStatus());
    }


    @Given("Son olusturulan mesaji guncellemek icin request yapilir")
    public void sonOlusturulanMesajiGuncellemekIcinRequestYapilir() {
        spec.pathParams("first", "contact-messages", "second", sonOlusturulanMesajIdsi);
        payload = new Mehmet_Hocanin_POJOsu("veli", "han", "veli@han.com", "bu bir test mesajidir", true);
        response = given(spec).body(payload).when().patch("{first}/{second}");
    }

    @And("son olusturulan mesajin güncellenebildigi test edilir")
    public void sonOlusturulanMesajinGüncellenebildigiTestEdilir() {
        actualData = response.as(Mehmet_Hocanin_POJOsu.class);
        Assert.assertEquals(payload.getEmail(), actualData.getEmail());
        Assert.assertEquals(payload.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(payload.getLastName(), actualData.getLastName());
        Assert.assertEquals(payload.getMessage(), actualData.getMessage());
        Assert.assertEquals(payload.isStatus(), actualData.isStatus());
    }

    @Given("Son olusturulan mesaji silmek icin request yapilir")
    public void sonOlusturulanMesajiSilmekIcinRequestYapilir() {
        spec.pathParams("first", "contact-messages", "second", sonOlusturulanMesajIdsi);
        response = given(spec).when().delete("{first}/{second}");
    }

    @And("son olusturulan mesajin silinebildigi test edilir")
    public void sonOlusturulanMesajinSilinebildigiTestEdilir() {
        String expectedMessage = "Contact message deleted successfully.";
        String actualMessage = response.asString();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}