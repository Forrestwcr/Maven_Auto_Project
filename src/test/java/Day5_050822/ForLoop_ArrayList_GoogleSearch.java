package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ForLoop_ArrayList_GoogleSearch {
    public static void main(String[] args) {

        //capture search number and print for following cities using arraylist and for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        //set up your chrome driver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //setting your driver as headless(running in background)
       // options.addArguments("headless");

        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);

        for(int i = 0; i < cities.size(); i++) {
            //go to google home
            driver.navigate().to("https://www.google.com");
            //locate element for search and type keyword 'cars'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(i));
            //submit on google search engine
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            //capture the google search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //System.out.println("Result is " + searchResult);
            //extract out the number and print the search number only
            String[] arrayResult = searchResult.split(" ");
            //to replace ( and ) from the seconds that's coming from arrayList[3] use .replace command to replace it with ""(no space)
            String replaceParanth = arrayResult[3].replace("(", "").replace(")", "");
            System.out.println("My search number for city " + cities.get(i) + " is " + arrayResult[1] + " and the seconds it took is " + replaceParanth);
            //quit the driver
        }
        driver.quit();

    }//end of main
}//end of class
