package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US10_ConfirmationTokenStepDefs {
    List<String> actualColumnNames;

    @Given("Kullanıcı {string} sekmesinden sütun isimlerini çeker")
    public void kullanıcıSekmesindenSütunIsimleriniÇeker(String tableName) {

        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM " + tableName + " LIMIT 1");
        System.out.println("Veritabanından gelen isimler: " + actualColumnNames);
    }

    @Then("Kullanıcı gelen isimleri doğrular")
    public void kullanicigelenisimleridogrular(DataTable expectedTable) {
        List<String> expectedColumnNames = expectedTable.asList();

        System.out.println("Beklenen isimler: " + expectedColumnNames);
        System.out.println("Gelen isimler  : " + actualColumnNames);
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
    }



}

