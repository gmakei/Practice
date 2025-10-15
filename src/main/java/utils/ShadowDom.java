package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDom {
    /*public static WebElement getShadowElement(WebDriver driver,
                                              WebElement shadowHost,
                                              String cssSelector) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(
                "return arguments[0].shadowRoot.querySelector(arguments[1])",
                shadowHost, cssSelector);
    }*/

    public static WebElement getShadowElement(WebDriver driver,
                                              WebElement shadowHost,
                                              String cssSelector) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(
                "return arguments[0].shadowRoot.querySelector(arguments[1])",
                shadowHost, cssSelector);
    }
}
