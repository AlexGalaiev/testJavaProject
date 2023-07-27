package org.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public String userName = "standard_user";
    public String userPassword = "secret_sauce";
    public String URL = "https://www.saucedemo.com/";
    @FindBy(id="user-name")
    public WebElement loginField;
    @FindBy(id="password")
    public WebElement passwordField;
    @FindBy(id="login-button")
    public WebElement loginBTN;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public void goToURL(){
        driver.get(URL);
    }

    public BasePage successLoginToPlatform() throws InterruptedException {
        initDriver();
        goToURL();
        loginUser();
    return new CategoryPage(driver);
    }

    public void loginUser(){
        loginField.sendKeys(userName);
        passwordField.sendKeys(userPassword);
        loginBTN.click();
    }

}

