package org.example;
import io.qameta.allure.Step;
import org.example.manager.Manager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Tag("Radio")
@DisplayName("Demosite")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RadioButton {
    private final Logger logger = LoggerFactory.getLogger(RadioButton.class);
    private final Manager manager = new Manager();

    private WebDriverWait webDriverWait;
    private ChromeDriver driver;
    @BeforeEach
    void open() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    @Step("Выполняем вход, на сайт")
    @DisplayName("Выполняем вход, на сайт")
    void radioButton() {
        this.driver.get("https://demoqa.com/radio-button");
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Кликаем по кнопке (Да)
        String yes = Manager.Format_xPath("yesRadio");
        this.clickRadioButton(this.webDriverWait, yes);
        this.getResultRadioButton(this.webDriverWait, Manager.getAttributeValue());
        Assertions.assertEquals("Yes", manager.getValue(), "Ошибка, не найден (Yes)");
        // Кликаем по кнопке (Забавно)
        String impressive = Manager.Format_xPath("impressiveRadio");
        this.clickRadioButton(this.webDriverWait, impressive);
        this.getResultRadioButton(webDriverWait, Manager.getAttributeValue());
        Assertions.assertEquals("Impressive", manager.getValue(), "Ошибка, не найден (Impressive)");
        // Кликаем по заблокированной кнопке (Нет)
        String no = Manager.Format_xPath("noRadio");
        this.clickRadioButtonDisable(this.webDriverWait, no);
        Assertions.assertFalse(manager.isEnable(), "Ошибка, кнопка должна быть (false)");

    }
    @Step("Нажимаем на кнопку радио: {value}")
    void clickRadioButton(WebDriverWait webDriverWait, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).click();
        logger.info("radio button: {}", value);

    }
    @Step("Нажимаем на кнопку если активна")
    void clickRadioButtonDisable(WebDriverWait webDriverWait, String value) {
        boolean isEnable = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).isEnabled();
        logger.info("noRadio: {}", isEnable);
        this.manager.setEnable(isEnable);
    }
    @Step("Получаем результат после нажатие")
    void getResultRadioButton(WebDriverWait webDriverWait, String value) {
       String text = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value))).getText();
       this.manager.setValue(text);
    }

    @AfterEach
    void close() {
        if(this.driver != null) {
            this.driver.quit();
        } else {
            this.logger.error("driver error: {}", driver);
        }
    }
}