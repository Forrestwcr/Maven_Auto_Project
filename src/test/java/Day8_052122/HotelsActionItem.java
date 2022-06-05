package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class HotelsActionItem {
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
        //create array list for destinations
        ArrayList<String> destination = new ArrayList<>();
        destination.add("Miami");
        destination.add("Los Angeles");
        destination.add("Austin");
        //create array list for check in dates
        ArrayList<String> checkIn = new ArrayList<>();
        checkIn.add("Jun 6, 2022");
        checkIn.add("Jun 8, 2022");
        checkIn.add("Jun 10, 2022");
        //create array list for check out dates
        ArrayList<String> checkOut = new ArrayList<>();
        checkOut.add("Jun 13, 2022");
        checkOut.add("Jun 15, 2022");
        checkOut.add("Jun 17, 2022");
        //create array list for adults
        ArrayList<String> adults = new ArrayList<>();
        adults.add("2");
        adults.add("3");
        adults.add("4");
        for (int i = 0; i < 1; i++) {
            //navigate to hotels
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(3000);
            try{
                //click on location bar and type in location
                driver.findElement(By.xpath("//*[@aria-label = 'Going to']")).click();
                WebElement location = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
                location.click();
                location.clear();
                location.sendKeys(destination.get(i));
                Thread.sleep(1000);
                //choose the first location in the drop down menu
                driver.findElements(By.xpath("//li[contains(@class,'uitk-typeahead-result-item has-subtext')]")).get(0).click();
                Thread.sleep(3000);
            } catch(Exception e){
                System.out.println("Could not locate the location bar " + e);
            }//end of try catch


            try{
                //click on check in drop down and put in date
                driver.findElement(By.xpath("//*[@id='d1-btn']")).click();
                Thread.sleep(1000);
                //choose check in date
                driver.findElement(By.xpath("//*[@aria-label='"+checkIn.get(i)+"']")).click();
                Thread.sleep(1000);
                //choose check out date
                driver.findElement(By.xpath("//*[@aria-label='"+checkOut.get(i)+"']")).click();
                //click apply dates button
                driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']")).click();
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println("Could not pick vacation start date " + e);
            }//end of try catch


            try{
                //click on the travelers drop down
                driver.findElement(By.xpath("//*[@data-testid='travelers-field-trigger']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@aria-label='Increase adults in room 1']")).click();
            } catch(Exception e){
                System.out.println("Could not click on the amount of travelers dropdown " + e);
            }//end of try catch


            try{
                //click on the submit button
                driver.findElement(By.xpath("//*[@data-testid='submit-button']")).submit();
                Thread.sleep(5000);
            } catch (Exception e){
                System.out.println("Could not click on the submit button " + e);
            }//end of try catch


            try{
                //pick out the property based on for loops iteration
                if(i==0){
                    driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(0).click();
                }else if (i==1){
                    driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(1).click();
                } else if (i==2) {
                    driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(2).click();
                }//end of else if
            }catch (Exception e){
                System.out.println("Could not click on the links " + e);
            } //end of try catch

            Thread.sleep(2000);
            //capture tabs into an array list and switch to the new tab
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            try{
                //capture the name of the resort
                Thread.sleep(5000);
                String resortName = driver.findElement(By.xpath("//*[@class='uitk-heading-3']")).getText();
                //print out the resort name
                System.out.println("The hotel name for " + destination.get(i) + " is " + resortName);
            } catch(Exception e){
                System.out.println("Could not find the resort name " + e);
            }//end of try catch

            //declare variable for javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll down page
            jse.executeScript("scroll(0,1600)");
            Thread.sleep(1000);

            try{
                //capture the price of the first room and print out
                String roomPrice = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println("The price is " + roomPrice + " per night.");
            }catch(Exception e){
                System.out.println("Could not find the room price " + e);
            }//end of try catch

            try{
                //click on reserve button
                driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(1).click();
            } catch(Exception e){
                System.out.println("Could not click on reserve button " + e);
            }
        }

    }//end of main
}//end of class
