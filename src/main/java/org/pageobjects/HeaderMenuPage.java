package org.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuPage extends BasePage{
    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "app_logo")
    private WebElement shopName;
    @FindBy(id="react-burger-menu-btn")
    private WebElement burgerMenuCategory;
}
