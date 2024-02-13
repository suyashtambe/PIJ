import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new ArrayStack<>();

        System.out.println("Enter elements to push onto the stack (enter 'done' to stop):");
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            try {
                int element = Integer.parseInt(input);
                stack.push(element);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done' to stop.");
            }
        }

        System.out.println("Stack elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
