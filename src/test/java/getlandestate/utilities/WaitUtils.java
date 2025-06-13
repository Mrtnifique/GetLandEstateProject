package getlandestate.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    /**
     * Yeni bir sayfa açıldığında sayfanın tamamen yüklenmesini bekler.
     * @param timeout Sayfanın yüklenmesi için maksimum bekleme süresi (saniye).
     */
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    /**
     * Fluent Wait kullanarak belirtilen elementin görünürlüğünü bekler.
     * @param xpath Elementin xpath'i.
     * @param withTimeout Maksimum bekleme süresi (saniye).
     * @param pollingEvery Elementi kontrol etme sıklığı (saniye).
     * @return Beklenen element.
     */
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(withTimeout)) // Toplam bekleme süresi
                .pollingEvery(Duration.ofSeconds(pollingEvery)) // Kontrol etme sıklığı
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    /**
     * Belirtilen süre boyunca bekler (hard wait).
     * @param seconds Beklenecek süre (saniye).
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Belirtilen elementin görünür olmasını bekler.
     * @param element Görünürlüğü beklenen WebElement.
     * @param timeout Maksimum bekleme süresi (saniye).
     * @return Görünür olan WebElement.
     */
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Belirtilen locator ile elementin görünür olmasını bekler.
     * @param locator Görünürlüğü beklenen locator.
     * @param timeout Maksimum bekleme süresi (saniye).
     * @return Görünür olan WebElement.
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Belirtilen elementin tıklanabilir olmasını bekler.
     * @param element Tıklanabilirliği beklenen WebElement.
     * @param timeout Maksimum bekleme süresi (saniye).
     * @return Tıklanabilir olan WebElement.
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Belirtilen locator ile elementin tıklanabilir olmasını bekler.
     * @param locator Tıklanabilirliği beklenen locator.
     * @param timeout Maksimum bekleme süresi (saniye).
     * @return Tıklanabilir olan WebElement.
     */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
