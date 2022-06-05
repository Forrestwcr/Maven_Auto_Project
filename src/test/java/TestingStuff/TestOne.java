package TestingStuff;

public class TestOne {
    public static void main(String[] args) {

        int count = 0;
        String incomprehensible = "incomprehensible";

        for (int i=0; i < incomprehensible.length();i++ ){
            char ch = incomprehensible.charAt(i);

            if (ch == 'a'){
                count++;
            }
        }
        System.out.println("number of a is " + count);
        if(count>0) count=0;
        for (int i=0; i < incomprehensible.length();i++ ){
            char ch = incomprehensible.charAt(i);

            if (ch == 'e'){
                count++;
            }
        }
        System.out.println("number of e is " + count);

        if(count>0) count=0;
        for (int i=0; i < incomprehensible.length();i++ ){
            char ch = incomprehensible.charAt(i);

            if (ch == 'i'){
                count++;
            }
        }
        System.out.println("number of i is " + count);

        if(count>0) count=0;
        for (int i=0; i < incomprehensible.length();i++ ){
            char ch = incomprehensible.charAt(i);

            if (ch == 'o'){
                count++;
            }
        }
        System.out.println("number of o is " + count);
        if(count>0) count=0;
        for (int i=0; i < incomprehensible.length();i++ ){
            char ch = incomprehensible.charAt(i);

            if (ch == 'u'){
                count++;
            }
        }
        System.out.println("number of u is " + count);
    }
}
