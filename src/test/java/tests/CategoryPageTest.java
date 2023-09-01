package tests;

import constans.ApplicationConstans;
import constans.ApplicationLocalization;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageobjects.CategoryPage;
import org.pageobjects.LoginPage;


public class CategoryPageTest extends BaseTest {
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
        Assert.assertTrue(categoryPage.elementIsDisplayed(categoryPage.itemPicture));
        //check item name
        Assert.assertArrayEquals(
                "Name is correct",
                ApplicationLocalization.PRODUCT_NAME.toCharArray(),
                categoryPage.getElementArrayText(categoryPage.itemTitle));
        //check item price
        Assert.assertArrayEquals(
                ApplicationLocalization.PRODUCT_PRICE.toCharArray(),
                categoryPage.getElementArrayText(categoryPage.itemPrice));
    }

}
