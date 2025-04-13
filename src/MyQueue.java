public class MyQueue<T> {

    private MyLinkedList<T> list; // Internal storage for queue elements

    // Constructor: Initializes the queue with a new MyLinkedList
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Adds (enqueues) an element to the end of the queue
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Removes and returns the first element from the queue
    public T dequeue() {
        if (list.size() == 0) {
            throw new RuntimeException("Queue is empty"); // Prevent underflow
        }
        T item = list.getFirst();  // Get the first (oldest) element
        list.removeFirst();        // Remove it
        return item;
    }

    // Returns the first element in the queue without removing it
    public T peek() {
        if (list.size() == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return list.getFirst();
    }