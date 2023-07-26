package org.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;
    private String userName = "standard_user";
    private String userPassword = "secret_sauce";
    private String URL = "https://www.saucedemo.com/";

    public String getUserName() {
        return userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public String getURL() {
        return URL;
    }
    @FindBy(id="user-name")
    private WebElement loginField;
    @FindBy(id="password")
    private WebElement passwordField;
    @FindBy(id="login-button")
    private WebElement loginBTN;

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
        driver.get(getURL());
    }

    public WebDriver closeDriver() {
        driver.quit();
        return null;
    }
    public CategoryPage successLoginToPlatform() throws InterruptedException {
        initDriver();
        goToURL();
        waitElement(loginField);
        inputValue(loginField, getUserName());
        inputValue(passwordField, getUserPassword());
        loginBTN.click();
        return new CategoryPage(driver);
    }

    private void inputValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void waitElement(WebElement elementToWait) throws InterruptedException {
        elementToWait.wait(30000);
    }

}

