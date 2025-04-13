import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    // Node class to represent each element in the list
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element) {
            this.element = element;
        }
    }

    private MyNode head; // Points to the first node
    private MyNode tail; // Points to the last node
    private int size;    // Number of elements in the list

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adds element to the end
    @Override
    public void add(T item) {
        addLast(item);
    }

    // Replaces the value at a specific index
    @Override
    public void set(int index, T item) {
        MyNode node = getNodeAt(index);
        node.element = item;
    }

    // Inserts an element at a specific position
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode newNode = new MyNode(item);
            MyNode current = getNodeAt(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    // Adds an element at the beginning
    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Adds an element at the end
    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Gets element by index
    @Override
    public T get(int index) {
        return getNodeAt(index).element;
    }

    // Gets the first element
    @Override
    public T getFirst() {
        if (size == 0) throw new IndexOutOfBoundsException("List is empty");
        return head.element;
    }

    // Gets the last element
    @Override
    public T getLast() {
        if (size == 0) throw new IndexOutOfBoundsException("List is empty");
        return tail.element;
    }

    // Removes an element by index
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode nodeToRemove = getNodeAt(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            nodeToRemove.next = null;
            nodeToRemove.prev = null;
            size--;
        }
    }

    // Removes the first element
    @Override
    public void removeFirst() {
        if (size == 0) throw new IndexOutOfBoundsException("List is empty");
        if (size == 1) {
            head = tail = null;
        } else {
            MyNode temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
    }

    // Removes the last element
    @Override
    public void removeLast() {
        if (size == 0) throw new IndexOutOfBoundsException("List is empty");
        if (size == 1) {
            head = tail = null;
        } else {
            MyNode temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size--;
    }

    // Sorts the list using bubble sort
    @Override
    public void sort() {
        if (size < 2) return;

        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            while (current != null && current.next != null) {
                T elem1 = current.element;
                T elem2 = current.next.element;
                Comparable comp1 = (Comparable) elem1;
                if (comp1.compareTo(elem2) > 0) {
                    current.element = elem2;
                    current.next.element = elem1;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }