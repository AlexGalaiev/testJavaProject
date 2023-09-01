package org.pageobjects;

import constans.ApplicationConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id="user-name")
    private WebElement loginName;
    @FindBy(id = "password")
    private WebElement loginPassword;
    @FindBy(id = "login-button")
    private WebElement loginBTN;
    @FindBy(id = "inventory_container")
    private WebElement productsPage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CategoryPage loginUserToPlatform() {
        loginName.sendKeys(ApplicationConstans.LOGIN_NAME);
        loginPassword.sendKeys(ApplicationConstans.LOGIN_PASSWORD);
        loginBTN.click();
        return new CategoryPage(driver);
    }

    public CategoryPage waitProductsPage() {
        productsPage.isDisplayed();
        return new CategoryPage(driver);
    }

}
