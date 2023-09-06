package tests;

import constans.ApplicationConstans;
import org.base.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.pageobjects.HeaderFooterMenu;
import org.pageobjects.SoshialNetworks;

public class HeaderMenuTest extends BaseTest {

    @BeforeClass
    public static void BeforeClass() {
        goToUrl(ApplicationConstans.APP_URL);
        successLoginUserToPlatform();
    }
    @AfterClass
    public static void AfteClass(){
        driver.quit();
    }
    @Test
    public void AboutPageLinkTest() {
        new HeaderFooterMenu(driver)
                .openBurgerMenu()
                .switchToExternalLink();
        Assert.assertArrayEquals(
                driver.getCurrentUrl().toCharArray(),
                ApplicationConstans.EXTERNAL_SITE_LINK.toCharArray()
        );
    }
    @Test
    public void LogOutLinkTest() {
        new HeaderFooterMenu(driver)
                .openBurgerMenu()
                .makeLogoutFromBurgerMenu();
        Assert.assertArrayEquals(
                driver.getCurrentUrl().toCharArray(),
                ApplicationConstans.APP_URL.toCharArray()
        );
    }
    @Test
    public void BrandShopNameTest() {
        new HeaderFooterMenu(driver)
                .clickBusketLink();
        Assert.assertTrue(new HeaderFooterMenu(driver).shopName.isDisplayed());
    }
    @Test
    public void TwitterTest(){
        new HeaderFooterMenu(driver)
                .sckrollPagetoSoshialIcon(SoshialNetworks.TWITTER)
                .clickOnSochialNetwork(SoshialNetworks.TWITTER);
        Assert.assertEquals("correct switch to Twitter",
                ApplicationConstans.TWITTER_SWITCH,
                driver.getCurrentUrl());
    }

}
