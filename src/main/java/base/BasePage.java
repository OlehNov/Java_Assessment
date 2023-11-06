package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    public static WebDriver driver;
    public WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitAndClick(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void waitAndSendKeys(WebElement locator, String value){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(value);
    }
    public void selectAndDeleteTextInInput(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.CONTROL + "a");
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.BACK_SPACE);
    }
}
