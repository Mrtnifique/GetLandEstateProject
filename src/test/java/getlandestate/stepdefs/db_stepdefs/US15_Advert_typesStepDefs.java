package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.junit.Assert;

import java.util.List;

public class US15_Advert_typesStepDefs {
    private List<String> actualColumnNames;
    public List<Object> actualData;

    @Given("Istifadechi Database-ə qosulur")
    public void istifadechiDatabaseƏQosulur() {
        DBUtils.createConnection();
        System.out.println("✅ Istifadeci database qosuldu.");
    }

    @When("Istifadechi Advert_types cedvelinden melumatlari cekir")
    public void istifadechiAdvert_typesCedvelindenMelumatlariCekir() {
        try {
            DBUtils.getColumnNames("Advert_types");
            //actualData = DBUtils.getQueryResultAsListOfLists("Selecet * from Advert_types");
            System.out.println("✅ Istifadeci Advert_types sutun adalarini ve melumatlarini cekdi.");
        }
        catch (Exception e) {
            System.err.println("❌ Istifadeci Advert_types sutun adalarini ve melumatlarini cekmek olmadi: " + e.getMessage());
            Assert.fail("Istifadeci Advert_types sutun adalarini ve melumatlarini cekmek olmadi: " + e.getMessage());
        }
    }

    @Then("Istifadechi sutun adlarini ve melumatlari dogrula")
    public void istifadechiSutunAdlariniVeMelumatlariDogrula() {
        List<String> expectedColumnNames = List.of("Advert_type_id", "Advert_type_name", "Description");
        Assert.assertEquals("❌ Sütun adları uyğunsuzdur!",expectedColumnNames, actualColumnNames);

        Assert.assertFalse("❌ Cedvelde hec bir melumat yoxdur!", actualData.isEmpty());

        System.out.println("✅ Sütun adları və cədvəl məlumatları uğurla təsdiqləndi.");
    }
}
