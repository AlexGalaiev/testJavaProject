package org.pageobjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage{
    private WebDriver driver;
    public CategoryPage(WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "inventory_container")
    private WebElement productsPage;
    @FindBy(className = "app_logo")
    private WebElement brandLogo;
    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenu;
    @FindBy(id = "item_4_img_link")
    private WebElement item;
    @FindBy(xpath = "//*[@id='item_4_img_link']/../..")
    private WebElement itemCard;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement itemAddToBasketBTN;

    public CategoryPage waitElementOnPage() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        return new CategoryPage(driver);
    }

    public boolean checkElementsDownloaded() {
        return item.isDisplayed();
    }

}

