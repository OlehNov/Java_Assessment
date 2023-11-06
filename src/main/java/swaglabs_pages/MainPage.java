package swaglabs_pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userNameInput;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void loginButtonClick(){
        waitAndClick(loginButton);
        System.out.println("Click Login_Button");
    }

    public MainPage inputUserName(String userName){
        waitAndSendKeys(userNameInput,userName);
        System.out.println("Input User_Name");
        return this;
    }
    public MainPage inputUserPassword(String userPassword){
        waitAndSendKeys(passwordInput,userPassword);
        System.out.println("Input Password");
        return this;
    }
    public MainPage cleanUserInput(){
        selectAndDeleteTextInInput(userNameInput);
        System.out.println("Clean User_Input");
        return this;
    }

    public MainPage cleanPasswordInput(){
        selectAndDeleteTextInInput(passwordInput);
        System.out.println("Clean Password");
        return this;
    }
    public String readErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }
}
