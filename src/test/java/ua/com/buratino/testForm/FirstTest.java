package ua.com.buratino.testForm;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ua.com.buratino.WebDriverSettings;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest extends WebDriverSettings {

    @Test // позитивный
    public void seleniumTest() throws InterruptedException {

        HomePageContacts openForm = PageFactory.initElements(driver, HomePageContacts.class);
        openForm.openPage();
        Thread.sleep(3000);
        FillForm fillForm = PageFactory.initElements(driver, FillForm.class);
        Thread.sleep(3000);
        fillForm.openForm();
        Thread.sleep(3000);
        fillForm.fillForm();
        Thread.sleep(3000);
        //fillForm.sendForm();
    }


    @Test // негативный
    public void selenideTest() {
// Инициализируем веб-драйвер
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;

// Открываетм страницу
        Selenide.open("https://buratino.com.ua/contacts");

// Находим форму обратной связи и открываем
        $x("//button[@data-qaid=\"write_us\"]").click();

// Отсылаем назаполненную форму
        $x("//button[@data-qaid=\"send_button\"]").click();

// Проверяем наличие сообщения об ошибке в поле ввода сообщения
        String alertTextAreaMessage = $x("//div[@data-qaid=\"message-input-field\"]//li").getText();
        Assert.assertTrue(alertTextAreaMessage.contains("Это обязательное поле"));

// Проверяем наличие сообщения об ошибке в поле ввода имени
        String alertNameMessage = $x("//div[@data-qaid=\"name-input-field\"]//li").getText();
        Assert.assertTrue(alertNameMessage.contains("Это обязательное поле"));

// Проверяем наличие сообщения об ошибке в поле ввода емейла
        String alertEmailMessage = $x("//div[@data-qaid=\"email-input-field\"]//li").getText();
        Assert.assertTrue(alertEmailMessage.contains("Это обязательное поле"));

// Проверяем наличие сообщения об ошибке в поле телефона
        String alertPhoneMessage = $x("//div[@data-qaid=\"phone-input-field\"]//li").getText();
        Assert.assertTrue(alertPhoneMessage.contains("Введите номер телефона в таком формате: +380960000000"));
    }
}

