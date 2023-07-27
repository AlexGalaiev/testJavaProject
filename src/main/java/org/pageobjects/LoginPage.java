package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    private WebDriver driver;
    private String userName = "standard_user";
    private String userPassword = "secret_sauce";
    @FindBy(id="user-name")
    public WebElement loginName;
    @FindBy(id = "password")
    private WebElement loginPassword;
    @FindBy(id = "login-button")
    private WebElement loginBTN;
    @FindBy(id = "inventory_container")
    private WebElement productsPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CategoryPage loginUserToPlatform() {
        loginName.sendKeys(userName);
        loginPassword.sendKeys(userPassword);
        loginBTN.click();
        return new CategoryPage(driver);
    }

    public CategoryPage waitProductsPage() {
        productsPage.isDisplayed();
        return new CategoryPage(driver);
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
