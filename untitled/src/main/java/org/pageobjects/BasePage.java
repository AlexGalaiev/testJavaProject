package org.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    String userName = "standard_user";
    String userPassword = "secret_sauce";
    String URL = "https://www.saucedemo.com/";


    @FindBy(id="user-name")
    private WebElement loginField;

    @FindBy(id="password")
    private WebElement passwordField;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver initDriver(URL) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        return driver;
    }

    public WebDriver closeDriver() {
        driver.quit();
        return null;
    }

    private CategoryPage successLoginToPlatform(userName, userPassword) {
        inputValue(loginField, userName);
        inputValue(passwordField, userPassword);
        return new CategoryPage(driver);
    }

    private void inputValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

}
