package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.experimental.categories.Categories;

import java.util.List;

public class US02_CategoriesStepDefs {

    private List<String> actualTableNames;
    Categories categories;

    @Given("İstifadəçi database-ə qoşulur")
    public void istifadeciDatabaseQosulur() {
        DBUtils.createConnection();
        System.out.println("✅ Istifadeci database qosuldu.");
    }

    @When("İstifadəçi Categories cədvəlindən məlumatları çəkir")
    public void istifadeciCategoriesSutunAdalariniVeMelumatlariniÇekir() {
        try {
            actualTableNames = DBUtils.getColumnNames("Categories");
            DBUtils.executeQuery("select * from Categories");
            System.out.println("✅ Istifadeci Categories sutun adalarini ve melumatlarini cekdi.");
        } catch (Exception e) {
            System.err.println("❌ Istifadeci Categories sutun adalarini ve melumatlarini cekmek olmadi: " + e.getMessage());
            Assert.fail("Istifadeci Categories sutun adalarini ve melumatlarini cekmek olmadi: " + e.getMessage());
        }


    }

    @Then("İstifadəçi sütun adlarını və məlumatların düzgünlüyünü təsdiqləyir")
    public void istifadeciCategoriesSutunAdalariniVeMelumatlariniTestiqleyir() {

        List<String> expectedColumnNames = List.of("CategoryID", "CategoryName", "Description");
        Assert.assertEquals(" Sütun adları uyğunsuzdur!",expectedColumnNames, actualTableNames);

        List<List<Object>> allData = DBUtils.getQueryResultList("select * from Categories");
        for (List<Object> row : allData) {
            Assert.assertEquals(" Sütun adları uyğunsuzdur!",expectedColumnNames.size(), row.size());
        }
        Assert.assertEquals(" Sütun adları uyğunsuzdur!",expectedColumnNames.size(), allData.size());
        System.out.println("✅ Istifadeci Categories sutun adalarini ve melumatlarini test etdi.");

        DBUtils.closeConnection();
        System.out.println("Database bagladiqdan sonra sonlandirildi.");
    }
}
