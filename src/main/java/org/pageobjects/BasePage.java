package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.core.page.PageObject;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public char[] getElementArrayText(WebElement element) {
        return element.getText().toCharArray();
    }
    public boolean elementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    };

    public void waitElement(WebElement elementToWait){
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOf(elementToWait));
    }
    public void waitElementDissapear(WebElement elementToWait){
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.invisibilityOf(elementToWait));
    }
    public WebElement findElementById(String elementID) {
        WebElement element = driver.findElement(By.id(elementID));
        return element;
    }
    public WebElement findElementByClass(String elementClass){
        WebElement element = driver.findElement(By.className(elementClass));
        return element;
    }
    public void scrollScrinToElement(WebElement elementToscroll) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(elementToscroll);
    }

}

