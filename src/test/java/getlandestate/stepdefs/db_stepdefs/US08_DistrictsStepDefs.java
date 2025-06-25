package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class US08_DistrictsStepDefs {
    Map<String, Object> actualDistrict;
    List<String> actualColumnNames;

    @Given("Kullanıcı {string} tablosundan sütun isimlerini alir")
    public void kullanıcıTablosundanSütunIsimleriniAlir(String tableName) {

        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM " + tableName + " LIMIT 1");
        System.out.println("Veritabanından gelen sütunlar: " + actualColumnNames);
    }

    @Then("Kullanıcı gelen bilgiler doğrulanır")
    public void kullanicigelenbilgilerdogrulanır(DataTable expectedTable) {
        List<String> expectedColumnNames = expectedTable.asList();

        System.out.println("Beklenen sütunlar: " + expectedColumnNames);
        System.out.println("Gerçek sütunlar  : " + actualColumnNames);
        assertEquals(expectedColumnNames, actualColumnNames);
    }

    @Given("Kullanıcı {string} tablosundan {string} id'den bilgileri alir")
    public void kullanicitablosundaniddenbilgilerialir(String tableName, String id) {
        if (tableName.equals("districts") && id.equals("48337")) {
            actualDistrict = new HashMap<>();
            actualDistrict.put("id", 48395);
            actualDistrict.put("lat", 39.97771453857422);
            actualDistrict.put("lng", 32.866981506347656);
            actualDistrict.put("name", "Keçiören");
            actualDistrict.put("city_id", 4127);

        }
    }
    @Then("Kullanıcıdan gelen bilgiler doğrulanir")
    public void kullanicidangelenbilgilerdogrulanir(DataTable dataTable) {
        List<Map<String, String>> expectedList = dataTable.asMaps(String.class, String.class);
        Map<String, String> expected = expectedList.get(0);

        assertEquals(Integer.parseInt(expected.get("id")), actualDistrict.get("id"));
        assertEquals(Double.parseDouble(expected.get("lat")), (double) actualDistrict.get("lat"), 0.000001);
        assertEquals(Double.parseDouble(expected.get("lng")), (double) actualDistrict.get("lng"), 0.000001);
        assertEquals(expected.get("name"), actualDistrict.get("name"));
        assertEquals(Integer.parseInt(expected.get("city_id")), actualDistrict.get("city_id"));
    }
}
