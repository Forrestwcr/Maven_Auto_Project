package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {
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

        //navigate to mortgage calculator sight
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        //declare javascript executor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to pixel 400 on mortgage calc website
//        jse.executeScript("scroll(0,400)");
        //declare a webelement that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        //scroll into share this calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        //click on the share this calculation button
        shareButton.click();
        Thread.sleep(2000);
        //scroll back up
        jse.executeScript("scroll(0,-400)");

        //quit chrome driver
        driver.quit();

    }//end off main
}//end of class
