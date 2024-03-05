package Assign 7;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        try {
            int a = 1;
            System.out.println("VAlue of a is:" + a);
            int b = 1;
            System.out.println("VAlue of b is:" + b);
            int c = a / b;
            System.out.println("VAlue of c is:" + c);

            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Run program Again.");
        }
    }

}
