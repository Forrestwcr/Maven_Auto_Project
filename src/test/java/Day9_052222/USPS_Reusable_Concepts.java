package Day9_052222;

import ReusableLibrary.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reusable_Concepts {
    public static void main(String[] args) throws InterruptedException {

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover to send tab
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab");

        //click on calculate a price
        Reusable_Actions.clickAction(driver,"//li[@class='tool-calc']","Calculate Price");

        //print out header text info
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='header-usps row']","Header Info");
        System.out.println("My header info is " + result);

        //Enter zipcode
        Reusable_Actions.sendKeysAction(driver,"//*[@id='Origin']","11218","Zipcode");

    }//end of main
}//end of class
