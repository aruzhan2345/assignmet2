- `MyArrayList` — array-based list
- `MyLinkedList` — doubly linked list
- `MyStack` — stack using `MyArrayList`
- `MyQueue` — queue using `MyLinkedList`
- `MyMinHeap` — min-heap using `MyArrayList`

All classes are tested in the `Main.java` file.


Implemented Classes

MyList<T> (Interface)
- Declares all core list operations like `add`, `remove`, `get`, `sort`, etc.
- Used as the base interface for both `MyArrayList` and `MyLinkedList`.


MyArrayList<T> (Array-based List)
- Stores elements in a dynamically resizable `Object[]`.
- Implements all list operations from `MyList`.
- Supports sorting via Bubble Sort using `T extends Comparable<T>`.
- Used as the base for `MyStack` and `MyMinHeap`.


MyLinkedList<T> (Doubly Linked List)
- Uses an inner `MyNode` class with `next` and `prev` references.
- Fully implements `MyList`.
- Properly handles memory and prevents loops.
- Used as the base for `MyQueue`.


MyStack<T>
- Implements LIFO behavior using `MyArrayList`.
- Methods: `push`, `pop`, `peek`, `size`, `isEmpty`.


MyQueue<T>
- Implements FIFO behavior using `MyLinkedList`.
- Methods: `enqueue`, `dequeue`, `peek`, `size`, `isEmpty`.


MyMinHeap<T>
- Implements a binary min-heap using `MyArrayList`.
- Maintains heap property using `bubbleUp` and `bubbleDown`.
- Methods: `insert`, `removeMin`, `getMin`, `size`, `isEmpty`.


Testing

All data structures are tested in the `Main.java` file:
- Adding, removing, sorting, searching elements.
- Stack: push/pop/peek
- Queue: enqueue/dequeue/peek
- Heap: insert/removeMin/getMin
