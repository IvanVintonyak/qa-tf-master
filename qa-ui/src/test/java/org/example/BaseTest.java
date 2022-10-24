package org.example;

import io.qameta.allure.Allure;
import org.example.browser.WebDriverFactory;
import org.example.constants.TestConstants;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class BaseTest {
   private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod(description = "Set up hte browser ")
    public void beforeMethod(ITestContext iTestContext) {
        WebDriver driver = new WebDriverFactory().getDriver();
        setWebDriver(driver);
        setDriverToContext(iTestContext, driver);
    }

    @AfterMethod(description = "quit the WebDriver")
    public void afterMethod(ITestResult result) {
//        if (!result.isSuccess()) {
//            File screenshot = ScreenshotUtils.getScreenshot(getWebDriver());
//            try {
//                Allure.getLifecycle().addAttachment(UUID.randomUUID().toString(), null, null,
//                        Files.newInputStream(screenshot.toPath()));
//            } catch (IOException e) {
//                LOGGER.warn("Could not take screenshot");
//            }
//        }
        getWebDriver().quit();
    }
    private void setWebDriver (WebDriver driver){
        driverThreadLocal.set(driver);
    }

    public WebDriver getWebDriver () {
        return driverThreadLocal.get();
    }

    public void setDriverToContext(ITestContext iTestContext, WebDriver driver ){
        iTestContext.setAttribute(TestConstants.WEB_DRIVER,  driver);
    }
}
