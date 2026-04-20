package com.org.Base;

import com.org.Utilities.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        String browser = Util.get("browser");
        logger.info("Browser selected: {}", browser);
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();            // Selenium Manager auto-handles driver
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(
                        "Browser '" + browser + "' is not supported. " +
                                "Valid values: chrome, firefox, edge"
                );
        }

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
