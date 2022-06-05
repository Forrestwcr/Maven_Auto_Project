package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {

        //set up your chrome driver with web driver manager
        WebDriverManager.chromedriver().setup();
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver();

        //go to google home
        driver.navigate().to("https://www.google.com");
        //maximize the driver
        driver.manage().window().maximize();
        //locate element for search and type keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        //sunmit on google search engine
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //capture the google search and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Result is " + searchResult);
        //extract out the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        //to replace ( and ) from the seconds that's coming from arrayList[3] use .replace command to replace it with ""(no space)
        String replaceParanth = arrayResult[3].replace("(","").replace(")","");
        System.out.println("My search number is " + arrayResult[1] + " and the seconds it took is " + replaceParanth);
        //quit the driver
        driver.quit();
    }//end of main
}//end of java class
