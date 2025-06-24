package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_CustomerRegisterationStepDefs {

    private List<String> actualTableNames;

    @Given("Kullanıcı veritabanına bağlanır")
    public void kullanici_veritabanina_baglanir() {
        // Veritabanına bağlan
        DBUtils.createConnection();
        System.out.println("✅ Veritabanına başarıyla bağlanıldı.");
    }

    @When("Kullanıcı tüm tablo isimlerini çeker")
    public void kullanici_tum_tablo_isimlerini_ceker() {
        try {
            // Tüm tablo isimlerini al
            actualTableNames = DBUtils.getTableNames();

            System.out.println("📋 Veritabanından çekilen tablo sayısı: " + actualTableNames.size());
            System.out.println("📋 Çekilen tablo isimleri:");

            for (int i = 0; i < actualTableNames.size(); i++) {
                System.out.println((i + 1) + ". " + actualTableNames.get(i));
            }

            // Null ve boş liste kontrolü
            Assert.assertNotNull("Tablo isimleri null olamaz", actualTableNames);
            Assert.assertFalse("Tablo isimleri listesi boş olamaz", actualTableNames.isEmpty());

        } catch (Exception e) {
            System.err.println("❌ Tablo isimleri alınırken hata oluştu: " + e.getMessage());
            Assert.fail("Tablo isimleri alınamadı: " + e.getMessage());
        }
    }

    @Then("Kullanıcı tablo isimlerinin doğru sırada olduğunu doğrular")
    public void kullanici_tablo_isimlerinin_dogru_sirada_oldugunu_dogrular(DataTable expectedTablesTable) {
        // DataTable'dan beklenen tablo isimlerini al
        List<String> expectedTableNames = expectedTablesTable.asList();

        System.out.println("\n🔍 TABLO İSİMLERİ KARŞILAŞTIRMASI:");
        System.out.println("Beklenen tablo sayısı: " + expectedTableNames.size());
        System.out.println("Gerçek tablo sayısı: " + actualTableNames.size());

        // Tablo sayısı kontrolü
        Assert.assertEquals(
                "Beklenen tablo sayısı ile gerçek tablo sayısı eşleşmiyor!",
                expectedTableNames.size(),
                actualTableNames.size()
        );

        System.out.println("\n📊 SIRALAMALı KARŞILAŞTIRMA:");

        // Her bir tablonun sırasını kontrol et
        for (int i = 0; i < expectedTableNames.size(); i++) {
            String expectedTable = expectedTableNames.get(i);
            String actualTable = actualTableNames.get(i);

            System.out.println((i + 1) + ". Beklenen: '" + expectedTable + "' | Gerçek: '" + actualTable + "'");

            Assert.assertEquals(
                    "Sıra " + (i + 1) + "'de beklenen tablo '" + expectedTable +
                    "' ama gerçek tablo '" + actualTable + "' bulundu!",
                    expectedTable,
                    actualTable
            );
        }

        System.out.println("\n✅ TÜM TABLO İSİMLERİ DOĞRU SIRADA!");

        // Ek kontrol: Tüm tabloların varlığını kontrol et
        System.out.println("\n🔍 TABLO VARLIK KONTROLÜ:");
        for (String expectedTable : expectedTableNames) {
            boolean tableExists = actualTableNames.contains(expectedTable);
            Assert.assertTrue(
                    "'" + expectedTable + "' tablosu veritabanında bulunamadı!",
                    tableExists
            );
            System.out.println("✅ " + expectedTable + " tablosu mevcut");
        }

        System.out.println("\n🎉 BAŞARILI! Tüm tablolar doğru sırada ve mevcut.");

        // Bağlantıyı kapat
        DBUtils.closeConnection();
        System.out.println("🔒 Veritabanı bağlantısı kapatıldı.");
    }
}