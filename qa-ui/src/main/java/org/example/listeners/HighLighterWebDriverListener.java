package org.example.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class HighLighterWebDriver implements WebDriverListener {
    private WebElement lastElement;

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
if(lastElement != null){
    ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='none' ", lastElement);
}
lastElement = null;
    }


    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        lastElement = result;
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red' ", result);
    }
}
