package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

public class US17_UsersColumnVerifyStepDef {

    private List<String> actualUsersColumns;
    @Given("Kullanıcı {string} tablosuna bağlanır")
    public void kullanıcıTablosunaBağlanır(String arg0) {


        DBUtils.createConnection();

    }

    @When("Kullanıcı {string} tablosunun sütun isimlerini çeker")
    public void kullanıcıTablosununSütunIsimleriniÇeker() {

        actualUsersColumns =DBUtils.getColumnNames(" Users");

         try {
            // Tüm Users column isimlerini  al


            System.out.println("📋 Veritabanından çekilen Users column sayısı: " + actualUsersColumns.size());
            System.out.println("📋 Cekilen users column isimleri:+");

            for (int i = 0; i < actualUsersColumns.size(); i++) {
                System.out.println((i + 1) + ". " + actualUsersColumns.get(i));
            }

            // Null ve boş liste kontrolü
            Assert.assertNotNull("UsersColumns null olamaz", actualUsersColumns);
             boolean b = !isEmpty();
             Assert.assertFalse("Users columns listesi boş olamaz", isEmpty());

        } catch (Exception e) {
            System.err.println("❌ Users column alınırken hata oluştu: " + e.getMessage());
            Assert.fail("Users column alınamadı: " + e.getMessage());
        }
    }

    @Then("Kullanıcı aşağıdaki sütunları görmelidir")
    public void kullanıcıAşağıdakiSütunlarıGörmelidir() {

        List<String> expectedColumns = List.of(
                "id",
                "first_name",
                "last_name",
                "email",
                "created_at",
                "updated_at"
        );
        Assert.assertTrue(actualUsersColumns.contains(expectedColumns));
    }




        List<Map<String, Object>> querySonucu;

        @When("{string} sorgusu çalıştırılır")
        public void sorguCalistirilir(String sql) {
            querySonucu = DBUtils.getQueryResultMap(sql);
            System.out.println("🟢 Sorgu çalıştırıldı: " + sql);
            System.out.println("🔎 Sonuç: " + querySonucu);
        }

        @Then("Sonuç boş olmalıdır")
        public void sonucBosOlmalidir() {
            Assert.assertTrue("❗️ Beklenmeyen veri geldi: " + querySonucu, querySonucu.isEmpty());
            System.out.println("✅ Sorgu sonucu boş, test geçti.");
        }



    }

