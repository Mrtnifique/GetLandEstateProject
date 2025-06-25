package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;

public class US14_TourRequestsStepDefs {

    private Connection connection = DBUtils.connection; // bağlantı DBUtils'tan alınır
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private PreparedStatement preparedStatement;

    @And("tour_requests tablosuna erişim sağlanır")
    public void tour_requests_tablosuna_erisim_saglanir() {
        executeQuery("SELECT * FROM tour_requests LIMIT 1");
        System.out.println("tour_requests tablosuna erişim sağlandı");
    }

    @When("{int} numaralı satır sorgulanır")
    public void numarali_satir_sorgulanir(int id) {
        try {
            String query = "SELECT * FROM tour_requests WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                Assert.fail(id + " numaralı satır bulunamadı");
            }
            System.out.println(id + " numaralı satır sorgulandı");
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Satır sorgulama başarısız: " + e.getMessage());
        }
    }

    @Then("advert_id değeri {int} olmalıdır")
    public void advert_id_degeri_olmalidir(int expected) {
        assertIntColumnValue("advert_id", expected);
    }

    @And("guest_user_id değeri {int} olmalıdır")
    public void guest_user_id_degeri_olmalidir(int expected) {
        assertIntColumnValue("guest_user_id", expected);
    }

    @And("owner_user_id değeri {int} olmalıdır")
    public void owner_user_id_degeri_olmalidir(int expected) {
        assertIntColumnValue("owner_user_id", expected);
    }

    @When("tablo yapısı kontrol edilir")
    public void tablo_yapisi_kontrol_edilir() {
        executeQuery("SELECT * FROM tour_requests LIMIT 1");
        try {
            metaData = resultSet.getMetaData();
            System.out.println("Tablo yapısı kontrol edildi");
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Meta veri alınamadı: " + e.getMessage());
        }
    }

    @Then("{word} sütunu mevcut olmalıdır")
    public void sutun_mevcut_olmalidir(String columnName) {
        try {
            boolean exists = false;
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                if (columnName.equals(metaData.getColumnName(i))) {
                    exists = true;
                    break;
                }
            }

            Assert.assertTrue(columnName + " sütunu mevcut değil", exists);
            System.out.println(columnName + " sütunu doğrulandı");
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Sütun kontrolü başarısız: " + e.getMessage());
        }
    }

    // Ortak SQL sorgulama fonksiyonu
    private void executeQuery(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Sorgu başarısız: " + e.getMessage());
        }
    }

    // Ortak integer karşılaştırma fonksiyonu
    private void assertIntColumnValue(String columnName, int expected) {
        try {
            int actual = resultSet.getInt(columnName);
            Assert.assertEquals(columnName + " değeri beklenen ile uyuşmuyor", expected, actual);
            System.out.println(columnName + " doğrulandı: " + actual);
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail(columnName + " değeri alınamadı: " + e.getMessage());
        }
    }

    // Temizlik metodu
    public void cleanup() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
