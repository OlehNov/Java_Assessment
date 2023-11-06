package swaglabs_pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Products extends BasePage {
    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement appLogo;

    public Products(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String readAppLogo(){
        return wait.until(ExpectedConditions.visibilityOf(appLogo)).getText();
    }
}
