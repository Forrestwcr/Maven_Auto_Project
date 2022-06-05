package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetTitle_Example {
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

        //navigate to google
        driver.navigate().to("https://www.google.com");
        //capture the title of the page and compare it with your expected title 'GOOGLE'
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("GOOGLE")){
            System.out.println("My title matches");
        } else{
            System.out.println("Title doesn't match, actual title is " + actualTitle);
        }
    }//end of main
}//end of class
