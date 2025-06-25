package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class US09_CategoryPropertyKeysStepDefs {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private List<String> actualColumns;




    @Given("Database bağlantısı kurulur")
    public void database_baglantisi_kurulur() {
        connection = DBUtils.connectToDatabase();
        try {
            // PostgreSQL JDBC sürücüsünü yükle
            Class.forName("org.postgresql.Driver");

            // Veritabanı bağlantısını oluştur

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException e) {
            fail("PostgreSQL JDBC sürücüsü bulunamadı: " + e.getMessage());
        } catch (SQLException e) {
            fail("Veritabanı bağlantısı kurulamadı: " + e.getMessage());
        }
    }

    @When("{string} tablosundan sütun bilgileri çekilir")
    public void tablosundanSütunBilgileriÇekilir(String arg0) {
        try {
            resultSet = statement.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = '" + arg0 + "'");
            actualColumns = new ArrayList<>();
            while (resultSet.next()) {
                actualColumns.add(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            fail("Veritabanından sütun bilgileri çekilemedi: " + e.getMessage());
        }



    }


    @Then("Aşağıdaki sütunların mevcut olduğu doğrulanır:")
    public void asagidaki_sutunlarin_mevcut_oldugu_dogrulanir(DataTable dataTable) {
        // DataTable'dan beklenen sütun isimlerini al
        List<String> expectedColumns = dataTable.asList(String.class);

        try {
            // Eksik sütunları kontrol et
            List<String> missingColumns = new ArrayList<>();
            for (String expected : expectedColumns) {
                if (!actualColumns.contains(expected.toLowerCase())) {
                    missingColumns.add(expected);
                }
            }

            // Eksik sütun varsa hata fırlat
            if (!missingColumns.isEmpty()) {
                fail("Aşağıdaki sütunlar tabloda bulunamadı: " + String.join(", ", missingColumns));
            }

            // Fazladan sütun olup olmadığını kontrol et (opsiyonel)
            List<String> extraColumns = new ArrayList<>();
            for (String actual : actualColumns) {
                if (!expectedColumns.contains(actual)) {
                    extraColumns.add(actual);
                }
            }

            if (!extraColumns.isEmpty()) {
                System.out.println("UYARI: Tabloda beklenmeyen sütunlar var: " + String.join(", ", extraColumns));
            }

        } finally {
            // Kaynakları temizle
            try {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Kaynaklar kapatılırken hata oluştu: " + e.getMessage());
            }
        }
    }


}