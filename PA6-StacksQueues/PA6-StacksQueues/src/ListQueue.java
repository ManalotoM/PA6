/*
AUTHOR: Mark Manaloto
FILE: ListQueue.java
ASSIGNMENT: PA6 - Stacks and Queues
COURSE: CSC 210
PURPOSE: This program implements the QueueInterface using the linked list data structure.
    The ListStack has the fields of an array and a size, and contains the methods enqueue,
    dequeue, peek, isEmpty, size, clear, equals, and toString. The program also has a
    nested ListNode class, which allows the user to create a singly linked list.

    USAGE EXAMPLE:
    ListQueue lq = new ListQueue();
    lq.enqueue(1);
    lq.enqueue(9);
    lq.enqueue(3);

    ListQueue lq2 = new ListQueue();
    lq2.enqueue(1);
    lq2.enqueue(9);
    lq2.enqueue(3);
    System.out.println(("lq.equals(lq2) should be true: " + lq.equals(lq2)));

    System.out.println(lq.toString());
    System.out.println("dequeue: " + lq.dequeue());
    System.out.println(lq.toString());
    System.out.println("dequeue: " + lq.dequeue());
    System.out.println(lq.toString());
    System.out.println("dequeue: " + lq.dequeue());
    System.out.println(lq.toString());
    
    OUTPUT:
    lq.equals(lq2) should be true: true
    {1,9,3}   
    dequeue: 1
    {9,3}
    dequeue: 9
    {3}
    dequeue: 3
    {}
*/

public class ListQueue implements QueueInterface{

    // fields
    private ListNode1 head;
    private ListNode1 tail;
    private int size;

    // constructor
    public ListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // copy constructor
    public ListQueue(ListQueue copy) {
        head = null;
        tail = null;
        size = 0;
        if (copy != null && copy.size > 0) {
            clone(copy);
        }    
    }

    private void clone(ListQueue queue) {
        int value = -1;
        do {
            value = queue.dequeue();
            if (value != -1) {
                enqueue(value);
            }
        } while (value != -1);
    }

    @Override
    public void enqueue(int value) {
        if (head == null) {
            // queue is empty
            ListNode1 node = new ListNode1(value);
            head = tail = node;
        } else {
            ListNode1 oldHead = head;
            head = new ListNode1(value, oldHead);
        }
        
        size+=1;
    }

    @Override
    public int dequeue() {
        if (size == 0) return -1;

        ListNode1 currentNode = head;
        ListNode1 previousNode = head;
        while (currentNode.next != null)
        {
            previousNode = currentNode;
            currentNode = currentNode.next;            
        }
        tail = previousNode;
        tail.next = null;
        size -= 1;
        return currentNode.data;
    }

    @Override
    public int peek() {
        if (size == 0) return -1;
        return tail.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListQueue)) return false;

        ListQueue queue = (ListQueue) o;
        if (queue.size != size) return false;

        String myQueue = this.toString();
        String inputQueue = this.toString();
        
        return myQueue.equals(inputQueue);
    }

    @Override
    public String toString() {
        if (size == 0) return "{}";
        String text = "}";

        ListNode1 currentNode = head;
        text = currentNode.data + text;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            text = currentNode.data + "," + text;
        }
        text = "{" + text;
        return text;
    }

    private class ListNode1 {
        int data;
        ListNode1 next;

        public ListNode1(int data, ListNode1 next) {
            this.data = data;
            this.next = next;
        }

        public ListNode1(int data) {
            this(data, null);
        }

        public ListNode1() {
            this(0, null);
        }
    }
}
