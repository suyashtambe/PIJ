// Student.java
package Assign3;

public class Student {
    private int prn;
    private String name;
    private String dob;
    private float marks;

    Student(int prn, String name, String dob, float marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public int getPrn() {
        return prn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public float getMarks() {
        return marks;
    }
}
