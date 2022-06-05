package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
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

        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        //declare and define mouse actions
        Actions mouseActions = new Actions(driver);
        //hover to Send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //click on tracking using mouse actions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();

        Thread.sleep(3000);

        //type a invalid tracking number using sendkeys with mouse actions
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("111234243242").perform();

    }//end of main
}//end of class
