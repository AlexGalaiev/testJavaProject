package tests;

import constans.ApplicationConstans;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageobjects.LoginPage;


public class CategoryPageTest extends BaseTest {
//    private static String URL = "https://www.saucedemo.com/";

    @BeforeClass
    public static void beforeClass() {
        goToUrl(ApplicationConstans.APP_URL);
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    // Проверка что юзер залогинился и увидел элементы на странице
//    @Test
//    public void categoryPageTest() {
//            Assert.assertTrue(new LoginPage(driver)
//                    .loginUserToPlatform()
//                    .waitElementOnPage()
//                    .checkElementsDownloaded());
//    }
// проверка товара на странице
    @Test
    public void productCardPageParametersTest() {

    }

}
