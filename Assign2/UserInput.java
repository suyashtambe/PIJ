package Assign2;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public double getDoubleInput(String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }

    public char getCharInput(String message) {
        System.out.println(message);
        return scanner.next().charAt(0);
    }

    public void closeScanner() {
        scanner.close();
    }
}
