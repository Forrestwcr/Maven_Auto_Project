package Day2_042422;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        //create an array list for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Pakistan");//0
        countries.add("Bangladesh");//1
        countries.add("India");//2
        countries.add("Canada");//3
        countries.add("USA");//4

        ArrayList<Integer> countryN= new ArrayList<>();
        countryN.add(1);
        countryN.add(2);
        countryN.add(3);
        countryN.add(4);
        countryN.add(5);
        //I want to print out the 4th value from the list
        System.out.println("My country is " + countries.get(4) + " and it is the " + countryN.get(4) +"th country in my list");
    }//end of main
}//end of class
