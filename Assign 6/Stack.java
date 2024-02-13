public interface Stack<T> {
    // Method to push an element onto the stack
    void push(T element);
    
    // Method to pop an element from the stack
    T pop();
    
    // Method to peek at the top element of the stack without removing it
    T peek();
    
    // Method to check if the stack is empty
    boolean isEmpty();
    
    // Method to get the size of the stack
    int size();
}
