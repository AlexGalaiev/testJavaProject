package org.pageobjects;

import constans.ApplicationCommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    public WebElement itemAddToBasketBTN;
    @FindBy(xpath = "*//div[@class='inventory_item_price'][1]")
    public WebElement itemPrice;
    @FindBy(id="remove-sauce-labs-backpack")
    public WebElement clickRemoveBtn;
    private String removeBtn = "Remove";

    public CategoryPage waitCheckoutPage() {
        return new CategoryPage(driver);
    }

    public CategoryPage clickAddBtn(){
        itemAddToBasketBTN.click();
        return new CategoryPage(driver);
    }

    public ChechoutPage clickHeaderBusketIcon() {
        findElementById(ApplicationCommonElements.HEADER_BUSKET).click();
        return new ChechoutPage(driver);
    }
}

