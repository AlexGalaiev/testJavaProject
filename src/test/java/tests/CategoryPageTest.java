package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.pageobjects.BasePage;
import org.pageobjects.CategoryPage;
import org.pageobjects.LoginPage;


public class CategoryPageTest extends BasePage {
    static WebDriver driver;

    public CategoryPageTest(WebDriver driver) {
        super(driver);
    }

    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.successLoginToPlatform();
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void categoryPageTest() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.checkElementOnPage();
    }
}
