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