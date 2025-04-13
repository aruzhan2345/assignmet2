public class MyMinHeap<T extends Comparable<T>> {

    private MyArrayList<T> heap; // Underlying array based storage for the heap

    // Constructor: Initializes an empty heap
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Inserts a new element into the heap and maintains the heap property
    public void insert(T item) {
        heap.add(item);  // Add to the end
        bubbleUp(heap.size() - 1); // Move it up to the correct position
    }

    // Returns the minimum element (root of the heap) without removing it
    public T getMin() {
        if (heap.size() == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0); // Root element is always the minimum
    }

    // Removes and returns the minimum element (root), then rebalances the heap
    public T removeMin() {
        if (heap.size() == 0) {
            throw new RuntimeException("Heap is empty");
        }
        T min = heap.get(0); // Save the root
        T lastItem = heap.get(heap.size() - 1); // Take the last element
        heap.set(0, lastItem); // Move last item to root
        heap.remove(heap.size() - 1); // Remove duplicate
        bubbleDown(0); // Rebalance the heap
        return min;
    }

    // Returns number of elements in the heap
    public int size() {
        return heap.size();
    }

    // Checks if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Alternative method name (same logic)
    public boolean empty() {
        return isEmpty();
    }