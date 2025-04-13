public class MyStack<T> {

    private MyArrayList<T> list; // Internal storage for stack elements

    //Constructor: Initializes the stack with a new MyArrayList
    public MyStack() {
        list = new MyArrayList<>();
    }

    //Adds (pushes) an element onto the top of the stack
    public void push(T item) {
        list.add(item);
    }

    //Removes and returns the top element from the stack
    public T pop() {
        if (list.size() == 0) {
            throw new RuntimeException("Stack is empty"); // Prevents underflow
        }
        T item = list.get(list.size() - 1); // Get last element
        list.remove(list.size() - 1); // Remove it
        return item;
    }

    //Returns the top element of the stack without removing it
    public T peek() {
        if (list.size() == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    // Returns the number of elements in the stack
    public int size() {
        return list.size();
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean empty() {
        return isEmpty();
    }
}

