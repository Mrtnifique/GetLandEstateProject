package getlandestate.stepdefs.db_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.sql.*;
import java.util.*;
import static org.junit.Assert.*;

public class US11_LogsStepDefs {

    private List<String> actualColumns;

    @Given("Kullanıcı {string} sekmesinden sutun isimlerini ceker")
    public void kullanici_sekmesinden_sutun_isimlerini_ceker(String tableName) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://64.227.123.49:5432/prettierhomes", "techprotester", "myPassword");

        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, tableName);

        ResultSet rs = ps.executeQuery();
        actualColumns = new ArrayList<>();
        while (rs.next()) {
            actualColumns.add(rs.getString("COLUMN_NAME"));
        }

        conn.close();
    }

    @Then("Kullanıcı gelen isimleri dogrular")
    public void kullanici_gelen_isimleri_dogrular(DataTable dataTable) {
        List<String> expectedColumns = dataTable.asList();

        for (String expected : expectedColumns) {
            assertTrue("Sütun bulunamadı: " + expected, actualColumns.contains(expected));
        }
    }
}