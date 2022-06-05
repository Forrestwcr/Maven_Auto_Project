package ActionItems;

import java.util.ArrayList;

public class ActionItem {
    public static void main(String[] args) {
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Germany");
        country.add("India");
        country.add("Canada");
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(11111);
        countryCode.add(22222);
        countryCode.add(33333);
        countryCode.add(44444);

        for (int i = 0; i < country.size(); i++){
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of for loop
    }//end of main
}//end of class
