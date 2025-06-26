package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class US05_DailyReportsStepDefs {

    private Connection connection;
    private ResultSet rs;


    @When("Dailyreports tablosundan adlı kayıt sorgulanır")
    public void dailyReportsTablosundaKayıtSorgulanır() throws SQLException {
        connection = DBUtils.connectToDatabase();
        String query = "SELECT * FROM daily_reports WHERE number_of_rent_adverts = 30";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, 30);
        rs = pstmt.executeQuery();
    }

    @Given("Daily Reports tablosundan number_of_rent_adverts adlı kayıt bilgilerini çeker")
    public void dailyReportsVerisiCekilir() throws SQLException {
        connection = DBUtils.connectToDatabase();
        String query = "SELECT * FROM daily_reports WHERE number_of_rent_adverts = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, 30); // 30 sayısı sabit olarak kontrol ediliyor
        rs = pstmt.executeQuery();
    }


}

