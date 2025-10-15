package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilToBeClickable5;

/**
 * Класс в котором происходит взаимодействие со страницей FormFieldsPage
 */
public class FormFieldsPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;
    private int automationToolsCount;
    //private int maxLengthSymbolsOfAutomationTools;
    public Optional<Integer>  maxLengthSymbolsOfAutomationTools;
    private String nameOfAutomationToolsWithMaxSymbols;
    private String maxLengthSymbolsNameOfAutomationTools;

    @FindBy(xpath = "//input[@id='name-input']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='drink2']")
    private WebElement checkboxOfMilk;

    @FindBy(xpath = "//input[@id='drink3']")
    private WebElement checkboxOfCoffee;

    @FindBy(xpath = "//input[@id='color3']")
    private WebElement radioOfYellow;

    @FindBy(xpath = "//label[text()='Do you like automation?']")
    private WebElement labelOfDoYouLikeAutomation;

    @FindBy(xpath = "//select[@id='automation']")
    private WebElement selectOfAutomation;



    //@FindBy(xpath = "//label[text()='Automation tools']/ul")
    @FindBy(xpath = "//form[@id='feedbackForm']/ul")
    private static WebElement automationToolsList;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;


    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageTextarea;

    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement buttonSubmit;


    public FormFieldsPage(final WebDriver driver){
        this.driver = driver;

        // для инициализации элемента. ошибка "because 'this nameField' is null"
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод имени в поле Name")
    public FormFieldsPage inputStringInNameField(String str) {
        nameField.click();
        nameField.sendKeys(str);
        makeScreenShot(driver);
        return this;
    }

    @Step("Ввод пароля в поле Password")
    public FormFieldsPage inputStringInPasswordField(String str) {
        passwordField.click();
        passwordField.sendKeys(str);
        makeScreenShot(driver);
        return this;
    }

    @Step("Выбор Milk из списка 'What is your favorite drink?'")
    public FormFieldsPage clickOnCheckboxOfMilk() {
        checkboxOfMilk.click();
        makeScreenShot(driver);
        return this;
    }

    @Step("Выбор Coffee из списка 'What is your favorite drink?'")
    public FormFieldsPage clickOnCheckboxOfCoffee() {
        checkboxOfCoffee.click();
        makeScreenShot(driver);
        return this;
    }

    @Step("Выбор Yellow из списка 'What is your favorite color?'")
    public FormFieldsPage clickOnRadioOfYellow() {
        radioOfYellow.click();
        makeScreenShot(driver);
        return this;
    }

    @Step("Выбор варианта в поле 'Do you like automation?'")
    public FormFieldsPage clickOnSelectOfAutomation() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", labelOfDoYouLikeAutomation);
        waitUntilToBeClickable5(driver, selectOfAutomation);
        Thread.sleep(2000);
        Select select = new Select(selectOfAutomation);
        select.selectByIndex(1);
        makeScreenShot(driver);
        return this;
    }







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

    @Step("Ввод в поле Message кол-во инстр-в и инст-т с наибольшим количеством символов, в пункте Automation tools")
    public FormFieldsPage inputOnMessageTextarea() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", messageTextarea);
        waitUntilToBeClickable5(driver, messageTextarea);
        messageTextarea.click();
        messageTextarea.sendKeys("Count of Automation Tools = " + countAutomationTools() +
                ",\n Name Of Automation Tools With Max Symbols is '" + nameOfToolWithMaxLength() + "'.");
        Thread.sleep(2000);
        makeScreenShot(driver);
        return this;
    }

    @Step("Click on Submit button")
    public FormFieldsPage clickOnButtonSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", buttonSubmit);
        waitUntilToBeClickable5(driver, buttonSubmit);
        buttonSubmit.click();
        return this;
    }

    public void alertInformationTest() {
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "Message received!");
        alert.accept();
    }

    public int countAutomationTools(){
        // Находим элементы списка по селектору (например, CSS или XPath)
        List<WebElement> elements = automationToolsList.findElements(By.tagName("li"));

        // Получаем количество элементов
        automationToolsCount = elements.size();

        // Выводим результат
        return automationToolsCount;
    }


    public Integer nameOfAutomationToolsWithMaxSymbols(){
        List<WebElement> elements = automationToolsList.findElements(By.tagName("li"));

        //maxLengthSymbolsOfAutomationTools = Integer.MIN_VALUE;
        maxLengthSymbolsOfAutomationTools = elements
                .stream()
                .map(s -> s.toString().length())
                .max(Integer::compare);


        if(maxLengthSymbolsOfAutomationTools.isPresent()){
            //System.out.println(maxLengthSymbolsOfAutomationTools.get());
            //return maxLengthSymbolsNameOfAutomationTools = String.valueOf(maxLengthSymbolsOfAutomationTools.get());
            return maxLengthSymbolsOfAutomationTools.get();
        }

        /*int maxLengthSymbolsOfAutomationTool = 0;
        maxLengthSymbolsOfAutomationTools.ifPresent(v -> maxLengthSymbolsOfAutomationTool);*/
        //return maxLengthSymbolsNameOfAutomationTools;

        return -1;
    }

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