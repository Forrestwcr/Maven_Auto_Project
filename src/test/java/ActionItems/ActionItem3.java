package ActionItems;

import java.util.ArrayList;

public class ActionItem3 {
    public static void main(String[] args) {
        //create a variable
        int grade = 99;
        //input different results based on number range
        if(grade>=90&&grade<=100){
            System.out.println("Grade is A");
        } else if (grade>=80&&grade<90) {
            System.out.println("Grade is B");
        } else if (grade>=70&&grade<80) {
            System.out.println("Grade is C");
        } else if (grade>=60&&grade<70){
            System.out.println("Grade is D");
        } else if (grade<60){
            System.out.println("Grade is F");
        }//end of if

        //create an array list for cities
        ArrayList<String> cities = new ArrayList<>();
        //add cities to the list
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten");
        //create a for loop looking for certain cities
        for(int i = 0; i <cities.size(); i++ ){
            if(cities.get(i)=="Brooklyn"){
                System.out.println("My city is " + cities.get(i));
            } else if (cities.get(i)=="Manhattan") {
                System.out.println("My city is " + cities.get(i));
            }//end of else if
        }//end of for loop
    }//end of main
}//end of class
