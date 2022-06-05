package Day3_04302022;

import ReusableLibrary.ReusableMethods;

public class TestingMethods {

    public static void main(String[] args) {
        //call the add two number method and execute it
        ReusableMethods.addTwoNumbers(20,30);

        //call the return method and store its variable to perform something else
        int finalResult = ReusableMethods.subtractTwoNumbers(20,10);
        System.out.println("new result is " + (finalResult+10));
    }//end of main
}//end of class
