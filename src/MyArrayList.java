import java.util.Iterator;


public class MyArrayList<T> implements MyList<T> {
    private Object[] elements; // internal array to store elements
    private int size; // current number of elements in the list

    public MyArrayList() {
        elements = new Object[10]; // initial capacity is 10
        size = 0;
    }

    // Resizes the internal array when it's full
    private void resize() {
        Object[] newElements = new Object[elements.length * 2]; // double the size
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i]; // copy old elements
        }
        elements = newElements;
    }

    // Adds an element to the end of the list
    @Override
    public void add(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
    }

    // Replaces the element at the given index
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = item;
    }

    // Inserts an element at a specific index
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == elements.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1]; // shift elements right
        }
        elements[index] = item;
        size++;
    }

    // Inserts element at the beginning
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Inserts element at the end
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Retrieves element at given index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    // Retrieves the first element
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return get(0);
    }

    // Retrieves the last element
    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return get(size - 1);
    }


    // Removes element at a given index
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1]; // shift elements left
        }
        elements[size - 1] = null;
        size--;
    }

    // Removes first element
    @Override
    public void removeFirst() {
        remove(0);
    }

    // Removes last element
    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        elements[size - 1] = null;
        size--;
    }

    // Sorts elements using bubble sort
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T elem1 = (T) elements[j];
                T elem2 = (T) elements[j + 1];
                Comparable comp1 = (Comparable) elem1;
                if (comp1.compareTo(elem2) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    // Returns index of first occurrence of an object
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null) {
                if (elements[i] == null) return i;
            } else {
                if (object.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    // Returns index of last occurrence of an object
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (object == null) {
                if (elements[i] == null) return i;
            } else {
                if (object.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    // Checks if object exists in list
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Returns array copy of elements
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = elements[i];
        }
        return arr;
    }

    // Clears the list
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Returns number of elements
    @Override
    public int size() {
        return size;
    }

    // Provides an iterator for the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return (T) elements[current++];
            }
        };
    }
}