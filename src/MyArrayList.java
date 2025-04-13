import java.util.Iterator;


public class MyArrayList<T> implements MyList<T> {
    private Object[] elements; // internal array to store elements
    private int size; // current number of elements in the list

    public MyArrayList() {
        elements = new Object[10]; // initial capacity is 10
        size = 0;
    }