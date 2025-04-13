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


    // Restores heap order by moving an element up until it's in the right place
    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Calculate parent index
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
            if (current.compareTo(parent) < 0) {
                swap(index, parentIndex); // Swap with parent if smaller
                index = parentIndex;      // Move up
            } else {
                break;
            }
        }
    }

    // Restores heap order by moving an element down until it's in the right place
    private void bubbleDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;  // Left child index
            int rightChild = 2 * index + 2; // Right child index
            int smallest = index;           // Start by assuming current is smallest

            // Compare with left child
            if (leftChild < size && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }

            // Compare with right child
            if (rightChild < size && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            // If smallest is not the current node, swap and continue
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break; // Heap is in order
            }
        }
    }

    // Swaps two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
