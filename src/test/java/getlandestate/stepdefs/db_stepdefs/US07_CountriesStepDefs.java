package getlandestate.stepdefs.db_stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class US07_CountriesStepDefs {

    Response response;
    List<Map<String, Object>> countryList;

    @Given("API isteği gönderilir")
    public void api_isteği_gönderilir() {
        response = given()
                .when()
                .get("http://64.227.123.49:8092/countries/all");
        response.then().statusCode(200);

        // Burada atama yapıldı, artık countryList null olmayacak
        countryList = response.jsonPath().getList("");
    }

    @Then("Dönüşte her ülke için şu alanlar bulunmalı:")
    public void donusteHerUlkeIcinAlanlarOlmali(DataTable dataTable) {
        List<String> expectedKeys = dataTable.asList();
        System.out.println("Kontrol edilen alanlar: " + expectedKeys);

        for (Map<String, Object> country : countryList) {
            for (String key : expectedKeys) {
                Assert.assertTrue("Eksik alan: " + key, country.containsKey(key));
            }
        }

        System.out.println("Tüm ülkelerde gerekli alanlar mevcut.");
    }

    @Then("En az 1 ülke {string} alanı boş olmamalı")
    public void enAzBirUlkeAlaniBosOlmamali(String field) {
        boolean valid = countryList.stream()
                .anyMatch(c -> c.get(field) != null && !c.get(field).toString().trim().isEmpty());

        Assert.assertTrue("En az bir ülkenin " + field + " alanı dolu olmalı!", valid);
        System.out.println("En az bir ülkenin " + field + " alanı dolu.");
    }

    @Then("{string} isminde bir ülke bulunmalı")
    public void ulkeIsmiKontrol(String expectedName) {
        boolean exists = countryList.stream()
                .anyMatch(c -> expectedName.equals(c.get("name")));

        Assert.assertTrue(expectedName + " bulunamadı!", exists);
        System.out.println(expectedName + " bulundu.");
    }

    @Then("Dönüşte her ülke için id, name ve location alanları boş olmamalı ve terminalde yazdırılmalı")
    public void tumUlkeBilgileriYazdirilirVeKontrolEdilir() {
        System.out.println("Ülke Bilgileri:");

        int index = 1;
        for (Map<String, Object> country : countryList) {
            Object id = country.get("id");
            Object name = country.get("name");
            Object location = country.get("location");

            System.out.println(index + ". Ülke");
            System.out.println("   ID      : " + id);
            System.out.println("   Name    : " + name);
            System.out.println("   Location: " + location);
            System.out.println("-----------------------------");

            Assert.assertNotNull("id null!", id);
            Assert.assertNotNull("name null!", name);
            Assert.assertNotNull("location null!", location);

            Assert.assertFalse("name boş!", name.toString().trim().isEmpty());
            Assert.assertFalse("location boş!", location.toString().trim().isEmpty());

            index++;
        }

        System.out.println("Tüm ülkelerin id, name ve location alanları dolu.");
    }
}
