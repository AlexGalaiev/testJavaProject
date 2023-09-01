package org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "inventory_container")
    private WebElement productsPage;
    @FindBy(className = "app_logo")
    private WebElement shopName;
    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenuCategory;
    @FindBy(id = "item_4_img_link")
    public WebElement itemPicture;
    @FindBy(xpath = "//*[@id='item_4_img_link']/../..")
    private WebElement itemCard;
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    public WebElement itemAddToBasketBTN;
    @FindBy(id="item_4_title_link")
    public WebElement itemTitle;
    @FindBy(xpath = "*//div[@class='inventory_item_price'][1]")
    public WebElement itemPrice;
    @FindBy(id="remove-sauce-labs-backpack")
    public WebElement clickRemoveBtn;
    @FindBy(id="shopping_cart_container")
    public WebElement headerBusketIcon;
        private String removeBtn = "Remove";

    public CategoryPage waitElementOnPage() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        return new CategoryPage(driver);
    }

    public CategoryPage clickAddBtn(){
        itemAddToBasketBTN.click();
        return new CategoryPage(driver);
    }

}

