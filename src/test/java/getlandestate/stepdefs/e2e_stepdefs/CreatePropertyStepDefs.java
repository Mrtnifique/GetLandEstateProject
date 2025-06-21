package getlandestate.stepdefs.e2e_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.DashBoardPage;
import getlandestate.pages.CreatePropertyPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import getlandestate.utilities.ActionsUtils;
import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class CreatePropertyStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    CreatePropertyPage createPropertyPage = new CreatePropertyPage();
    Faker faker = new Faker();
    Random random = new Random();
    Actions actions = new Actions( Driver.getDriver() );


    @Given("Ana sayfaya geri gidilir")
    public void anaSayfayaGeriGidilir() {
        createPropertyPage.BackToHomePage.click();

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://64.227.123.49/";
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @Given("Create Property Sayfasına Gidilir")
    public void CreatePropertySayfasinaGidilir() {
        createPropertyPage.CreatePropertyButton.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://64.227.123.49/ad";
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @Given("Common Information, Address Information, Properties elementleri görülür")
    public void zorunluElementlerGorulur() {
        assertTrue(createPropertyPage.addressInfo.isDisplayed());
        ActionsUtils.scrollDown();
        assertTrue(createPropertyPage.commonInfo.isDisplayed());
        ActionsUtils.scrollDown();
        assertTrue(createPropertyPage.propertiesSection.isDisplayed());
        WaitUtils.waitFor(3);

    }

    @Given("Description ve address bos birakildiginda uyari mesaji görülür")
    public void titleUyariMesajiGorur() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", createPropertyPage.titleInput);
        ActionsUtils.scrollUp();
        js.executeScript("arguments[0].click();", createPropertyPage.descriptionInput);
        ActionsUtils.pressTab();
        assertTrue(createPropertyPage.descriptionWarning.isDisplayed());

        js.executeScript("arguments[0].scrollIntoView(true);", createPropertyPage.addressInput);
        ActionsUtils.scrollUp();
        js.executeScript("arguments[0].click();", createPropertyPage.addressInput);
        ActionsUtils.pressTab();
        assertTrue(createPropertyPage.addressWarning.isDisplayed());

    }

    @Given("Advert Type butonunda Rent seçilir")
    public void advertTypeSecilir() {

        createPropertyPage.advertTypeDropwDown.click();
        Select advertType = new Select(createPropertyPage.advertTypeDropwDown);
        advertType.selectByVisibleText("Rent");
        ActionsUtils.pressTab();
        WaitUtils.waitFor(1);
    }

    @Given("Advert Type butonunda Sale seçilir")
    public void advertTypeSaleSecilir() {

        createPropertyPage.advertTypeDropwDown.click();
        Select advertType = new Select(createPropertyPage.advertTypeDropwDown);
        advertType.selectByVisibleText("Sale");
        ActionsUtils.pressTab();
        WaitUtils.waitFor(1);
    }

    @Given("Form doldurulur ve 3 MB'tan kucuk resim eklenir")
    public void formDoldur() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='Test Title';", createPropertyPage.titleInput);
        js.executeScript("arguments[0].value='Test Description';", createPropertyPage.descriptionInput);
        js.executeScript("arguments[0].value='999';", createPropertyPage.priceInput);
        WaitUtils.waitFor(1);

        createPropertyPage.categoryDropwDown.click();
        Select category = new Select(createPropertyPage.categoryDropwDown);
        category.selectByVisibleText("Villa");
        System.out.println("category girildi");
        WaitUtils.waitFor(1);


        createPropertyPage.countryDropwDown.click();
        Select country = new Select(createPropertyPage.countryDropwDown);
        country.selectByVisibleText("United Kingdom");
        WaitUtils.waitFor(1);
        createPropertyPage.countryDropwDown.click();
        WaitUtils.waitFor(1);


        js.executeScript("arguments[0].scrollIntoView(true);", createPropertyPage.cityDropwDown);
        js.executeScript("arguments[0].click();", createPropertyPage.cityDropwDown);
        Select city = new Select(createPropertyPage.cityDropwDown);
        city.selectByVisibleText("London");
        WaitUtils.waitFor(1);


        js.executeScript("arguments[0].scrollIntoView(true);", createPropertyPage.districtDropwDown);
        js.executeScript("arguments[0].click();", createPropertyPage.districtDropwDown);
        Select district = new Select(createPropertyPage.districtDropwDown);
        district.selectByVisibleText("Enfield");
        WaitUtils.waitFor(1);
        System.out.println("district girildi");


        js.executeScript("arguments[0].scrollIntoView(true);", createPropertyPage.uploadArea);
        WaitUtils.waitFor(2);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/profilfotosu.jpg";
        createPropertyPage.uploadArea.sendKeys(filePath);
        WaitUtils.waitFor(4);
        System.out.println("Resim Yuklendi");

    }

    @Given("3 MB tan daha buyuk resim yuklenir")
    public void ucMbBuyukResim()  {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", createPropertyPage.uploadArea);
        WaitUtils.waitFor(2);
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/large_sample.jpg";
        createPropertyPage.uploadArea.sendKeys(filePath);
        WaitUtils.waitFor(4);
        System.out.println("Resim Yuklendi");

    }

    @Given("Each image should be a maximum of 3 MB uyarı mesajinin geldiği dogrulanir")
    public void resimUyariMesaji()  {

        assertTrue(createPropertyPage.imageWarning.isDisplayed());


    }























}
