//UserInput.java
package Assign3;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    ArrayList<Student> student = new ArrayList<Student>();
    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of student " + (i + 1) + ": ");
            String input = sc.nextLine();
            String[] details = input.split(" ");
            if (details.length >= 4) {
                int prn = Integer.parseInt(details[0]);
                String name = details[1];
                String dob = details[2];
                float marks = Float.parseFloat(details[3]);
    
                Student s = new Student(prn, name, dob, marks);
                student.add(s);
            } else {
                System.out.println("Invalid input format. Please enter details in the format: PRN Name DOB Marks");
                i--;
            }
        }
    }
    

    public void display(){
        for(int i = 0; i < student.size(); i++){
            System.out.println(student.get(i).getPrn() + " " + student.get(i).getName() + " " + student.get(i).getDob() + " " + student.get(i).getMarks());
        }
    }
}
