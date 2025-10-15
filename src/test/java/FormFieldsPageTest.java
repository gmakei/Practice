import config.PracticeAutomationTestsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.FormFieldsPage;

public class FormFieldsPageTest extends BaseTest{

    private final PracticeAutomationTestsConfig config = ConfigFactory.create(
                                                        PracticeAutomationTestsConfig.class,
                                                                System.getenv());
    @Test
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
