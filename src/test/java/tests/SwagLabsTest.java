package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import swaglabs_pages.MainPage;
import swaglabs_pages.Products;

public class SwagLabsTest extends BaseTest{
    public String randomName = RandomStringUtils.randomAlphabetic(6);
    public String randomPassword = RandomStringUtils.randomAlphabetic(8);

    public  static final String ERROR_USER_MESSAGE = "Epic sadface: Username is required";
    public  static final String ERROR_PASSWORD_MESSAGE = "Epic sadface: Password is required";
    public  static final String APP_LOGO = "Swag Labs";
    public  static final String USER_NAME = "standard_user";
    public  static final String PASSWORD = "secret_sauce";

    @Test
    public void testUCFirst(){
        MainPage mainPage = new MainPage(driver);
        mainPage
                .inputUserName(randomName)
                .inputUserPassword(randomPassword)
                .cleanUserInput()
                .loginButtonClick();
        Assert.assertEquals("Unexpected result:", ERROR_USER_MESSAGE, mainPage.readErrorMessage());
    }
    @Test
    public void testUCSecond(){
        MainPage mainPage = new MainPage(driver);
        mainPage
                .inputUserName(randomName)
                .inputUserPassword(randomPassword)
                .cleanPasswordInput()
                .loginButtonClick();
        Assert.assertEquals("Unexpected result:", ERROR_PASSWORD_MESSAGE, mainPage.readErrorMessage());
    }
    @Test
    public void testUCThird(){
        MainPage mainPage = new MainPage(driver);
        Products products = new Products(driver);
        mainPage
                .inputUserName(USER_NAME)
                .inputUserPassword(PASSWORD)
                .loginButtonClick();
        Assert.assertEquals("Unexpected result:", APP_LOGO, products.readAppLogo());
    }
}
