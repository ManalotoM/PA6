/*
AUTHOR: Mark Manaloto
FILE: ArrayQueue.java
ASSIGNMENT: PA6 - Stacks and Queues
COURSE: CSC 210
PURPOSE: This program implements the QueueInterface using the array data structure.
    The ListStack has the fields of an array and a size, and contains the methods
    oneMore, enqueue, dequeue, peek, isEmpty, size, clear, equals, and toString.

    USAGE EXAMPLE:
    ArrayQueue q = new ArrayQueue();
    q.enqueue(1);
    q.enqueue(9);
    q.enqueue(3);
    System.out.println(q.toString());

    int bye = q.dequeue();
    System.out.println(q.toString());
    System.out.println("removed element: " + bye);

    System.out.println("peek " + q.peek());

    ArrayQueue q2 = new ArrayQueue();
    System.out.println(q.isEmpty());
    System.out.println(q2.isEmpty());
        
    q.clear();
    System.out.println(q.toString());

    OUTPUT:
    {1,9,3}
    {9,3}
    removed element: 1
    peek 9
    false
    true
    {}
*/

public class ArrayQueue implements QueueInterface {

    // fields
    private int[] queue;
    private int size;

    // constructor
    public ArrayQueue() {
        queue = new int[0];
        size = 0;
    }

    // copy constructor
    public ArrayQueue(ArrayQueue copy) {
        queue = new int[copy.queue.length];
        size = copy.size;
        for (int i = 0; i < size; i++) {
            queue[i] = copy.queue[i];
        }
    }

    private int[] oneMore(int[] queue) {
        int[] newQueue = new int[size];
        for (int i = 0; i < size - 1; i++) {
            newQueue[i] = queue[i];
        }
        return newQueue;
    }

    @Override
    public void enqueue(int value) {
        int[] newQueue;
        size++;
        if (size == 1) {
            newQueue = new int[1];
            newQueue[0] = value;
        } else {
            newQueue = oneMore(queue);
            newQueue[size - 1] = value;
        }
        queue = newQueue;
    }

    @Override
    public int dequeue() {
        if (size == 0) {
            return -1;
        }
        int byebye = queue[0];
        int[] newQueue = new int[size - 1];
        for (int i = 1; i < size; i++) {
            newQueue[i-1] = queue[i];
        }
        queue = newQueue;
        return byebye;
    }

    @Override
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        int[] newQueue = new int[0];
        size = 0;
        queue = newQueue;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayQueue)) return false;

        ArrayQueue queue = (ArrayQueue) o;
        if (queue.size != size) return false;

        String myQueue = this.toString();
        String inputQueue = this.toString();

        return myQueue.equals(inputQueue);
    }

    // format: "{0,1,2,3,4,5}"
    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < queue.length; i++) {
            if (i == queue.length - 1) {
                s += String.valueOf(queue[i]);
            } else {
                s += String.valueOf(queue[i]) + ",";
            }
        }
        return s + "}";
    }
}
