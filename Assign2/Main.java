package Assign2;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        double n1 = userInput.getDoubleInput("Enter First Number:");
        double n2 = userInput.getDoubleInput("Enter Second Number:");
        char choice = userInput.getCharInput("Choose Operation: +, -, /, *");
        userInput.closeScanner();

        if(choice=='+'){
            System.err.println(Calculator.add(n1,n2));
        }
        else if(choice=='-'){
            System.err.println(Calculator.subtract(n1,  n2));
        }
        else if(choice=='*'){
            System.err.println(Calculator.multiply(n1, n2));
        }
        else if(choice=='/'){
            System.out.println(Calculator.divide(n1, n2));
        }
        else{
            System.out.println("Invalid Operation");
        }
    }
}
