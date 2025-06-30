package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US15_Advert_typesStepDef {

    private List<String> actualRows;
    private List<String> actualColumnNames;
    
    @Given("Kullanıcın database-e bağlanır")
    public void kullanıcınDatabaseEBağlanır() {
        DBUtils.createConnection();
        System.out.println("✅ Veritabanına bağlanıldı.");
    }

    @When("Kullanicin {string} sekmesinden bilgilerini ceker")
    public void kullanicinSekmesindenBilgileriniCeker(String sekmeAdi, io.cucumber.datatable.DataTable table) {
    }

    @When("Kullanicin {string} sekmesinden {string} id'den bilgilerini ceker")
    public void kullanicinSekmesindenSutunIdDenBilgileriniCeker(String advert_types, String id) {
        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM " + advert_types + " ColumnsName" + actualColumnNames);
        System.out.println("Veritabanından gelen sutunlar: " + actualColumnNames);

        actualRows = DBUtils.getColumnNames("SELECT * FROM " + advert_types + " WHERE id = " + id);
        System.out.println("Veritabanından gelen bilgiler: " + actualRows);
    }


    @Then("Kullanicin gelen bilgileri dogrular")
    public void kullanicinGelenBilgileriDogrular(DataTable expectedTable) {
        List<String> expectedrows = actualRows;
        System.out.println("Beklenen idler: " + expectedrows);
        System.out.println("Gelen idler  : " + actualRows);
        Assert.assertEquals(actualColumnNames, expectedrows);
    }
}
