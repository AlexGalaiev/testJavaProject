package org.pageobjects;

import constans.ApplicationLocalization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusketPage extends BasePage{

    public BusketPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "checkout_info_container")
    private WebElement infoCheckoutPage;
    @FindBy(id = "first-name")
    public WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zipCode;
    @FindBy(className = "error-message-container")
    private WebElement errorValidationMSG;
    @FindBy(id = "continue")
    private WebElement continueBtn;

    public BusketPage inputUserCreds() {
        firstName.sendKeys(ApplicationLocalization.TEST_VALUE);
        lastName.sendKeys(ApplicationLocalization.TEST_VALUE);
        zipCode.sendKeys(ApplicationLocalization.TEST_VALUE);
        return new BusketPage(driver);
    }
    public BusketPage clickCheckoutBtn(){
        continueBtn.click();
        return new BusketPage(driver);
    }



}