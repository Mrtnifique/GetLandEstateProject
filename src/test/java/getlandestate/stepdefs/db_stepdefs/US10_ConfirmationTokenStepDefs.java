package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US10_ConfirmationTokenStepDefs {
    List<String> actualColumnNames;

    @Then("Kullanıcı gelen isimleri doğrular")
    public void kullanicigelenisimleridogrular(DataTable expectedTable) {
        List<String> expectedColumnNames = expectedTable.asList();

        System.out.println("Beklenen kolonlar: " + expectedColumnNames);
        System.out.println("Gerçek kolonlar  : " + actualColumnNames);
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
    }


    @Given("Kullanıcı {string} sekmesinden sütun isimlerini çeker")
    public void kullanıcıSekmesindenSütunIsimleriniÇeker(String arg0) {
        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM confirmation_token");
        System.out.println("Veritabanından gelen kolonlar: " + actualColumnNames);
    }
}

