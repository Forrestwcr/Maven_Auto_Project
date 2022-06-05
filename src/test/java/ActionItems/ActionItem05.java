package ActionItems;

import ReusableLibrary.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ActionItem05 {
    public static void main(String[] args) {
        //Create ArrayLists for all criteria, each list containing 3 values
        //ArrayList for first name
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Bob");
        firstName.add("John");
        firstName.add("Alexis");

        //ArrayList for last name
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Thomas");
        lastName.add("Baker");
        lastName.add("Stoner");

        //ArrayList for birth month
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("June");
        birthMonth.add("January");
        birthMonth.add("December");

        //ArrayList for birthday
        ArrayList<String> birthday = new ArrayList<>();
        birthday.add("19");
        birthday.add("15");
        birthday.add("11");

        //ArrayList for birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1990");
        birthYear.add("1988");
        birthYear.add("2000");

        //ArrayList for zipcode
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("10014");
        zipcode.add("93504");
        zipcode.add("05454");

        //ArrayList for member ID
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("115452343");
        memberID.add("321432423");
        memberID.add("123546542");

        //use reusable method to open chrome
        WebDriver driver = Reusable_Actions.setDriver();
        //create a loop for automation the process
        for(int i = 0; i< firstName.size();i++) {
            //navigate to uhc website
            driver.navigate().to("https://www.uhc.com/");

            //verify the title matches using reusable method
            Reusable_Actions.verifyTitle(driver, "Health insurance plans", "Health Insurance");

            //click on find a doctor
            Reusable_Actions.clickAction(driver,"//*[text()='Find a doctor']","Find A Doctor");

            //click on sign in
            Reusable_Actions.clickAction(driver,"//*[text()='Sign in']","Sign In");

            //click on medicare plan?
            Reusable_Actions.clickAction(driver,"//*[text()='Medicare plan?']","Medicare Plan");

            //switch to the new tab
            Reusable_Actions.switchToTabByIndex(driver,1);

            //click on register now
            Reusable_Actions.clickAction(driver,"//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']","Register Now");

            //enter first name
            Reusable_Actions.sendKeysAction(driver,"//*[@id='firstName']",firstName.get(i),"First Name");

            //enter last name
            Reusable_Actions.sendKeysAction(driver,"//*[@id='lastName']",lastName.get(i),"Last Name");

            //select month of birth
            Reusable_Actions.selectTextAction(driver,"//*[@name='dob_month']",birthMonth.get(i),"Birth Month");

            //enter birthday
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_day']",birthday.get(i),"Birthday");

            //enter birth year
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_year']",birthYear.get(i),"Birth Year");

            //enter zipcode
            Reusable_Actions.sendKeysAction(driver,"//*[@id='zipCode']",zipcode.get(i),"Zipcode");

            //enter memberID
            Reusable_Actions.sendKeysAction(driver,"//*[@id='memberId']",memberID.get(i),"Member ID");

            //click on submit button
            Reusable_Actions.clickAction(driver,"//*[@id='submitBtn']","Submit Button");

            //get text from the error code
            String errorCode = Reusable_Actions.getTextAction(driver,"//*[@id='plainText_error']","Error Code");

            //print out all the info for this iteration
            System.out.println("My name is " + firstName.get(i) + " " + lastName.get(i));
            System.out.println("My birthday is " + birthMonth.get(i) + " " + birthday.get(i) + ", " + birthYear.get(i));
            System.out.println("My Zipcode is " + zipcode.get(i));
            System.out.println("My Member Id is " + memberID.get(i));
            System.out.println("My error message is " + errorCode);

            //close driver
            driver.close();

            //switch back to default tab
            Reusable_Actions.switchToTabByIndex(driver,0);
        }//end of for loop
        //exit driver
        driver.quit();
    }//end of main
}//end of class
