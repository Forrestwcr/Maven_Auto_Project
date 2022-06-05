package Day3_04302022;

public class if_else_condition {
    public static void main(String[] args) {
        //declare two integer variables
        int a =5;
        int b =3;
        //print when a is less than b or print when it's greater/equal to b
        if(a < b){
            System.out.println("a is less than b");
        }else{
            System.out.println("a is greater or equal to b" + " and a is " + a);
        }//end of if/else

        //declare additional variables
        int d = 4;
        int e = 5;
        int f = 6;
        //or operator with if statement
        // || is used for or operator -- one of the conditions need to be true
        // && is used for and operator -- both of the conditions need to be true
        if(d < e || f < e){
            System.out.println("d is less than e or f is less than e");
        }else {
            System.out.println("Condition is not true");
        }
    }//end of main
}//end of class
