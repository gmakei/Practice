package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

/**
 * Класс с методами явного ожидания
 */
public class Waiters {

    /**
     * Ожидает в течении 5 секунд появления элемента на странице и элемент будет кликабельным.
     *
     * @param driver  экземпляр драйвера браузера
     * @param element элемент
     */
    public static void waitUntilToBeClickable5(final WebDriver driver, WebElement element) {
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitUntilAlertIsPresent5(final WebDriver driver, WebElement element) {
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }
}
