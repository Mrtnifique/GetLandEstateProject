package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class US12_ImagesStepDefs {

    private Connection connection;
   private ResultSet rs;


    @When("Images tablosundan {string} adlı kayıt sorgulanır")
    public void imagesTablosundaKayıtSorgulanır(String Name) throws SQLException {
        connection = DBUtils.connectToDatabase();
        String query = "SELECT * FROM images WHERE name = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, Name);
        rs = pstmt.executeQuery();
    }

    @Then("Kayıt bulunmalıdır")
    public void kayitBulunmalidir() throws SQLException {
        assertTrue("Kayıt bulunamadı!", rs.next());
    }



}
