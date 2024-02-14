//Main.java
package Assign3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserInput user = new UserInput();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student Details");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    user.addStudent();
                    break;
                case 2:
                    System.out.println("Student Details:");
                    user.display();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}