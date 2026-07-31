package my.test.checkbox;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junitpioneer.jupiter.RetryingTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

@Tag("App")
@DisplayName("Chrome")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WithersAppTest {
    private final Logger logger = LoggerFactory.getLogger(WithersAppTest.class);
    private volatile ChromeDriver driver;
    private volatile WebDriverWait webDriverWait;
    private static String data;
    @BeforeEach
    void start() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @ParameterizedTest
    @DisplayName("withers box")
    @MethodSource("my.test.checkbox.ValueArguments#arguments")
    void test(ValueArguments value) {
        this.driver.get("https://demoqa.com/checkbox");

        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10)); // Explicit expectation

        this.openedSwitchers(value); // open
        this.clickSwitcherDriver(webDriverWait, this.checkFormatString(value.getCheckbox(), "Home"));
        data = this.getResultSelectedDriver(webDriverWait, value.getResult());
        this.closedSwitchers(value); // close
        this.openedSwitchers(value); // open
        this.clickCheckBoxDriver(value); // click check
        this.closedSwitchers(value); // close
    }
    @ParameterizedTest
    @DisplayName("Проверяем данные")
    @MethodSource("my.test.checkbox.ValueArguments#arguments")
    void testResult(ValueArguments value) {
         String oldData = value.getData();
         String data_input = data.replace("You have selected :", "").trim();
         String actual = oldData.replace("You have selected :", "").trim();
         Assertions.assertAll(() -> Assertions.assertNotNull(actual, "Error data null"),
                 () -> Assertions.assertNotNull(data_input, "Error data null"));
         Assertions.assertEquals(data_input, actual, "Error, data not actual");
    }
    void openedSwitchers(ValueArguments value) {
        List<String> switchersFirst = value.getSwitchers().getFirst();
        for (var text : switchersFirst) {
            this.clickSwitcherDriver(webDriverWait, this.checkFormatString(value.getSwitcher(), text));
        }
    }
    void closedSwitchers(ValueArguments value) {
        List<String> switchersLast = value.getSwitchers().getLast();
        for (var text : switchersLast) {
            this.clickSwitcherDriver(webDriverWait, this.checkFormatString(value.getSwitcher(), text));
        }
    }

    void clickCheckBoxDriver(ValueArguments value) {
        for(var checkbox : value.getChecksBox()) {
            this.clickSwitcherDriver(webDriverWait, this.checkFormatString(value.getCheckbox(), checkbox));
        }
    }
    void clickSwitcherDriver(WebDriverWait webDriverWait, final String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).click();
    }
    public String getResultSelectedDriver(WebDriverWait webDriverWait, final String value) {
        WebElement result = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
        return result.getText();
    }
    public String checkFormatString(String format, String value) {
        return String.format(format, value);
    }

    @AfterEach
    void stop() {
     if(this.driver != null && webDriverWait != null) {
         logger.info("Closing Chrome driver");
         driver.quit();
     } else {
         logger.error("drive is null: {}", driver);
         logger.error("WebDriverWait is null: {}", webDriverWait);
     }
    }
}