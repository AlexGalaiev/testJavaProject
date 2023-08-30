package org.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.pageobjects.BasePage;
import org.pageobjects.LoginPage;
import org.testng.annotations.AfterSuite;
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserToPlatform()
                .waitElementOnPage();
    }

}
