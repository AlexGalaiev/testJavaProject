package tests;

import constans.ApplicationCommonElements;
import constans.ApplicationConstans;
import constans.ApplicationLocalization;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageobjects.CategoryPage;

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
        categoryPage.waitCheckoutPage();
        //check item photo
        Assert.assertTrue(categoryPage.elementIsDisplayed(categoryPage.findElementById(ApplicationCommonElements.ITEM_NAME)));
        //check item name
        Assert.assertArrayEquals(
                "Name is correct",
                ApplicationLocalization.PRODUCT_NAME.toCharArray(),
                categoryPage.getElementArrayText(categoryPage.findElementById(ApplicationCommonElements.ITEM_NAME)));
        //check item price
        Assert.assertArrayEquals(
                ApplicationLocalization.PRODUCT_PRICE.toCharArray(),
                categoryPage.getElementArrayText(categoryPage.findElementByClass(ApplicationCommonElements.ITEM_PRICE)));

    }

}
