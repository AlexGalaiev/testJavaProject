package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageobjects.LoginPage;

public class LoginTest {
    static WebDriver driver;
    String userName = "standard_user";
    String userPassword = "secret_sauce";

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
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);



    }
}
