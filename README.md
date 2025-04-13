Java Data Structures (Custom Implementations)

MyList An interface that defines a custom list structure. All other list classes (MyArrayList, MyLinkedList) implement this interface.

MyArrayList A custom implementation of a dynamic array.
Key features:

Automatically resizes when full
Supports add, remove, get, set, sort, indexOf, exists, clear, toArray
Allows iteration with Iterator
MyLinkedList A doubly linked list implementation.
Key features:

Nodes have next and prev pointers
Supports addFirst, addLast, removeFirst, removeLast, sort, indexOf, and more
MyStack A stack built on top of MyArrayList.
Key methods:

push(), pop(), peek(), isEmpty()
MyQueue A queue implemented using MyLinkedList.
Key methods:

enqueue(), dequeue(), peek(), isEmpty()
MyMinHeap A min-heap (priority queue) using MyArrayList internally.
Key methods:

insert(), getMin(), removeMin(), with internal bubbleUp and bubbleDown logic
Main.java The Main class demonstrates and tests the behavior of all data structures.
It includes examples like:

Adding and removing elements
Sorting lists
Stack and queue operations
Heap insertion and minimum retrieval
