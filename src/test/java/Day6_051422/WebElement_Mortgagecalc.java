package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_Mortgagecalc {
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
        //click, clear, and enter new value on the home value field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeValue.click();
        homeValue.clear();
        homeValue.sendKeys("450000");

        //click on the % ratio button
        driver.findElement(By.xpath("//*[@value='percent']")).click();

        //click, clear, and enter new data on down payment field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");

    }//end of main
}//end of class
