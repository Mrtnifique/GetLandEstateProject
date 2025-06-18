package getlandestate.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


public class BrowserUtils {

    /**
     * Belirtilen elemente belirli bir süre boyunca tıklamaya çalışır.
     *
     * @param element Tıklanacak WebElement.
     * @param timeout Deneme süresi (saniye).
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                WaitUtils.waitFor(1);
            }
        }
    }

    /**
     * Belirtilen elementin metnini belirli bir süre boyunca almaya çalışır.
     *
     * @param element Metni alınacak WebElement.
     * @param timeout Deneme süresi (saniye).
     * @return Alınan metin.
     */
    public static String getTextWithTimeout(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                WaitUtils.waitFor(1);
            }
        }
        return null;
    }

    /**
     * Belirtilen elemente belirli bir süre boyunca metin göndermeye çalışır.
     *
     * @param element Metin gönderilecek WebElement.
     * @param text    Gönderilecek metin.
     * @param timeout Deneme süresi (saniye).
     */
    public static void sendKeysWithTimeout(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                WaitUtils.waitFor(1);
            }
        }
    }

    /**
     * Belirtilen indeksteki radio butonuna tıklar.
     *
     * @param index Tıklanacak radio butonunun indeksi.
     */
    public void radioClickByIndex(int index) {
        int numOfRadio = Driver.getDriver().findElements(By.xpath("//input[@type='radio']")).size();
        for (int i = 0; i < numOfRadio; i++) {
            if (!Driver.getDriver().findElements(By.xpath("//input[@type='radio']")).get(index).isSelected()) {
                Driver.getDriver().findElements(By.xpath("//input[@type='radio']")).get(index).click();
            }
        }
    }

    /**
     * Belirtilen indeksteki checkbox butonuna tıklar.
     *
     * @param index Tıklanacak checkbox butonunun indeksi.
     */
    public void checkboxClickByIndex(int index) {
        int numOfRadio = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).size();
        try {
            for (int i = 0; i < numOfRadio; i++) {
                if (!Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).get(index).isSelected()) {
                    Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dropdown menüsünden görünen metin ile seçim yapar.
     *
     * @param element Dropdown WebElement.
     * @param text    Seçilecek metin.
     */
    public static void dropdownSelectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(text)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    /**
     * Dropdown menüsünden indeks ile seçim yapar.
     *
     * @param element Dropdown WebElement.
     * @param index   Seçilecek indeks.
     */
    public static void dropdownSelectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }

    /**
     * Dropdown menüsünden değer ile seçim yapar.
     *
     * @param element Dropdown WebElement.
     * @param value   Seçilecek değer.
     */
    public static void dropdownSelectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        objSelect.selectByValue(value);
    }

    /**
     * Dropdown menüsünden verilen metin ile seçim yapar.
     *
     * @param element        Dropdown WebElement.
     * @param textOfDropdown Seçilecek metin.
     */
    public static void dropdownSelectOption(WebElement element, String textOfDropdown) {
        List<WebElement> options = element.findElements(By.tagName("option"));
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)) {
                option.click();
                break;
            }
        }
    }

    /**
     * Dropdown listesinden rastgele bir değer seçer ve seçilen WebElement'i döner.
     *
     * @param select Dropdown Select nesnesi.
     * @return Seçilen WebElement.
     */
    public static WebElement dropdownSelectRandomText(Select select) {
        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    /**
     * Dropdown menüsünden seçilen tüm seçeneklerin metinlerini bir ArrayList olarak döner.
     *
     * @param element Dropdown WebElement.
     * @return Seçilen metinlerin listesi.
     * @throws Exception Eğer element null ise.
     */
    public ArrayList<String> dropdownGetSelectedOptions(WebElement element) throws Exception {
        if (element != null) {
            Select list = new Select(element);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<>();
            for (WebElement eachSelected : allSelectedOptions) {
                result.add(eachSelected.getText());
            }
            return result;
        } else {
            throw new Exception("No element is returned");
        }
    }

    /**
     * Belirtilen elementin sayfada görüntülenip görüntülenmediğini doğrular.
     * Element bulunamaz veya görüntülenemezse test başarısız olur.
     *
     * @param element Görüntülenmesi istenen WebElement.
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Element is not found: " + element);
        }
    }

    /**
     * Belirtilen locatora sahip elementin sayfada görüntülenip görüntülenmediğini doğrular.
     * Element bulunamaz veya görüntülenemezse test başarısız olur.
     *
     * @param by Görüntülenmesi istenen locator.
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Element not found: " + by);
        }
    }

    /**
     * Belirtilen locatora sahip elementin sayfada görüntülenmediğini doğrular.
     * Element bulunamaz veya görüntülenemezse test başarısız olur.
     *
     * @param by Görüntülenmemesi istenen locator.
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Belirtilen WebElement'in sayfada görüntülenmediğini doğrular.
     * Element bulunamaz veya görüntülenemezse test başarısız olur.
     *
     * @param element Görüntülenmemesi istenen WebElement.
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Belirtilen elementin tıklanabilir olup olmadığını doğrular.
     *
     * @param element Tıklanabilir olup olmadığı doğrulanacak WebElement.
     */
    public static void verifyElementClickable(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Element not found: " + element);
        }
    }

    /**
     * Belirtilen elementin tıklanabilir olmadığını doğrular.
     *
     * @param element Tıklanabilir olmaması gereken WebElement.
     */
    public static void verifyElementNotClickable(WebElement element) {
        try {
            assertFalse("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Beklenen ve gerçek metinlerin eşleşip eşleşmediğini doğrular.
     *
     * @param expectedText  Beklenen metin.
     * @param actualElement Gerçek metni içeren WebElement.
     */
    public static void verifyExpectedAndActualTextMatch(String expectedText, WebElement actualElement) {
        try {
            // Senkronizasyon sorununu önlemek için bekleyin ve ardından metni alın
            WaitUtils.waitForVisibility(actualElement, 10);
            assertEquals(expectedText, actualElement.getText());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Açılır uyarıyı kabul eder.
     *
     * @throws InterruptedException Eğer bir kesinti olursa.
     */
    public void alertAccept() throws InterruptedException {
        Driver.getDriver().switchTo().alert().accept();
    }

    /**
     * Açılır uyarıyı reddeder.
     *
     * @throws InterruptedException Eğer bir kesinti olursa.
     */
    public void alertDismiss() throws InterruptedException {
        Driver.getDriver().switchTo().alert().accept();
    }

    /**
     * Belirtilen xpath'e sahip iframe'e geçiş yapar.
     *
     * @param xpath Iframe'in xpath'i.
     */
    public static void frameSwitchTo(String xpath) {
        WebElement iframeElement = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.getDriver().switchTo().frame(iframeElement);
    }

    /**
     * Belirtilen indeksteki iframe'e geçiş yapar.
     *
     * @param index Iframe'in indeksi.
     */
    public static void frameSwitchTo(int index) {
        Driver.getDriver().switchTo().frame(index);
    }

    /**
     * Belirtilen başlığa sahip pencereye geçiş yapar.
     *
     * @param targetTitle Geçiş yapılacak pencerenin başlığı.
     */
    public static void windowSwitchTo(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String childWindow : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(childWindow);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                System.out.println("Switched to the window : " + targetTitle);
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Belirtilen indeksteki pencereye geçiş yapar.
     *
     * @param windowIndex Geçiş yapılacak pencerenin indeksi.
     */
    public static void windowSwitchTo(int windowIndex) {
        List<String> list = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(list.get(windowIndex));
    }
}
