package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    public static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver","C:/Users/chris/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public BasePage(WebDriver driver){
        BasePage.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement (String locator){
        Find(locator).click();
    }

    public void write (String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }


}