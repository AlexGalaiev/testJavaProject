package org.pageobjects;

import constans.ApplicationCommonElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankyouPage extends BasePage{
    public ThankyouPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "pony_express")
    public WebElement thankYouPicture;
    @FindBy(className = "complete-header")
    public WebElement thankYouText;
    @FindBy(id = "back-to-products")
    private WebElement backToHometn;

    public CategoryPage clickBackToMainPageBtn(){
        backToHometn.click();
        waitElement(findElementById(ApplicationCommonElements.CATEGORY_PAGE));
        return new CategoryPage(driver);
    }

}
