package ua.com.buratino;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebDriverSettings {

public WebDriver driver;
public WebDriverWait wait;

@Before
    public void startDriverSettings () {
    System.setProperty("webdriver.chrome.driver","D:\\JAVA\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}
@After
    public void close () {
//    driver.quit();
}
}
