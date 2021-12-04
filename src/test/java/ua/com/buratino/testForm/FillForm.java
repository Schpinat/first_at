package ua.com.buratino.testForm;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillForm {

    private WebDriver driver;
    private WebDriverWait wait;

    public FillForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @FindBy
    private By buttonOnOpenPage = By.xpath("//button[@data-rcn-subject]");
    private By buttonForm = By.xpath("//button[@data-qaid=\"send_button\"]");
    private By textarea = By.xpath("//textarea");
    private By from_first_name = By.xpath("//input[@name=\"from_first_name\"]");
    private By from_email = By.cssSelector("input[name='from_email']");
    private By phone = By.xpath("//input[@name=\"phone\"]");
    private By send_button = By.xpath("//button[@data-qaid=\"send_button\"]");
    private By acceptForm = By.xpath("//p[@class=\"h-mb-20\"]");

       public void openForm () {
//Ищем форму для отправки сообщения и шлем текст
        driver.findElement(buttonOnOpenPage).click();
// Ожидаем загрузки формы
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonForm));
    }

    public void fillForm () {
// Заполняем форму
        WebElement textArea = driver.findElement(textarea);
        textArea.click();
        textArea.sendKeys(
                "Кум, привет! " +
                        "Как на счет позвонить мне?");

        WebElement textName = driver.findElement(from_first_name);
        textName.click();
        textName.sendKeys("Кум кума");

        WebElement textEmail = driver.findElement(from_email);
        textEmail.click();
        textEmail.sendKeys("yourgod1@gmail.ua");

        WebElement textPhone = driver.findElement(phone);
        textPhone.click();
        textPhone.sendKeys("736072009");
    }

    public void sendForm () {
// Отправляем форму
        WebElement sendMessageButton = driver.findElement(send_button);
        sendMessageButton.click();
// Ожидаем загрузки окна успешной отправки (лучше проверять на наличие текста сообщения)
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptForm));
        driver.close();
    }

}
