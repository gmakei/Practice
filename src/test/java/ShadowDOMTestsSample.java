import config.PracticeAutomationTestsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FormFieldsPage;

public class ShadowDOMTestsSample extends BaseTest{

    private final PracticeAutomationTestsConfig config = ConfigFactory.create(
            PracticeAutomationTestsConfig.class,
            System.getenv());

    @Test
    public void testShadowDOM() throws InterruptedException {

        //FormFieldsPage formFieldsPage = new FormFieldsPage(driver);

        driver.get("https://practice-automation.com/form-fields/");
        WebElement content = driver.findElement(By.id("name-input"));
        System.out.println(content.toString());


        SearchContext shadowRoot = content.getShadowRoot();
        System.out.println(shadowRoot.toString());
        WebElement textElement = shadowRoot.findElement(By.cssSelector("div"));
        System.out.println(textElement.toString());
        textElement.sendKeys("Test name");

        Thread.sleep(2000);
        //Assert.assertEquals(textElement.getText(), "Hello Shadow DOM", "Text does not match!");

    }
}
