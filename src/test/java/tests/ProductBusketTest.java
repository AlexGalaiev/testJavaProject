package tests;

import constans.ApplicationConstans;
import constans.ApplicationLocalization;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageobjects.BusketPage;
import org.pageobjects.BusketPageStepTwoPage;
import org.pageobjects.CategoryPage;
import org.pageobjects.ChechoutPage;

public class ProductBusketTest extends BaseTest {

    private String removeBtn = "Remove";

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
    public void checkoutCardPageTest() {
        CategoryPage productCard = new CategoryPage(driver);
        productCard.clickAddBtn();
        //check remove btn
        Assert.assertTrue(productCard.clickRemoveBtn.isDisplayed());
        Assert.assertArrayEquals(
                removeBtn.toCharArray(),
                productCard.clickRemoveBtn.getText().toCharArray());
        //go to checkout page
        ChechoutPage chechoutPage = new ChechoutPage(driver);
        chechoutPage.clickHeaderBusketBtn();
        //check correct texts on checkout page
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_NAME.toCharArray(),
                chechoutPage.itemName.getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_PRICE.toCharArray(),
                chechoutPage.itemPrice.getText().toCharArray());
        //check remove btn
        new ChechoutPage(driver)
                .clickRemoveProductFromCheckout();
    }

    @Test
    public void checoutFirstStepPageTest(){
        new CategoryPage(driver)
                .clickAddBtn()
                .clickHeaderBusketIcon()
                .clickCheckoutBtn();
        new BusketPage(driver)
                .inputUserCreds()
                .clickCheckoutBtn();
        BusketPageStepTwoPage deliveryInfo = new BusketPageStepTwoPage(driver);
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_NAME.toCharArray(),
                deliveryInfo.getItemTitle().getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_PRICE.toCharArray(),
                deliveryInfo.getItemPrice().getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.SHIPPING_ADDRESS.toCharArray(),
                deliveryInfo.shippingAdress.getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.TOTAL_PRICE.toCharArray(),
                deliveryInfo.priceTotal.getText().toCharArray());
    }

}
