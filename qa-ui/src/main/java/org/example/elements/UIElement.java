package org.example.elements;

import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class UIElement {

    protected WebDriver driver;
    protected By by;
    protected String labelName;

    public UIElement(WebDriver driver, By by) {
        this(driver, by, StringUtil.EMPTY_STRING);

    }

    public UIElement(WebDriver driver, By by, String labelName) {
        this.driver = driver;
        this.by = by;
        this.labelName = labelName;
    }

    public WebElement getWebElement() {
        return driver.findElement(by);
    }
}
