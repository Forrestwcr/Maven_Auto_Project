package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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

public class Reusable_Actions_Loggers {

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
    public static void mouseHover(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions((driver));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hovered on element "+ elementName);
        }catch(Exception e){
            System.out.println("Unable to hover element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Failed to hover on element "+ elementName);
        }
    }//end of mouseHover method

    //create a mouse click method
    public static void clickAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Could not click on element "+ elementName);
        }catch(Exception e){
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Could not click on element "+ elementName);
        }
    }//end of clickAction method

    //make a submit action
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        }catch(Exception e){
            System.out.println("Unable to click element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
        }
    }//end of submitAction method

    //make a sendkeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions((driver));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element "+ elementName);
        }catch(Exception e){
            System.out.println("Unable to type into element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter value on element "+ elementName + " "+e);
        }
    }//end of Sendkeys method

    //make a getText method
    public static String getTextAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully capture text on element "+ elementName);
        }catch(Exception e){
            System.out.println("Unable to get text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element "+ elementName + " "+e);
        }
        return result;
    }//end of gettext method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on index number "+ elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Could not click on index number "+ elementName);
        }
    }//end of clickByIndexAction

    //create a SelectTextAction method
    public static void selectTextAction(WebDriver driver,String xpath, String userValue, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
            logger.log(LogStatus.PASS,"Successfully clicked on drop down element "+ elementName);
        }catch(Exception e){
            System.out.println("Unable to select element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Could not click on drop down element "+ elementName);
        }
    }//end of SelectTextAction method

    //create a SwitchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver,int userValue){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(userValue));
    }//end of SwitchToTabByIndex method

    //create a verifyTitle method
    public static void verifyTitle(WebDriver driver,String actualTitle, ExtentTest logger,String elementName) {
        String title = driver.getTitle();
        if (title.contains(actualTitle)) {
            System.out.println("My title matches. My title is " + title);
            logger.log(LogStatus.PASS,"Successfully verified title "+ elementName);
        } else {
            System.out.println("Title doesn't match, actual title is " + title + " " + elementName);
            logger.log(LogStatus.FAIL,"Could not verify title "+ elementName);
        }
    }//end of verifyTitle method
    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String ElementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                logger.log(LogStatus.PASS,"Element is selected as expected");
            } else {
                logger.log(LogStatus.FAIL,"Element is not selected");
            }
        } catch (Exception e) {
        }
    }//end of method

}//end of class
