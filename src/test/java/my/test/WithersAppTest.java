package my.test;

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
    @MethodSource("my.test.ValueArguments#arguments")
    void test(String format, String format_2, String format_3, List<List<String>> texts) {
        this.driver.get("https://demoqa.com/checkbox");

        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10)); // Explicit expectation

        List<String> textFirst = texts.getFirst();
        for (var text : textFirst) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format, text));
        }

        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Home"));

        List<String> textLast = texts.getLast();
        for (var text : textLast) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format_2, text));
        }

        this.checkCloseDriver(webDriverWait, this.checkFormatString(format_3, "Home"));

        for(var text : textFirst) {
            this.checkClickDriver(webDriverWait, this.checkFormatString(format, text));
        }

        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Notes"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Commands"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "React"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Angular"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Veu"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Public"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Private"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Classified"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "General"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Word File.doc"));
        this.checkClickDriver(webDriverWait, this.checkFormatString(format_3, "Excel File.doc"));

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