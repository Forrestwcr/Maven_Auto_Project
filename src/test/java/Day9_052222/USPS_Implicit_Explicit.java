package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class USPS_Implicit_Explicit {
    public static void main(String[] args) {
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

        //set your global implicit wait
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.navigate().to("https://www.usps.com");

        //call mouse actions
        Actions actions =new Actions(driver);

        //hover to quick tools
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        actions.moveToElement(quickTools).perform();

        //click on track a package
        driver.findElement(By.xpath("//*[text()='Track a Package']")).click();

        //click and then type on track a package field
        WebElement packageField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        packageField.click();
        packageField.sendKeys("1122334455");


    }//end of main
}//end of class
