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
    void test(String format, String format_2, String format_3, List<List<String>> switchers, List<String> checkBox) {
        this.driver.get("https://demoqa.com/checkbox");

        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10)); // Explicit expectation

        List<String> switchersFirst = switchers.getFirst();
        for (var text : switchersFirst) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format, text));
        }

        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Home"));

        List<String> switchersLast = switchers.getLast();
        for (var text : switchersLast) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format_2, text));
        }

        this.checkCloseDriver(webDriverWait, this.checkFormatString(format_3, "Home"));

        for(var text : switchersFirst) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format, text));
        }

        for(var checkbox : checkBox) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, checkbox));
        }

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