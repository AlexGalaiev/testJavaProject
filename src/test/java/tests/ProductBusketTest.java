package tests;

import constans.ApplicationCommonElements;
import constans.ApplicationConstans;
import constans.ApplicationLocalization;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageobjects.*;

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

        ChechoutPage chechoutPage = new ChechoutPage(driver);
        chechoutPage.clickHeaderBusketBtn();

        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_NAME.toCharArray(),
                chechoutPage.findElementById(ApplicationCommonElements.ITEM_NAME).getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_PRICE.toCharArray(),
                chechoutPage.findElementById(ApplicationCommonElements.ITEM_PRICE).getText().toCharArray());

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
                .clickContinueBtn();
        BusketPageStepTwoPage deliveryInfo = new BusketPageStepTwoPage(driver);
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_NAME.toCharArray(),
                deliveryInfo.findElementById(ApplicationCommonElements.ITEM_NAME).getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.PRODUCT_PRICE.toCharArray(),
                deliveryInfo.findElementByClass(ApplicationCommonElements.ITEM_PRICE).getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.SHIPPING_ADDRESS.toCharArray(),
                deliveryInfo.shippingAdress.getText().toCharArray());
        Assert.assertArrayEquals(ApplicationLocalization.TOTAL_PRICE.toCharArray(),
                deliveryInfo.priceTotal.getText().toCharArray());
    }

    @Test
    public void thankYouPageTest() {
        new CategoryPage(driver)
                .clickAddBtn()
                .clickHeaderBusketIcon()
                .clickCheckoutBtn();
        new BusketPage(driver)
                .inputUserCreds()
                .clickContinueBtn()
                .clickFinishBtn();
        ThankyouPage tYPage = new ThankyouPage(driver);
        tYPage.findElementById(ApplicationCommonElements.THANK_YOU_PAGE);
        Assert.assertTrue(tYPage.thankYouPicture.isDisplayed());
        Assert.assertArrayEquals(
                ApplicationLocalization.THANKYOUPAGE_THANKS_ORDER_TEXT.toCharArray(),
                tYPage.thankYouText.getText().toCharArray());
        tYPage.clickBackToMainPageBtn();
        Assert.assertTrue(tYPage.findElementById(ApplicationCommonElements.CATEGORY_PAGE).isDisplayed());


    }

}
