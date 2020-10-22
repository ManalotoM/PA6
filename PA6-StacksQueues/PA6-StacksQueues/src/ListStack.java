/*
AUTHOR: Mark Manaloto
FILE: ListStack.java
ASSIGNMENT: PA6 - Stacks and Queues
COURSE: CSC 210
PURPOSE: This program implements the StackInterface using the linked list data structure.
    The ListStack has the fields of an ListNode front and a size, and contains the methods
    push, pop, peek, isEmpty, size, clear, equals, and toString. The program also has a
    nested ListNode class, which allows the user to create a singly linked list.
    
    USAGE EXAMPLE:
    ListStack ls = new ListStack();
    ls.push(1);
    ls.push(2);
    ls.push(3);
    System.out.println(ls.toString());
    int popped = ls.pop();
    System.out.println(ls.toString());
    System.out.println(popped);
    System.out.println(ls.peek());
    System.out.println(ls.isEmpty());
    ListStack ls2 = new ListStack();
    System.out.println(ls2.isEmpty());
    System.out.println(ls.size());
        
    ls.clear();
    System.out.println(ls.toString());
    System.out.println(ls2.equals(ls2));

    OUTPUT:
    {1,2,3}
    {1,2}
    3
    2
    false
    true
    2
    {}
    true
*/

public class ListStack implements StackInterface {

    // fields
    private ListNode front;
    int size;

    // constructor
    public ListStack() {
        front = null;
        // front.next = null;
        size = 0;
    }

    // copy constructor
    public ListStack(ListStack copy) {
        front = copy.front;
        size = copy.size;
        ListNode cur = copy.front;
        ListNode next = front;
        while (cur.next != null) {
            next.next = cur.next;
            next = next.next;
            cur = cur.next;
        }
    }

    @Override
    public void push(int value) {
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            front = newNode;
        } else {
            ListNode cur = front;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }

    @Override
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int popped = -1;
        ListNode cur = front;
        while (cur.next != null) {
            if (cur.next.next == null) {
                popped = cur.next.data;
                cur.next = null;
            } else {
                cur = cur.next;
            }
        }
        size--;
        return popped;
    }

    @Override
    public int peek() {
        if (size == 0) {
            return -1;
        }
        ListNode cur = front;
        while (cur.next != null) {
            if (cur.next.next == null) {
                return cur.next.data;
            } else {
                cur = cur.next;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListStack)) return false;

        ListStack stack = (ListStack) o;
        if (stack.size != size) return false;

        String myStack = this.toString();
        String inputStack = this.toString();

        return myStack.equals(inputStack);
    }

    // format: "{0,1,2,3,4,5}"
    @Override
    public String toString() {
        String s = "{";
        ListNode cur = front;
        if (size == 1) {
            return s + cur.data + "}";
        }
        while (cur != null) {
            if (cur.next == null) {
                s += String.valueOf(cur.data);
            } else {
                s += String.valueOf(cur.data) + ",";
            }
            cur = cur.next;
        }
        return s + "}";
    }

    public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data) {
        this(data, null);
    }

    public ListNode() {
        this(0, null);
    }
}
}
