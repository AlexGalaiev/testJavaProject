package org.pageobjects;

import constans.ApplicationCommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class HeaderFooterMenu extends BasePage {
    public HeaderFooterMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "app_logo")
    public WebElement shopName;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuCategoryIcon;
    @FindBy(className = "bm-menu")
    private WebElement burgerMenu;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutMenuLink;
    public HeaderFooterMenu switchToExternalLink() {
        aboutLink.click();
        return new HeaderFooterMenu(driver);
    }

    public HeaderFooterMenu openBurgerMenu() {
        burgerMenuCategoryIcon.click();
        waitElement(burgerMenu);
        return new HeaderFooterMenu(driver);
    }

    public HeaderFooterMenu makeLogoutFromBurgerMenu() {
        logoutMenuLink.click();
        return new HeaderFooterMenu(driver);
    }

    public HeaderFooterMenu clickBusketLink() {
        findElementById(ApplicationCommonElements.HEADER_BUSKET).click();
        return new HeaderFooterMenu(driver);
    }
    private WebElement clickSoshials(SoshialNetworks soshials) {
        return findElementByClass("social_" + soshials.name().toLowerCase());
    }

    public HeaderFooterMenu clickOnSochialNetwork(SoshialNetworks nameOfNetwork) {
        clickSoshials(nameOfNetwork).click();
        return new HeaderFooterMenu(driver);
    }
    public HeaderFooterMenu sckrollPagetoSoshialIcon(SoshialNetworks soshials){
        scrollScrinToElement(clickSoshials(soshials));
        return new HeaderFooterMenu(driver);
    }
    public HeaderFooterMenu switchToWindow() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        sleep(3000);
        return new HeaderFooterMenu(driver);
    }

}
