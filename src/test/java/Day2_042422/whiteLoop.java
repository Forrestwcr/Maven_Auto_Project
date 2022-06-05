package Day2_042422;

public class whiteLoop {
    public static void main(String[] args) {
        //iterate through zipcode and its street number using linear array and while loop
        String[] zipCode = new String[]{"11218","11219","11232","10001"};
        int[] houseNumber = new int[]{111,222,333,444};

        //initialize your starting point before calling while loop
        int i = 0;
        //define the end point in while loop
        while (i < houseNumber.length){
            System.out.println("My zipcode is " + zipCode[i] + " house number " + houseNumber[i]);

            //incrementing
            i = i+1;
        }//end of loop
    }//end of main
}//end of class
