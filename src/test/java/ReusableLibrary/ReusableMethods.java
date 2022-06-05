package ReusableLibrary;

public class ReusableMethods {

    //create a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){
        System.out.println("the result of the two numbers is " + (num1+num2));
    }//end of void
    //create a return integer method to subtract two numbers
    public static int subtractTwoNumbers(int a,int b){
        int result = a-b;
        System.out.println("The result of the two numbers for subtraction is " + result);
        return result;

    }

}//end of class
