package org.pageobjects;

import constans.ApplicationCommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusketPageStepTwoPage extends BasePage{
    public BusketPageStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "*//div[@class='summary_info_label'][2]")
    public WebElement shippingInfo;
    @FindBy(xpath = "*//div[@class='summary_value_label'][2]")
    public WebElement shippingAdress;
    @FindBy(className = "summary_total_label")
    public WebElement priceTotal;
    @FindBy(id = "finish")
    private WebElement finishBtn;

    public ThankyouPage clickFinishBtn() {
        finishBtn.click();
        waitElement(findElementById(ApplicationCommonElements.THANK_YOU_PAGE));
        return new ThankyouPage(driver);
    }
}
