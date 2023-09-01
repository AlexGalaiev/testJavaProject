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
    private WebElement headerBusketIcon;
    @FindBy(id="item_4_title_link")
    public WebElement itemName;
    @FindBy(className = "inventory_item_price")
    public WebElement itemPrice;
    @FindBy(id="remove-sauce-labs-backpack")
    private WebElement removeBtn;
    @FindBy(id="continue-shopping")
    private WebElement continueShoppingBtn;
    @FindBy(className = "inventory_container")
    private WebElement productCartsPage;
    @FindBy(id="checkout")
    private WebElement checkoutBtn;


    public ChechoutPage waitCheckoutPage() {
        waitElement(checkoutPageContainer);
        return new ChechoutPage(driver);
    }

    public ChechoutPage clickHeaderBusketBtn(){
        headerBusketIcon.click();
        waitElement(checkoutPageContainer);
        return new ChechoutPage(driver);
    }

    public ChechoutPage clickRemoveProductFromCheckout() {
        removeBtn.click();
        waitElementDissapear(itemName);
        return new ChechoutPage(driver);
    }

    public ChechoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new ChechoutPage(driver);
    }

}

