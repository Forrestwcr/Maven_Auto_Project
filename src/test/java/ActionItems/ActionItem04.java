package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem04 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("30309");
        zipCodes.add("30045");
        zipCodes.add("21740");
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
        for (int i = 0; i < zipCodes.size();i++){
            //navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(3000);
            try{
                //use inspect element to click on Attend drop down menu
                driver.findElements(By.xpath("//li[contains(@class,'Menu_list-item__PqEi2')]")).get(4).click();
            } catch (Exception e){
                //print out if unsuccessful
                System.out.println("Could not click Attend button" + e);
            }//end of try and catch
            Thread.sleep(1000);
            try{
                //click on unlimited workshops button
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
            } catch(Exception e){
                //print out failure statement
                System.out.println("Could not click unlimited workshops button " + e);
            }//end of try and catch
            Thread.sleep(1000);
            try {
                //click on the studio button
                driver.findElements(By.xpath("//*[contains(@class,'buttonText-3DCCO')]")).get(1).click();
            } catch(Exception e){
                //print failure statement
                System.out.println("Could not click on Studio button " + e);
            }//end of try catch
            Thread.sleep(1000);
            try{
                //click on the search bar and enter zipcodes from array list
                WebElement zCode = driver.findElement(By.xpath("//*[@id='location-search']"));
                zCode.click();
                zCode.clear();
                zCode.sendKeys(zipCodes.get(i));
                zCode.submit();
            } catch(Exception e){
                //print out failure statement
                System.out.println("Could not click on search field and enter zipcodes " + e);
            }//end of try catch
            Thread.sleep(2000);
            try{
                //create if statements based on the current iteration of i
                if (i==0){
                    driver.findElements(By.xpath("//*[contains(@class,'linkUnderline-1_h4g')]")).get(1).click();
                } else if (i==1) {
                    driver.findElements(By.xpath("//*[contains(@class,'linkUnderline-1_h4g')]")).get(2).click();
                } else if (i==2) {
                    driver.findElements(By.xpath("//*[contains(@class,'linkUnderline-1_h4g')]")).get(3).click();
                }//end of else if
            } catch(Exception e){
                //print out failure statement
                System.out.println("Could not click on any links " + e);
            }//end of try catch
            Thread.sleep(1000);
            try{
                //store and print the address of the location
                String address = driver.findElement(By.xpath("//div[@class='address-2PZwW']")).getText();
                System.out.println("The address of this location is " + address);
            } catch(Exception e){
                //print out failure statement
                System.out.println("Could not find the address " + e);
            }//end of try catch
            try{
                //declare variable for javascript executor
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //scroll down page
                jse.executeScript("scroll(0,400)");
                //find xpath for data table
                String table = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                //print text from variable
                System.out.println("The schedule for this location is " + table);
            } catch(Exception e){
                System.out.println("Could not find the data table for class times " + e);
            }//end of try catch
        }//end of for statement
        //close driver
        driver.quit();
    }//end of main
}//end of class
