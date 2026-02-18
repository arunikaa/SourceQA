package com.org.Base;

import com.org.Utilities.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BaseTest {
    public WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);


    /**
     * Setup before entire test suite
     */
    @BeforeSuite
    public void beforeSuite() {
        logger.info("========== Test Suite Started ==========");

    }

    @BeforeClass
    public void setUp() {

        logger.info("Launching browser");
        driver = new ChromeDriver();   // Selenium Manager works here
        driver.manage().window().maximize();
        driver.get(Util.get("base.url"));

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
