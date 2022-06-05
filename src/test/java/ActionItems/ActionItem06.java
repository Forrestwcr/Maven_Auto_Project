package ActionItems;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ActionItem06 {

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

    /*test case 1: Navigate to prudential and go to the personal life insurance portion of the website
    verify the title and exit the pop up box after verifying its presence*/
    @Test(priority = 1)
    public void WebsiteStarter(){
        logger= reports.startTest("Capture the page title");
        //go to prudential
        driver.navigate().to("https://www.prudential.com");
        //click on learn more button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@sr-only-copy='about investments']",logger,"Click learn more");
        //verify the title of webpage
        ReusableClasses.Reusable_Actions_Loggers.verifyTitle(driver,"Life Insurance:",logger,"Verify Title");
        //verify the presence of a pop up
        WebDriverWait wait = new WebDriverWait(driver,2);
        Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
        System.out.println("Is Pop up box present? " + PopupCheck);
        //exit the popup
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        reports.endTest(logger);

    }//end of test 1
    //Click on select a policy button and capture the amount of different policies available
    @Test(priority = 2)
    public void StartPolicy(){
        logger= reports.startTest("Select a policy");
        //locate element for select a policy and scroll to it using jsexecutor
        WebElement shareButton = driver.findElement(By.xpath("//*[contains(text(),'Select a Policy')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        //click on select a policy
        ReusableClasses.Reusable_Actions_Loggers.clickByIndexAction(driver,"//*[contains(text(),'Select a Policy')]",1,logger,"Select a policy");
        try{
            WebDriverWait wait = new WebDriverWait(driver,2);
            Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
            System.out.println("Is Pop up box present? " + PopupCheck);
            //exit the popup
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        }catch(Exception e){
            System.out.println("No pop up in the way ");
        }
        //scroll to the table of policies
        WebElement shareButton2 = driver.findElement(By.xpath("//th[@scope='row']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton2);
        WebDriverWait wait = new WebDriverWait(driver,10);
        //find a element that is being used to identify all the different policies
        List<WebElement> policyCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//th[@scope='row']/a")));
        //print the amount of policies
        System.out.println("I have " + policyCount.size() + " policies available.");
        //use for loop to print out the different policy names
        for(int i = 0; i<policyCount.size();i++){
            policyCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//th[@scope='row']/a")));
            String policyName = policyCount.get(i).getText();
            System.out.println("My index " + i + " policy is " + policyName);
        }//end of for loop
    }//end of test 2

    //Navigate the get a term quote and complete the survey then record the results
    @Test(priority = 3)
    public void TermQuote(){
        logger= reports.startTest("Get a term quote");
        //go to prudential
        driver.navigate().to("https://www.prudential.com/personal/life-insurance");
        //click on get a term quote button
        try{
            WebDriverWait wait = new WebDriverWait(driver,2);
            Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
            System.out.println("Is Pop up box present? " + PopupCheck);
            //exit the popup
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        }catch(Exception e){
            System.out.println("No pop up in the way ");
        }
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[contains(text(),'Get a Term Quote')]",logger,"Get a Term Quote");
        //switch to the new tab
        ReusableClasses.Reusable_Actions_Loggers.switchToTabByIndex(driver,1);
        //click on no button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//input[@aria-label='No']",logger,"'No' button");
        //click on male button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='gender-male']",logger,"Male button");
        //click on no smoking button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='tobacco-false']",logger,"Non smoking button");
        //click on not married button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='married-false']",logger,"Not married button");
        //click on no children button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='has-children-false']",logger,"No children button");
        //enter month of birth from drop down menu
        ReusableClasses.Reusable_Actions_Loggers.selectTextAction(driver,"//*[@aria-label='Month']","June",logger,"Birth Month");
        //enter day of birth
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='Day']","15",logger,"Birthday");
        //enter year of birth
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='Year']","1990",logger,"Birth Year");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@aria-label='Continue']",logger,"Continue button");
        //click 4th option
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@aria-label='Replace an existing policy']",logger,"Check Box");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //Select height from drop down menu
        ReusableClasses.Reusable_Actions_Loggers.selectTextAction(driver,"//*[@aria-label='Height']","6'0''",logger,"Height Dropdown");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //enter weight
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='Weight']","160",logger,"Weight bar");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //click no to taking prescription meds
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@id='taking_prescription_medication_false']",logger,"Prescription Meds");
        //click the no medical conditions checkbox
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@id='assur-has_no_medical_conditions']",logger,"Medical Conditions");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //click currently employed button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Currently Employed']",logger,"Currently Employed Button");
        //select 50-100k from dropdown menu
        ReusableClasses.Reusable_Actions_Loggers.selectTextAction(driver,"//*[@aria-label='Coverage Range']","50K-100K",logger,"Coverage Dropdown");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //type in zipcode
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='Zip Code']","21740",logger,"Zipcode bar");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //type in first name and last name
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='first name']","Bill",logger,"First Name");
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='last name']","Nye",logger,"Last Name");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //type in random email
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='email']","blahblahblah400@yahoo.com",logger,"Email");
        //click continue
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='Continue']",logger,"Continue button");
        //type in random phone number
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@aria-label='phone']","2407777778",logger,"Phone number");
        //click view my results
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@data-testid='ViewMyResults']",logger,"ViewMyResults button");
        //capture the text for coverage amount
        String coverageDate = ReusableClasses.Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='text-center mt-20 value-label']",logger,"Coverage Start Date");
        String coverageAmount = ReusableClasses.Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='text-center value-secondary prudential-coverage-amount']",logger,"Coverage amount");
        //print out the results
        System.out.println("My " + coverageDate + " is " + coverageAmount);
        driver.close();
        ReusableClasses.Reusable_Actions_Loggers.switchToTabByIndex(driver,0);



    }//end of test 3
    //Navigate to life insurance 101 count the amount of drop down menus on the page and list off the names of each one
    @Test(priority = 4)
    public void LifeInsurance101(){
        logger= reports.startTest("Life Insurance 101");
        //go to prudential
        driver.navigate().to("https://www.prudential.com/personal/life-insurance");
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
            System.out.println("Is Pop up box present? " + PopupCheck);
            //exit the popup
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        }catch(Exception e){
            System.out.println("No pop up in the way ");
        }
        //click on life insurance 101 button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[contains(text(),'Life Insurance 101')]",logger,"Life Insurance 101");
        //locate element for drop downs and scroll to it using jsexecutor
        WebElement dropDowns = driver.findElement(By.xpath("//li[@class='panel panel-accordion-default']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",dropDowns);
        List<WebElement> dropCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='panel panel-accordion-default']")));
        System.out.println("I have " + dropCount.size() + " drop down menus.");
        for(int i = 0; i< dropCount.size();i++){
            dropCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='panel panel-accordion-default']")));
            String dropName = dropCount.get(i).getText();
            System.out.println("My index " + i + " title is " + dropName);
        }//end of for loop

    }//end of test 4
    /*I want to find a financial advisor closest to me based on zipcode*/
    @Test(priority = 5)
    public void FinancialAdvisor(){
        logger= reports.startTest("Financial Advisor");
        //go to prudential
        driver.navigate().to("https://www.prudential.com/personal/life-insurance");
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
            System.out.println("Is Pop up box present? " + PopupCheck);
            //exit the popup
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        }catch(Exception e){
            System.out.println("No pop up in the way ");
        }
        //click on life insurance 101 button
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("21740");
        zipCodes.add("43062");
        zipCodes.add("02801");
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[contains(text(),' Investments ')]",logger,"Investments");
        try{
            Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
            System.out.println("Is Pop up box present? " + PopupCheck);
            //exit the popup
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        }catch(Exception e){
            System.out.println("No pop up in the way ");
        }
        ReusableClasses.Reusable_Actions_Loggers.clickByIndexAction(driver,"//*[@class='btn btn-primary']",1,logger,"Find a local advisor");
        ReusableClasses.Reusable_Actions_Loggers.switchToTabByIndex(driver,1);
        for(int i = 0; i< zipCodes.size();i++) {
            ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='inputTermLocation']",zipCodes.get(i), logger, "Zip code");
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@id='btn-ffp']",logger,"Start Search");
            String results = ReusableClasses.Reusable_Actions_Loggers.getTextAction(driver,"//*[@data-qa='display results']",logger,"Results");
            String closestResult = ReusableClasses.Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='fpcard1']",logger,"Closest Result");
            System.out.println("For Zip Code " + zipCodes.get(i) + " I found " + results);
            System.out.println("The closest one is " + closestResult);
        }//end of for loop
        driver.close();
        ReusableClasses.Reusable_Actions_Loggers.switchToTabByIndex(driver,0);
    }//end of test 5
    /*I want to navigate to the life insurance calculator and fill out the form and hit the calculate button
    and then record the result*/
    @Test(priority = 6)
    public void InsuranceCalculator() throws InterruptedException {
        logger= reports.startTest("Insurance Calculator");
        //go to prudential
        driver.navigate().to("https://www.prudential.com/personal/life-insurance");
        //click buy life insurance quotes online button
        try{
            WebDriverWait wait = new WebDriverWait(driver,2);
            Boolean PopupCheck = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mm_popup']"))).isDisplayed();
            System.out.println("Is Pop up box present? " + PopupCheck);
            //exit the popup
            ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@class='mm_close']",logger,"Exit Pop up");
        }catch(Exception e){
            System.out.println("No pop up in the way ");
        }
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[text()=' Buy Life Insurance Quotes Online']",logger,"Quotes Online");
        //scroll down the page a bit
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,-400)");
        //click use this calculator button
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Use this calculator']",logger,"Use Calculator");
        //type in information into calculator
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='Age']","45",logger,"Age Bar");
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@id='GenderM']",logger,"Gender Button");
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@id='SpouseN']",logger,"Spouse Button");
        ReusableClasses.Reusable_Actions_Loggers.selectTextAction(driver,"//*[@id='NumChildren']","7+",logger,"Number of Children");
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='YCAge']","3",logger,"Youngest Child");
        ReusableClasses.Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='Salary']","100000",logger,"Salary");
        //click calculate
        ReusableClasses.Reusable_Actions_Loggers.clickAction(driver,"//*[@type='submit']",logger,"Submit Button");
        String results = Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='col-lg-12']",logger,"Insurance Needs");
        System.out.println(results);
    }//end of test 6
    @AfterSuite
    public void quitSession() {
        driver.quit();
        reports.flush();
    }
}//end of class
