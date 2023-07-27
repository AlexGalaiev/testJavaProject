package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageobjects.BasePage;
import org.pageobjects.CategoryPage;
import org.pageobjects.LoginPage;


public class CategoryPageTest {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void categoryPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUserToPlatform();
    }
}
