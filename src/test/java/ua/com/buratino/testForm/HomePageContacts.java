package ua.com.buratino.testForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageContacts {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePageContacts(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy
    private By buttonOnOpenPage = By.xpath("//button[@data-rcn-subject]");

    public void openPage () {
// Открываем страницу
        driver.get("https://buratino.com.ua/contacts");
// Ожидаем загрузки элементов на странице
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonOnOpenPage));
    }

}
