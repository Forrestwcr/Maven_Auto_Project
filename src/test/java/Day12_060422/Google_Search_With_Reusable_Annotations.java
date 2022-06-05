package Day12_060422;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class Google_Search_With_Reusable_Annotations extends Reusable_Annotations_Class {
    @Test(priority = 1)
    public void SearchForAKeyword(){
        driver.navigate().to("https://google.com");
        //enter a keyword on search field
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //submit the go button
        ReusableClasses.Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
    }//end of test 1


    /*
    dependsOnMethods used when  following @Test is dependent on previous @Test method. Then If the first test fails,
    the dependent test will get skipped
     */

    @Test(dependsOnMethods = "SearchForAKeyword")
    public void CaptureSearchNumber() {
        //capture search result
        String result = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id='result-stats']",logger, "Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2
}
