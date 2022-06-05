package ReusableLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {

    //set a static timeout variable so it can cover all explicit waits for all methods
    public static int timeout = 12;

    //reusable function for webdriver as a return method
    public static WebDriver setDriver(){
        //set up your chrome driver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions((driver));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        }catch(Exception e){
            System.out.println("Unable to hover element " + elementName + " " + e);
        }
    }//end of mouseHover method

    //create a mouse click method
    public static void clickAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        }catch(Exception e){
            System.out.println("Unable to click element " + elementName + " " + e);
        }
    }//end of clickAction method

    //make a submit action
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        }catch(Exception e){
            System.out.println("Unable to click element " + elementName + " " + e);
        }
    }//end of submitAction method

    //make a sendkeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions((driver));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
        }catch(Exception e){
            System.out.println("Unable to type into element " + elementName + " " + e);
        }
    }//end of Sendkeys method

    //make a getText method
    public static String getTextAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        }catch(Exception e){
            System.out.println("Unable to get text on element " + elementName + " " + e);
        }
        return result;
    }//end of gettext method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction

    //create a SelectTextAction method
    public static void selectTextAction(WebDriver driver,String xpath, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
        }catch(Exception e){
            System.out.println("Unable to select element " + elementName + " " + e);
        }
    }//end of SelectTextAction method

    //create a SwitchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver,int userValue){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(userValue));
    }//end of SwitchToTabByIndex method

    //create a verifyTitle method
    public static void verifyTitle(WebDriver driver,String actualTitle, String elementName) {
        String title = driver.getTitle();
        if (title.contains(actualTitle)) {
            System.out.println("My title matches");
        } else {
            System.out.println("Title doesn't match, actual title is " + title + " " + elementName);
        }
    }//end of verifyTitle method



}//end of class
