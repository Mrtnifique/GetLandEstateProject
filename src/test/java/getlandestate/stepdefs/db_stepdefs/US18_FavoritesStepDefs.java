package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US18_FavoritesStepDefs {
    List<Object> actualColumnData;

    private List<String> toStringList(List<Object> row) {
        return row.stream()
                .map(o -> o == null ? "null" : o.toString())
                .toList();
    }

    @Given("Kullanıcı {string} sekmesinden {string} id'den bilgileri çeker")
    public void kullanıcıSekmesindenIdDenBilgileriÇeker(String sekme, String id) {
        actualColumnData = DBUtils.getRowList("SELECT * FROM " + sekme + " WHERE id = " + id);
        System.out.println("Veritabanından gelen bilgiler: " + actualColumnData);

    }

    @Then("Kullanıcı gelen bilgileri doğrular")
    public void kullanicigelenbilgileridogrular(DataTable expectedTable) {
        List<String> expectedColumnData = expectedTable.row(1);
        List<String> actualAsString = toStringList(actualColumnData);

        System.out.println("Beklenen datalar: " + expectedColumnData);
        System.out.println("Gelen datalar: " + actualAsString);
        Assert.assertEquals(expectedColumnData, actualAsString);
    }


}
