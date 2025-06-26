package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_CategoryPropertyValuesStepDefs {

    List<String> actualColumnNames;

    @When("{string} tablosundan sütun bilgileri alınır")
    public void tablosundanSütunBilgileriAlınır(String tableName) {
        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM " + tableName + " LIMIT 1");
        System.out.println("Veritabanından gelen sütunlar: " + actualColumnNames);
    }

    @Then("Aşağıdaki sütunların mevcut olduğu doğrulanır")
    public void aşağıdakiSütunlarınMevcutOlduğuDoğrulanır(DataTable expectedTable) {
        List<String> expectedColumnNames = expectedTable.asList();
        System.out.println("Beklenen sütunlar: " + expectedColumnNames);
        System.out.println("Gelen sütunlar: " + actualColumnNames);
        Assert.assertEquals("Sütun isimleri eşleşmiyor!", expectedColumnNames, actualColumnNames);
    }
}
