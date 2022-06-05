package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem031 {
    public static void main(String[] args) throws InterruptedException {
        //create an array list of hobbies
        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("Guitar");
        hobby.add("Football");
        hobby.add("Tennis");
        hobby.add("Soccer");
        hobby.add("Hockey");
        //set up chrome driver using web driver manager
        WebDriverManager.chromedriver().setup();
        //set up options for chrome driver
        ChromeOptions options = new ChromeOptions();
        //set condition to maximize browser
        options.addArguments("start-maximized");
        //set condition to headless
        options.addArguments("headless");
        //define web driver i am going to use
        WebDriver driver = new ChromeDriver(options);

        //create a for loop for the web driver to cycle through the different values in sport
        for(int i = 0; i < hobby.size(); i++) {
            //navigate to bing
            driver.navigate().to("https://bing.com");
            //have the program sleep for 2 seconds
            Thread.sleep(500);
            //inspect and locate name or ID on the search bar and have it type in the sport
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(hobby.get(i));
            //have the driver hit the search button
            driver.findElement(By.xpath("//*[@class='search icon tooltip']")).click();
            //have program sleep
            Thread.sleep(500);
            //capture search result
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //get rid of spaces-This isn't necessary, could also just remove the space from the print statement
            String noSpaces = searchResult.replace(" ", "");
            //print out the result using substring
            System.out.println("My hobby is " + hobby.get(i) + " and I found " + noSpaces.substring(0,10) + " " + noSpaces.substring(10) + " for it.");
        }//end of for loop
        //quit driver
        driver.quit();
    }//end of main
}//end of class
