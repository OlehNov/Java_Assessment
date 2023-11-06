package tests;

import base.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    public WebDriver driver = DriverManager.setDriver("chrome");
    public String SWAGLABS_URL = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        driver.get(SWAGLABS_URL);
        driver.manage().window().maximize();
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
