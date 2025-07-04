package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class US02_CategoriesCheckStedDefs {

    private List<String> actualColumnNames;
    private Map<String, String> actualRowData;

    @Given("Kullanici veri_tabanina baglanir")
    public void kullanici_veri_tabanina_baglanir() {
        DBUtils.createConnection();
        System.out.println("✅ Veritabanına başarıyla bağlanıldı.");
    }

    @When("Kullanıcı categories tablosundan sütun isimlerini çeker")
    public void kullanıcı_categories_tablosundan_sutun_isimlerini_ceker() throws SQLException {
        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM categories LIMIT 1");
        System.out.println("📋 Çekilen sütun isimleri: " + actualColumnNames);
    }

    @Then("Kullanıcı gelen isimlerin tamamini dogrular")
    public void kullanıcı_gelen_isimlerin_tamamini_dogrular(DataTable dataTable) {
        List<String> expectedColumnNames = dataTable.asList();
        System.out.println("✅ Beklenen sütun isimleri: " + expectedColumnNames);
        Assert.assertEquals("Sütun isimleri eşleşmiyor!", expectedColumnNames, actualColumnNames);
    }

    @Given("Kullanıcı {string} tablosundan {string} nolu id'den bilgileri çeker")
    public void kullanıcı_tablosundan_id_den_bilgileri_ceker(String tableName, String id) throws SQLException {
        actualRowData = new HashMap<>();

        String query = "SELECT * FROM " + tableName + " WHERE id = " + id;
        ResultSet resultSet = DBUtils.createStatement().executeQuery(query);

        if (resultSet.next()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                String columnValue = resultSet.getString(i);
                actualRowData.put(columnName, columnValue);
            }
        } else {
            Assert.fail("Belirtilen ID'ye sahip veri bulunamadı!");
        }

        System.out.println("📋 Çekilen satır bilgileri: " + actualRowData);
    }

    @Then("Kullanıcı categories tablosundan gelen bilgiler doğrulanır")
    public void kullanıcı_categories_tablosundan_gelen_bilgiler_dogrulanir(DataTable dataTable) {
        List<Map<String, String>> expectedList = dataTable.asMaps(String.class, String.class);
        Map<String, String> expectedRowData = expectedList.get(0);

        System.out.println("✅ Beklenen satır bilgileri: " + expectedRowData);

        for (String key : expectedRowData.keySet()) {
            String expected = expectedRowData.get(key);
            String actual = actualRowData.get(key);

            // Null kontrolü için
            if (expected == null) expected = "";
            if (actual == null) actual = "";

            Assert.assertEquals("Alan uyuşmuyor: " + key, expected.trim(), actual.trim());
        }
    }


}
