package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Optional;
import static org.testng.Assert.assertEquals;
import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilAlertIsPresent5;
import static utils.Waiters.waitUntilToBeClickable5;

/**
 * Класс в котором происходит взаимодействие со страницей FormFieldsPage (https://practice-automation.com/form-fields/)
 */
public class FormFieldsPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;
    private int automationToolsCount;

    /**
     * Элемент "Name" на странице
     */
    @FindBy(xpath = "//input[@id='name-input']")
    private WebElement nameField;

    /**
     * Элемент "Password" на странице
     */
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    /**
     * Элемент checkbox "Milk" на странице
     */
    @FindBy(xpath = "//input[@id='drink2']")
    private WebElement checkboxOfMilk;

    /**
     * Элемент checkbox "Coffee" на странице
     */
    @FindBy(xpath = "//input[@id='drink3']")
    private WebElement checkboxOfCoffee;

    /**
     * Элемент radiobutton "Yellow" на странице
     */
    @FindBy(xpath = "//input[@id='color3']")
    private WebElement radioOfYellow;

    /**
     * Элемент label "Do you like automation?" на странице
     */
    @FindBy(xpath = "//label[text()='Do you like automation?']")
    private WebElement labelOfDoYouLikeAutomation;

    /**
     * Элемент select "Do you like automation?" на странице
     */
    @FindBy(xpath = "//select[@id='automation']")
    private WebElement selectOfAutomation;

    /**
     * Элемент unordered list "Automation tools" на странице
     */
    @FindBy(xpath = "//form[@id='feedbackForm']/ul")
    private static WebElement automationToolsList;

    /**
     * Элемент "Email" на странице
     */
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    /**
     * Элемент "Textarea" на странице
     */
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageTextarea;

    /**
     * Элемент button "Submit" на странице
     */
    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement buttonSubmit;

    /**
     * Конструктор для FormFieldsPage
     * @param driver
     */
    public FormFieldsPage(final WebDriver driver){
        this.driver = driver;

        // для инициализации элемента. ошибка "because 'this nameField' is null"
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод для ввода имени в поле Name
     * @return FormFieldsPage
     */
    @Step("Ввод имени в поле Name")
    public FormFieldsPage inputStringInNameField(String str) {
        nameField.click();
        nameField.sendKeys(str);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для ввода имени в поле Password
     * @return FormFieldsPage
     */
    @Step("Ввод пароля в поле Password")
    public FormFieldsPage inputStringInPasswordField(String str) {
        passwordField.click();
        passwordField.sendKeys(str);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для клика на элемент checkbox Milk
     * @return FormFieldsPage
     */
    @Step("Выбор Milk из списка 'What is your favorite drink?'")
    public FormFieldsPage clickOnCheckboxOfMilk() {
        checkboxOfMilk.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для клика на элемент checkbox Coffee
     * @return FormFieldsPage
     */
    @Step("Выбор Coffee из списка 'What is your favorite drink?'")
    public FormFieldsPage clickOnCheckboxOfCoffee() {
        checkboxOfCoffee.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для клика на элемент radiobutton Yellow
     * @return FormFieldsPage
     */
    @Step("Выбор Yellow из списка 'What is your favorite color?'")
    public FormFieldsPage clickOnRadioOfYellow() {
        radioOfYellow.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для клика на элемент select 'Do you like automation?'
     * @return FormFieldsPage
     */
    @Step("Выбор варианта в поле 'Do you like automation?'")
    public FormFieldsPage clickOnSelectOfAutomation() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", labelOfDoYouLikeAutomation);
        waitUntilToBeClickable5(driver, selectOfAutomation);
        Select select = new Select(selectOfAutomation);
        select.selectByIndex(1);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для ввода имени в поле Email
     * @return FormFieldsPage
     */
    @Step("Ввод адреса эл.почты в поле Email")
    public FormFieldsPage inputStringInEmailField(String str) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", emailField);
        waitUntilToBeClickable5(driver, emailField);
        emailField.click();
        emailField.sendKeys(str);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для ввода в поле Message данных о кол-ве инстр-в и инст-те с наибольшим количеством символов, в пункте 'Automation tools'
     * @return FormFieldsPage
     */
    @Step("Ввод в поле Message кол-во инстр-в и инст-т с наибольшим количеством символов, в пункте Automation tools")
    public FormFieldsPage inputOnMessageTextarea() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", messageTextarea);
        waitUntilToBeClickable5(driver, messageTextarea);
        messageTextarea.click();
        messageTextarea.sendKeys("Count of Automation Tools = " + countAutomationTools() +
                ",\n Name Of Automation Tools With Max Symbols is '" + nameOfToolWithMaxLength() + "'.");
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для клика на элемент button 'Submit'
     * @return FormFieldsPage
     */
    @Step("Click on Submit button")
    public FormFieldsPage clickOnButtonSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", buttonSubmit);
        waitUntilToBeClickable5(driver, buttonSubmit);
        buttonSubmit.click();
        return this;
    }

    /**
     * Метод для проверки сообщения в alert окне
     */
    public void alertInformationTest() throws InterruptedException {
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "Message received!");
        alert.accept();
    }

    /**
     * Метод для расчета количества инструментов, описанных в пункте 'Automation tools'
     * @return automationToolsCount
     */
    public int countAutomationTools(){
        // Находим элементы списка по селектору (например, CSS или XPath)
        List<WebElement> elements = automationToolsList.findElements(By.tagName("li"));

        // Получаем количество элементов
        automationToolsCount = elements.size();

        // Выводим результат
        return automationToolsCount;
    }

    /**
     * Метод для определния названия инструмента из списка 'Automation tools', содержащий наибольшее количество символов
     * @return nameOfToolWithMaxLength
     */
    public String nameOfToolWithMaxLength() {
        List<WebElement> elements = automationToolsList.findElements(By.tagName("li"));
        int maxLengthNameOfTool = 0;
        String nameOfToolWithMaxLength = "";

        for (WebElement s : elements) {
            if (maxLengthNameOfTool < s.getText().length()) {
                nameOfToolWithMaxLength = s.getText();
            }
        }
        return nameOfToolWithMaxLength;
    }
}