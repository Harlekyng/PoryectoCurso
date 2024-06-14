package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    public static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver","C:/Users/chris/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public BasePage(WebDriver driver){
        BasePage.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
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

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }


    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){String cellINeed = locator + "/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }

/*
Esto es un assertion que podria hacerse pero no es la mejro practica hacerlo directo sino conseguir un texto y comparar
por esto creamos el textFromElements
    public void validateText(String locator, String textToValidate){
        Assert.assertEquals(textToValidate, Find(locator).getText());
    }
*/
    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public void dismissAlert(){
        try { //Permite validar un error por la alerta
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    //Listas
    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElement(String locator){
        return driver.findElements(By.xpath(locator));
    }

}