package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage extends BasePage{
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
       super(driver);
    }
    @FindBy(id="inventory_container")
    private WebElement productsPage;
    @FindBy(className = "app_logo")
    private WebElement appLogo;
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;
    @FindBy(css = ".inventory_item")
    private WebElement itemCart;
    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenu;

    public CategoryPage checkElementOnPage(){
        productsPage.isDisplayed();
        appLogo.isDisplayed();
        shoppingCartLink.isDisplayed();
        burgerMenu.isDisplayed();
        return this;
    }








}
