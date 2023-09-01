package org.base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pageobjects.BasePage;
import org.pageobjects.LoginPage;
import org.testng.annotations.BeforeSuite;
import webdriver.WebDriverFactory;
import webdriver.WebDriverType;

public class BaseTest{
    public static WebDriver driver = WebDriverFactory.getDriver(WebDriverType.FIREFOX_DRIVER);

    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        driver = WebDriverFactory.getDriver(WebDriverType.FIREFOX_DRIVER);
    }

    @BeforeSuite()
    public void afterSuit() {
        driver.quit();
    }

    public static void goToUrl(String URL) {
        driver.get(URL);
    }

    public static void successLoginUserToPlatform() {
        new LoginPage(driver)
                .loginUserToPlatform();
    }

}
