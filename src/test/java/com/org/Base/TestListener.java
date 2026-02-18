package com.org.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Add screenshots to the folder for each failed test cases
 */
   public class TestListener implements ITestListener {
        private static final Logger logger = LogManager.getLogger(TestListener.class);

        @Override
        public void onTestFailure(ITestResult result) {
            logger.error("Test Failed: " + result.getName());

            Object testClass = result.getInstance();
            WebDriver driver = ((BaseTest) testClass).driver;

            if (driver != null) {
                captureScreenshot(driver, result.getName());
            }
        }

        private void captureScreenshot(WebDriver driver, String testName) {
            try {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = testName + "_" + timestamp + ".png";

                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destination = new File("screenshots/" + fileName);

                FileUtils.copyFile(screenshot, destination);
                logger.info("Screenshot saved: " + destination.getAbsolutePath());

            } catch (Exception e) {
                logger.error("Failed to capture screenshot: " + e.getMessage());
            }
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            logger.info("Test Passed: " + result.getName());
        }

        @Override
        public void onTestStart(ITestResult result) {
            logger.info("Test Started: " + result.getName());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            logger.warn("Test Skipped: " + result.getName());
        }
    }

