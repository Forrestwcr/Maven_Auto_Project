package Day3_04302022;

public class Multiple_Conditional_Statement {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        //if a+b is less than c then print result
        //if a+b is greater than c then print result
        //finally print a+b is equal to c
        if(a+b <c){
            System.out.println("a & b is less than c");
        } else if (a+b > c) {
            System.out.println("a & b is greater than c");
        }else {
            System.out.println("a & b is equal to c");
        }//end of conditions
    }//end of main
}//end of class
