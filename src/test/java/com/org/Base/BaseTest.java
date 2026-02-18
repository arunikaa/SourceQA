package com.org.Base;

import com.org.Utilities.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    private final By acceptCookies = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    /**
     * Setup before entire test suite
     */
    @BeforeSuite
    public void beforeSuite() {
        logger.info("========== Test Suite Started ==========");
       // handleCookieConsent();


    }

    /**
     * Click cookie consent button before starting the execution
     */

    public void handleCookieConsent() {
        // Wait for cookie banner to appear (with shorter timeout to avoid delays)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        cookieButton.click();
        logger.info("Cookie consent accepted successfully");
    }

    @BeforeMethod
    public void setUp() {

        logger.info("Launching browser");
        driver = new ChromeDriver();   // Selenium Manager works here
        driver.manage().window().maximize();
        driver.get(Util.get("base.url"));

    }

    @AfterMethod
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
