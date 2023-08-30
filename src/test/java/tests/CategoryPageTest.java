package tests;

import constans.ApplicationConstans;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageobjects.CategoryPage;
import org.pageobjects.LoginPage;


public class CategoryPageTest extends BaseTest {
    private static String ITEM_NAME = "Sauce Labs Backpack";
    private static String ITEM_PRICE = "$29.99";

    @BeforeClass
    public static void beforeClass() {
        goToUrl(ApplicationConstans.APP_URL);
        successLoginUserToPlatform();
    }
    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void productCardPageParametersTest() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.waitElementOnPage();
        //check item photo
        Assert.assertTrue(categoryPage.checkElementsDownloaded(categoryPage.getItemPicture()));
        //check item name
        Assert.assertArrayEquals("Name is correct", ITEM_NAME.toCharArray(), categoryPage.getElementArrayText(categoryPage.itemTitle));
        //check item price
        Assert.assertArrayEquals(ITEM_PRICE.toCharArray(), categoryPage.getElementArrayText(categoryPage.itemPrice));
    }

}
