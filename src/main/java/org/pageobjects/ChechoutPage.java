package org.pageobjects;


import constans.ApplicationCommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChechoutPage extends BasePage{
    public ChechoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="remove-sauce-labs-backpack")
    private WebElement removeBtn;
    @FindBy(id="continue-shopping")
    private WebElement continueShoppingBtn;
    @FindBy(id="checkout")
    private WebElement checkoutBtn;


    public ChechoutPage clickHeaderBusketBtn(){
        findElementById(ApplicationCommonElements.HEADER_BUSKET).click();
        waitElement(findElementById(ApplicationCommonElements.CHECKOUT_PAGE));
        return new ChechoutPage(driver);
    }

    public ChechoutPage clickRemoveProductFromCheckout() {
        removeBtn.click();
        waitElementDissapear(findElementById(ApplicationCommonElements.ITEM_NAME));
        return new ChechoutPage(driver);
    }

    public ChechoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new ChechoutPage(driver);
    }

}

