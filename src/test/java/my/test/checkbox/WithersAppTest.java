package my.test.checkbox;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
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

        List<String> switchersFirst = value.getSwitchers().getFirst();
        for (var text : switchersFirst) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(value.getSwitcher_1(), text));
        }

        this.checkClickDriver(webDriverWait, this.checkFormatString(value.getCheckbox(), "Home"));

        List<String> switchersLast = value.getSwitchers().getLast();
        for (var text : switchersLast) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(value.getSwitcher_2(), text));
        }

        // Close check
        this.checkCloseDriver(webDriverWait, this.checkFormatString(value.getCheckbox(), "Home"));
//
//        for(var checkbox : value.getChecksBox()) {
//            this.checkClickDriver(webDriverWait, this.checkFormatString(value.getCheckbox(), checkbox));
//        }

    }

    void checkClickDriver(WebDriverWait webDriverWait, final String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).click();
    }
    void checkCloseDriver(WebDriverWait webDriverWait, final String value) {
       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).click();
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