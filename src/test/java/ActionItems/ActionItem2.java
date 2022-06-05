package ActionItems;

public class ActionItem2 {
    public static void main(String[] args) {
        String[] region = new String[]{"Maryland","New York","Florida","Texas"};
        int[] areaCode = new int[]{240,917,305,210};
        int i = 0;
        while(i < areaCode.length){
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);

            i = i+1;
        }//end of while loop
    }//end of main
}//end of class