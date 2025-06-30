package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static getlandestate.utilities.DBUtils.getQueryResultList;
import static getlandestate.utilities.DBUtils.getRowData;

public class US02_CategoriesStepsDef {

    private List<String> actualColumnNames;
    private List<Object> actualrows;
    List<String> row = new ArrayList<>();
    ResultSet resultSet;

    @Given("Kullanıcı database-e baglanır")
    public void kullanıcıDatabaseEBaglanır() {
        DBUtils.connectToDatabase();
        System.out.println("✅ Veritabanına bağlanıldı.");
    }

    @When("Kullanıcı {string} sutun isimlerini ceker")
    public void kullanıcıSutunIsimleriniCeker(String categories) {
        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM " + categories + " LIMIT 1");
        System.out.println("Veritabanından gelen sutunlar: " + actualColumnNames);

    }

    @When("Kullanıcı {string} sekmesindeki {string} id'li bilgileri ceker")
    public void kullanıcıSekmesindekiIdliBilgileriCeker(String categories, String id) {
        actualrows = DBUtils.getRowList("SELECT * FROM " +categories + " WHERE id = " + id);
        System.out.println("Veritabanından gelen bilgiler: " + actualrows);

    }

    @Then("Kullanıcı sutun isimlerini ve bilgilerini dogrular")
    public void kullanıcıSutunIsimleriniVeBilgileriniDogrular(DataTable expectedTable) {
        List<String> expectedrows = Arrays.asList("id", "created_at", "updated_at", "is_active", "built_in", "icon", "seq", "slug", "title");
        System.out.println("Beklenen sutunlar: " + expectedTable);
        System.out.println("Gelen sutunlar: " + actualColumnNames);

        Assert.assertEquals("Sutun isimleri eşlesmiyor!", expectedrows, actualColumnNames);
        System.out.println(" ✅ Sutun isimleri ve bilgileri dogru.");
    }

}