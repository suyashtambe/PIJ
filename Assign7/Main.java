package Assign7;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        try {
            int a = 1;
            System.out.println("Value of a is: " + a);
            int b = 1;
            System.out.println("Value of b is: " + b);
            int c = a / b; // This line will throw ArithmeticException
            System.out.println("Value of c is: " + c); // This line will not be executed
            throw new Customexception();
        } catch (Customexception e) {
            System.out.println("ArithmeticException caught: " + e);
        }finally { // tp create the logs
        	System.out.println("Run the program again");
        }
    }
}


