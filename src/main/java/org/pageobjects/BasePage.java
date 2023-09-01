package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkElementsDownloaded(WebElement element) {
        return element.isDisplayed();
    }
    public String getElementText(WebElement element) {
        return element.getText();
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

    }
    public void clickBtn(WebElement element){
        element.click();
    }


}

