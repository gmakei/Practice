import config.PracticeAutomationTestsConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.FormFieldsPage;

/**
 * Основной класс с тестами HomePage
 */
@Epic("Form-fields Page")
@Feature("Проверка работы страницы формы")
public class FormFieldsPageTest extends BaseTest{

    /**
     * Экземпляр конфигурации с параметрами для practice-automation.com/form-fields страницы тестов
     */
    private final PracticeAutomationTestsConfig config = ConfigFactory.create(
                                                        PracticeAutomationTestsConfig.class,
                                                                System.getenv());
    @Test(description = "Проверка страницы формы с валидными данными. Позитивная проверка")
    @TmsLink("FFP-001")
    @Story("Позитивная проверка класса FormFieldsPageTest")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("G.Makeev")
    public void testFormFieldsPage() throws InterruptedException {
        new FormFieldsPage(driver)
            .inputStringInNameField(config.inputName())
            .inputStringInPasswordField(config.inputPassword())
            .clickOnCheckboxOfMilk()
            .clickOnCheckboxOfCoffee()
            .clickOnRadioOfYellow()
            .clickOnSelectOfAutomation()
            .inputStringInEmailField(config.inputEmail())
            .inputOnMessageTextarea()
            .clickOnButtonSubmit()
            .alertInformationTest();
    }
}
