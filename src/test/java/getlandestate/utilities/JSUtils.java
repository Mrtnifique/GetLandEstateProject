package getlandestate.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {

    /**
     * Belirtilen elemente kaydırma yapar.
     *
     * @param element Kaydırma yapılacak WebElement.
     */
    public static void JSscrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Sayfanın en altına kadar kaydırma yapar.
     */
    public static void JSscrollAllTheWayDown() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Sayfanın en üstüne kadar kaydırma yapar.
     */
    public static void JSscrollAllTheWayUp() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    /**
     * Belirtilen elemente tıklar, öncesinde elementin görünür olmasını bekler ve kaydırma yapar.
     *
     * @param element Tıklanacak WebElement.
     */
    public static void JSclickWithTimeout(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(element, 5));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Belirtilen ID'ye sahip elementi locate eder ve döner.
     *
     * @param idOfElement Locate edilecek elementin ID'si.
     * @return Locate edilen WebElement.
     */
    public WebElement JSlocateElements(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        return ((WebElement) js.executeScript("return document.getElementById('" + idOfElement + "')"));
    }

    /**
     * Belirtilen elemente verilen metni yazar.
     *
     * @param inputElement Metin yazılacak WebElement.
     * @param text         Yazılacak metin.
     */
    public static void JSsetValueBy(WebElement inputElement, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputElement);
    }

    /**
     * Belirtilen ID'ye sahip elementin değerini döner.
     *
     * @param idOfElement Değeri alınacak elementin ID'si.
     * @return Elementin değeri.
     */
    public static String JSgetValueBy(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);
        return value;
    }
}
