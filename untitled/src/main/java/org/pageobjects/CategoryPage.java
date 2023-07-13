package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
    }
    @FindBy(id="inventory_container")
    private WebElement productsPage;

    public boolean isProductPageVisible() {
        return productsPage.isDisplayed();
    }




}
