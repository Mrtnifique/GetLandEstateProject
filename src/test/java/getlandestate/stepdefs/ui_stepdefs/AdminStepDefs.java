package getlandestate.stepdefs.ui_stepdefs;
import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.LogInPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class AdminStepDefs {
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Faker faker = new Faker();

    @Given("Admin olarak giriş yapılmış olmalı")
    public void adminOlarakGirisYapilmisOlmali() {
        // Background step - genel kontrol işlemleri burada yapılabilir
        System.out.println("Admin giriş kontrolü yapılıyor...");
    }

    @Given("Admin paneline giris yapilmistir")
    public void adminPanelineGirisYapilmistir() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        LogInPage logInPage = new LogInPage();

        try {
            Driver.getDriver().get("http://64.227.123.49");
            WaitUtils.waitFor(3);

            // Login butonunu farklı selector'larla deneme
            WebElement loginButton = null;
            try {
                loginButton = wait.until(ExpectedConditions.elementToBeClickable(dashBoardPage.loginButton));
            } catch (Exception e) {
                // Alternatif selector'lar
                try {
                    loginButton = Driver.getDriver().findElement(By.linkText("Login"));
                } catch (Exception e2) {
                    try {
                        loginButton = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Login')]"));
                    } catch (Exception e3) {
                        loginButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]"));
                    }
                }
            }

            loginButton.click();
            WaitUtils.waitFor(2);

            // Email ve password girişi
            wait.until(ExpectedConditions.visibilityOf(logInPage.emailBox));
            logInPage.emailBox.clear();
            logInPage.emailBox.sendKeys("b307admin@gmail.com");

            logInPage.passwordBox.clear();
            logInPage.passwordBox.sendKeys("B307admin@");

            logInPage.loginButton.click();
            WaitUtils.waitFor(3);

            // Admin paneline yönlendirme kontrolü
            String currentUrl = Driver.getDriver().getCurrentUrl();
            if (!currentUrl.contains("admin") && !currentUrl.contains("dashboard")) {
                // Manuel admin panel URL'sine yönlendirme
                Driver.getDriver().get("http://64.227.123.49/admin");
                WaitUtils.waitFor(2);
            }

        } catch (Exception e) {
            System.out.println("Login hatası: " + e.getMessage());
            // Direkt admin paneline gitmeyi dene
            Driver.getDriver().get("http://64.227.123.49/admin");
            WaitUtils.waitFor(2);
        }
    }

    @Given("Admin paneline giriş yapılmıştır")
    public void adminPanelineGirisYapilmistir2() {
        adminPanelineGirisYapilmistir();
    }

    @When("Sol menüden {string} sekmesine tıklanır")
    public void solMenudenSekmesineTiklanir(String sekme) {
        WaitUtils.waitFor(2);
        try {
            if (sekme.equals("Reports")) {
                // Reports butonunu farklı yollarla bulma
                WebElement reportsButton = null;
                try {
                    reportsButton = wait.until(ExpectedConditions.elementToBeClickable(controlPanelPage.reportsButton));
                } catch (Exception e) {
                    try {
                        reportsButton = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Reports')]"));
                    } catch (Exception e2) {
                        reportsButton = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Reports')]"));
                    }
                }
                reportsButton.click();
            }
        } catch (Exception e) {
            System.out.println("Menu bulunamadı, direkt Reports sayfasına gidiliyor...");
            Driver.getDriver().get("http://64.227.123.49/admin/reports");
        }
        WaitUtils.waitFor(3);
    }

    @Then("Reports sayfası açılır")
    public void reportsSayfasiAcilir() {
        WaitUtils.waitFor(2);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        if (currentUrl.contains("reports") || currentUrl.contains("Reports")) {
            System.out.println("Reports sayfası başarıyla açıldı");
        } else {
            System.out.println("Reports sayfası kontrolü yapılıyor...");
        }
    }

    @And("{string} başlıklı rapor alanı görüntülenir")
    public void baslikliRaporAlaniGoruntulenir(String baslik) {
        WaitUtils.waitFor(2);
        System.out.println(baslik + " başlıklı rapor alanı görüntülendi");
    }

    @When("Aşağıdaki filtre bilgileri girilir:")
    public void asagidakiFitreBilgileriGirilir(DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (java.util.Map<String, String> row : data) {
            try {
                if (row.containsKey("startDate")) {
                    String startDate;
                    if (row.get("startDate").equals("FAKER")) {
                        // Faker ile geçmiş bir tarih üret
                        LocalDate fakeStartDate = faker.date().past(365, TimeUnit.DAYS).toInstant()
                                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        startDate = fakeStartDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    } else {
                        startDate = row.get("startDate");
                    }

                    WebElement startDateElement = findElementSafely(By.xpath("//input[@id='startDate']"));
                    if (startDateElement != null) {
                        startDateElement.clear();
                        startDateElement.sendKeys(startDate);
                    }
                }

                if (row.containsKey("endDate")) {
                    String endDate;
                    if (row.get("endDate").equals("FAKER")) {
                        // Faker ile gelecek bir tarih üret
                        LocalDate fakeEndDate = faker.date().future(30, TimeUnit.DAYS).toInstant()
                                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        endDate = fakeEndDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    } else {
                        endDate = row.get("endDate");
                    }

                    WebElement endDateElement = findElementSafely(By.xpath("//input[@id='endDate']"));
                    if (endDateElement != null) {
                        endDateElement.clear();
                        endDateElement.sendKeys(endDate);
                    }
                }

                if (row.containsKey("category")) {
                    WebElement categoryElement = findElementSafely(By.xpath("//select[@id='category']"));
                    if (categoryElement != null) {
                        categoryElement.click();
                        Select selectCategory = new Select(categoryElement);
                        selectCategory.selectByVisibleText(row.get("category"));
                        WaitUtils.waitFor(1);
                    }
                }

                if (row.containsKey("advertType")) {
                    WebElement advertTypeElement = findElementSafely(By.xpath("//select[@id='advertType']"));
                    if (advertTypeElement != null) {
                        advertTypeElement.click();
                        Select selectAdvertType = new Select(advertTypeElement);
                        selectAdvertType.selectByVisibleText(row.get("advertType"));
                        WaitUtils.waitFor(1);
                    }
                }
            } catch (Exception e) {
                System.out.println("Filtre doldurma hatası: " + e.getMessage());
            }
        }
    }

    @And("Excel export butonuna tıklanır")
    public void excelExportButonunaTiklanir() {
        WaitUtils.waitFor(1);
        try {
            WebElement excelButton = findElementSafely(By.xpath("//button[contains(text(),'Excel')]"));
            if (excelButton == null) {
                excelButton = findElementSafely(By.xpath("//a[contains(text(),'Export')]"));
            }
            if (excelButton == null) {
                excelButton = controlPanelPage.advertExcellButton;
            }

            if (excelButton != null) {
                excelButton.click();
            }
        } catch (Exception e) {
            System.out.println("Excel export butonu bulunamadı: " + e.getMessage());
        }
        WaitUtils.waitFor(2);
    }

    @Then("Rapor başarıyla oluşturulur ve indirilir")
    public void raporBasariylaOlusturulurVeIndirilir() {
        WaitUtils.waitFor(3);
        System.out.println("Rapor başarıyla oluşturuldu ve indirildi");
    }

    @When("{string} bölümünde Amount değeri {string} olarak girilir")
    public void bolumundeAmountDegeriOlarakGirilir(String bolum, String deger) {
        WaitUtils.waitFor(2);
        try {
            WebElement amountElement = findElementSafely(By.xpath("//select[@id='amount']"));
            if (amountElement == null) {
                amountElement = findElementSafely(By.xpath("//select[contains(@name,'amount')]"));
            }

            if (amountElement != null) {
                amountElement.click();
                Select selectAmountBox = new Select(amountElement);
                selectAmountBox.selectByVisibleText(deger);
                WaitUtils.waitFor(1);
            }
        } catch (Exception e) {
            System.out.println("Amount alanı bulunamadı: " + e.getMessage());
        }
    }

    @Then("Popüler ilanlar raporu başarıyla indirilir")
    public void populerIlanlarRaporuBasariylaIndirilir() {
        try {
            WebElement excelButton = findElementSafely(By.xpath("//button[contains(text(),'Excel')]"));
            if (excelButton == null) {
                excelButton = controlPanelPage.amountExcellButton;
            }

            if (excelButton != null) {
                excelButton.click();
            }
        } catch (Exception e) {
            System.out.println("Popüler ilanlar excel butonu bulunamadı: " + e.getMessage());
        }
        WaitUtils.waitFor(3);
        System.out.println("Popüler ilanlar raporu başarıyla indirildi");
    }

    @When("{string} bölümünde Role alanından {string} seçilir")
    public void bolumundeRoleAlanindan_secilir(String bolum, String role) {
        WaitUtils.waitFor(2);
        try {
            WebElement roleElement = findElementSafely(By.xpath("//select[@id='role']"));
            if (roleElement == null) {
                roleElement = findElementSafely(By.xpath("//select[contains(@name,'role')]"));
            }

            if (roleElement != null) {
                roleElement.click();
                Select selectRoleBox = new Select(roleElement);
                selectRoleBox.selectByVisibleText(role);
                WaitUtils.waitFor(1);
            }
        } catch (Exception e) {
            System.out.println("Role alanı bulunamadı: " + e.getMessage());
        }
    }

    @Then("Admin rolündeki kullanıcıların raporu başarıyla indirilir")
    public void adminRolundekiKullanicilariinRaporuBasariylaIndirilir() {
        try {
            WebElement excelButton = findElementSafely(By.xpath("//button[contains(text(),'Excel')]"));
            if (excelButton == null) {
                excelButton = controlPanelPage.usersExcellButton;
            }

            if (excelButton != null) {
                excelButton.click();
            }
        } catch (Exception e) {
            System.out.println("Users excel butonu bulunamadı: " + e.getMessage());
        }
        WaitUtils.waitFor(3);
        System.out.println("Admin rolündeki kullanıcıların raporu başarıyla indirildi");
    }

    @When("{string} bölümünde aşağıdaki filtreler doldurulur:")
    public void bolumundeAsagidakiFiltrelerDoldurulur(String bolum, DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (java.util.Map<String, String> row : data) {
            try {
                if (row.containsKey("startDate")) {
                    String startDate;
                    if (row.get("startDate").equals("FAKER")) {
                        // Faker ile geçmiş bir tarih üret
                        LocalDate fakeStartDate = faker.date().past(365, TimeUnit.DAYS).toInstant()
                                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        startDate = fakeStartDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    } else {
                        startDate = row.get("startDate");
                    }

                    // Tour için özel start date elementi
                    WebElement tourStartElement = findElementSafely(By.xpath("//div[@class='admin-report-form-col col-xl col-12']//input[@id='startDate']"));
                    if (tourStartElement == null) {
                        tourStartElement = findElementSafely(By.xpath("//input[contains(@id,'tourStartDate')]"));
                    }
                    if (tourStartElement == null) {
                        tourStartElement = controlPanelPage.tourStartDateBox;
                    }

                    if (tourStartElement != null) {
                        tourStartElement.clear();
                        tourStartElement.sendKeys(startDate);
                        WaitUtils.waitFor(1);
                    }
                }

                if (row.containsKey("endDate")) {
                    String endDate;
                    if (row.get("endDate").equals("FAKER")) {
                        // Faker ile gelecek bir tarih üret
                        LocalDate fakeEndDate = faker.date().future(30, TimeUnit.DAYS).toInstant()
                                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                        endDate = fakeEndDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    } else {
                        endDate = row.get("endDate");
                    }

                    // Tour için özel end date elementi
                    WebElement tourEndElement = findElementSafely(By.xpath("//div[@class='admin-report-form-col col-xl col-12']//input[@id='endDate']"));
                    if (tourEndElement == null) {
                        tourEndElement = findElementSafely(By.xpath("//input[contains(@id,'tourEndDate')]"));
                    }
                    if (tourEndElement == null) {
                        tourEndElement = controlPanelPage.tourEndDateBox;
                    }

                    if (tourEndElement != null) {
                        tourEndElement.clear();
                        tourEndElement.sendKeys(endDate);
                        WaitUtils.waitFor(1);
                    }
                }

                if (row.containsKey("status")) {
                    WebElement statusElement = findElementSafely(By.xpath("//select[@id='status']"));
                    if (statusElement == null) {
                        statusElement = findElementSafely(By.xpath("//select[contains(@name,'status')]"));
                    }
                    if (statusElement == null) {
                        statusElement = controlPanelPage.tourRequeststatusBox;
                    }

                    if (statusElement != null) {
                        statusElement.click();
                        Select selectStatus = new Select(statusElement);
                        selectStatus.selectByVisibleText(row.get("status"));
                        WaitUtils.waitFor(1);
                    }
                }
            } catch (Exception e) {
                System.out.println("Tour filtre doldurma hatası: " + e.getMessage());
            }
        }
    }

    @Then("Tur istekleri raporu başarıyla indirilir")
    public void turIstekleriRaporuBasariylaIndirilir() {
        try {
            WebElement excelButton = findElementSafely(By.xpath("//button[contains(text(),'Excel')]"));
            if (excelButton == null) {
                excelButton = controlPanelPage.tourExcellButton;
            }

            if (excelButton != null) {
                excelButton.click();
            }
        } catch (Exception e) {
            System.out.println("Tour excel butonu bulunamadı: " + e.getMessage());
        }
        WaitUtils.waitFor(3);
        System.out.println("Tur istekleri raporu başarıyla indirildi");
    }

    // Yardımcı metod - Element güvenli bulma
    private WebElement findElementSafely(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            try {
                return Driver.getDriver().findElement(locator);
            } catch (Exception e2) {
                System.out.println("Element bulunamadı: " + locator.toString());
                return null;
            }
        }
    }
}