package com.org.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    // Timeout constants
    protected static final int DEFAULT_TIMEOUT = 20;

    /**
     * Constructor to initialize WebDriver and WebDriverWait
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        this.actions = new Actions(driver);

    }

    /**
     * Wait for element to be visible
     */
    protected WebElement waitForElementVisible(By locator) {
        logger.info("Waiting for element to be visible: " + locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Wait for element to be clickable
     */
    protected WebElement waitForElementClickable(By locator) {
        logger.info("Waiting for element to be clickable: " + locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * Click on element wrapper
     */
    protected void click(By locator) {
        logger.info("Clicking on element: " + locator);
        waitForElementClickable(locator).click();
    }

    /**
     * Click using JavaScript
     */
    protected void clickUsingJS(By locator) {
        logger.info("Clicking on element using JavaScript: " + locator);
        WebElement element = waitForElementVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Enter text in input field
     */
    protected void enterText(By locator, String text) {
        logger.info("Entering text '" + text + "' in element: " + locator);
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    /**
     * capture keyboard events
     */

    protected void enterKeyboardEvents(By locator, Keys event) {
        logger.info("Enter key board event" + event);
        WebElement element = driver.findElement(locator);
        element.sendKeys(event);
    }
}
