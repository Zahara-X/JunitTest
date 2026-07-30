package selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
@Tag("Selenium")
@DisplayName("Open browser")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumApp {
    private WebDriverWait webDriverWait;
    private ChromeDriver driver;
    @BeforeAll
    void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    @DisplayName("open browser")
    void open() {
        driver.get("https://demoqa.com/checkbox");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkOwner =  webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'rc-tree-switcher_close')][//span[text()='Home']]")));
        checkOwner.click();
        WebElement checkDesktop = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'rc-tree-switcher_close')][//span[text()='Desktop']]")));
        checkDesktop.click();

    }
    @AfterAll
    void down() {
        if(driver != null) {
            driver.quit();
        }
    }
}