package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.DashBoardPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class DashBoardPageStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    Faker faker = new Faker();
    Random random = new Random();
    Actions actions = new Actions( Driver.getDriver() );


    @When("Search butonuna tıklanır")
    public void searchButonunaTiklanir() {
        dashBoardPage.searchBox.click();
    }


    @And("Filtreleme yapılarak arama yapılır")
    public void filtrelemeYapılarakAramaYapılır() {
        dashBoardPage.categoryFilter.click();
        Select selectCategory = new Select(dashBoardPage.categoryFilter);
        selectCategory.selectByVisibleText("House");

        dashBoardPage.countryFilter.click();
        Select selectCountry = new Select(dashBoardPage.countryFilter);
        selectCountry.selectByVisibleText("Türkiye");

        dashBoardPage.cityFilter.click();
        Select selectCity = new Select(dashBoardPage.cityFilter);
        selectCity.selectByVisibleText("Ankara");

        dashBoardPage.districtFilter.click();
        Select selectDistrict = new Select(dashBoardPage.districtFilter);
        selectDistrict.selectByVisibleText("Çankaya");

        dashBoardPage.filterSearchButton.click();


    }

    @Then("Aranan ilanın listelenmesi test edilir")
    public void arananIlanınListelenmesiTestEdilir() {
        assertTrue(dashBoardPage.houseDisplayed.isDisplayed());
    }

    @Then("İletisim bilgilerine tıklayarak uyarı mesajı alınır")
    public void iletisimBilgilerineTıklayarakUyarıMesajıAlınır() {
        dashBoardPage.houseClick.click();
        dashBoardPage.contactNumberEyesButton.click();
        dashBoardPage.contactAlert.isDisplayed();
        dashBoardPage.contactAlertCloseButton.click();


    }

    @And("Tarih ve saat girilerek randevu olusturulur")
    public void tarihVeSaatGirilerekRandevuOlusturulur() {
        // Rastgele tarih

        Date futureDate = faker.date().future(10, TimeUnit.DAYS); // Bugünden 10 gün sonrasına kadar rastgele bir tarih
        LocalDate localDate = futureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String dateStr = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        WebElement dateInput = dashBoardPage.tourDate;
        dateInput.sendKeys(dateStr);

        // Rastgele saat

        Select timeSelect = new Select(dashBoardPage.tourTime);
        int index = random.nextInt(timeSelect.getOptions().size());
        timeSelect.selectByIndex(index);

        //Submit Tour Request butonuna tıklanır
        actions.moveToElement(dashBoardPage.submitTourRequestButton).click().perform();
    }

    @Then("Randevu icin uyarı mesajı görünürlüğü test edilir")
    public void randevuIcinUyarıMesajıGörünürlüğüTestEdilir() {
      Assert.assertTrue(dashBoardPage.contactAlert2.isDisplayed());
    }


    @And("Create one now butonuna tıklanır")
    public void createOneNowButonunaTıklanır() {
        dashBoardPage.createOneNowButton.click();
    }

    @Then("Register sayfasına gidildiği test edilir")
    public void registerSayfasınaGidildiğiTestEdilir() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://64.227.123.49/register";
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
