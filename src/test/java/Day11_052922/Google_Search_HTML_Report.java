package Day11_052922;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_HTML_Report {

    //declare the local driver outside so it that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite annotation

    //test case 1: navigate to google and enter keyword on search field
    @Test(priority = 1)
    public void SearchForAKeyword(){
        logger= reports.startTest("Search for a keyword");
        driver.navigate().to("https://google.com");
        //enter a keyword on search field
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        ReusableClasses.Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
        reports.endTest(logger);
    }//end of test 1


    /*
    dependsOnMethods used when  following @Test is dependent on previous @Test method. Then If the first test fails,
    the dependent test will get skipped
     */

    @Test(dependsOnMethods = "SearchForAKeyword")
    public void CaptureSearchNumber() {
        logger= reports.startTest("Capture the search number");
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id='result-stats']",logger, "Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        reports.endTest(logger);
    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }
}
