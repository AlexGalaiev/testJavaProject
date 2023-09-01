package org.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChechoutPage extends BasePage{
    public ChechoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="cart_contents_container")
    WebElement checkoutPageContainer;
    @FindBy(id="shopping_cart_container")
    public WebElement headerBusketIcon;
    @FindBy(id="item_4_title_link")
    public WebElement itemName;
    @FindBy(className = "inventory_item_price")
    public WebElement itemPrice;
    @FindBy(id="remove-sauce-labs-backpack")
    public WebElement removeBtn;
    @FindBy(id="continue-shopping")
    public WebElement continueShoppingBtn;
    @FindBy(className = "inventory_container")
    public WebElement productCartsPage;

    public ChechoutPage clickHeaderBusketBtn(){
        headerBusketIcon.click();
        waitElement(checkoutPageContainer);
        return new ChechoutPage(driver);
    }

    public ChechoutPage removeProductFromCheckout() {
        clickBtn(removeBtn);

    }

}

