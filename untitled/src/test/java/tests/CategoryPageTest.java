package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.pageobjects.BasePage;
import org.pageobjects.LoginPage;

public class CategoryPageTest extends BasePage {
    static WebDriver driver;

    public CategoryPageTest(WebDriver driver) {
        super(driver);
    }

    @BeforeClass
    public static void beforeClass() {
        new BasePage(driver).initDriver();
    }

    @AfterClass
    public static void afterClass() {
        new BasePage(driver).closeDriver();
    }

    @Test
    public void categoryPageTest() {





    }
}
