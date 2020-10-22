/*
AUTHOR: Mark Manaloto
FILE: ArrayStack.java
ASSIGNMENT: PA6 - Stacks and Queues
COURSE: CSC 210
PURPOSE: This program implements the StackInterface using the array data structure.
    The ArrayStack has the fields of an array and a size, and contains the methods
    oneMore, push, pop, peek, isEmpty, size, clear, equals, and toString.

    USAGE EXAMPLE:
    ArrayStack arr = new ArrayStack();
    arr.push(2);
    arr.push(1);
    arr.push(10);
    arr.push(19);
    System.out.println(arr.toString());
    int popped = arr.pop();
    System.out.println(arr.toString());
    System.out.println("popped element: " + popped);
    System.out.println(arr.equals(arr));
    System.out.println("peek " + arr.peek());

    OUTPUT:
    {2,1,10,19}
    {2,1,10}
    popped element: 19
    true
    peek 10
*/

public class ArrayStack implements StackInterface{

    // fields
    private int[] stack;
    private int size;

    // constructor
    public ArrayStack() {
        stack = new int[0];
        size = 0;
    }

    // copy constructor
    public ArrayStack(ArrayStack copy) {
        stack = new int[copy.stack.length];
        size = copy.size;
        for (int i = 0; i < size; i++) {
            stack[i] = copy.stack[i];
        }
    }

    private int[] oneMore(int[] stack) {
        int[] newStack = new int[size];
        for (int i = 0; i < size - 1; i++) {
            newStack[i] = stack[i];
        }
        return newStack;
    }

    @Override
    public void push(int value) {
        int[] newStack;
        size++;
        if (size == 1) {
            newStack = new int[1];
            newStack[0] = value;
        } else {
            newStack = oneMore(stack);
            newStack[size - 1] = value;
        }
        stack = newStack;
    }

    @Override
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int popped = stack[size - 1];
        int[] newStack = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            newStack[i] = stack[i];
        }
        size--;
        stack = newStack;
        return popped;
    }

    @Override
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return stack[size - 1];
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
        int[] newStack = new int[0];
        size = 0;
        stack = newStack;
    }
    
    @Override
    public boolean equals(Object arr) {
        if (arr instanceof ArrayStack) {
            ArrayStack myStack = (ArrayStack) arr;
            if (size == myStack.size) {
                for (int i = 0; i < size; i++) {
                    if (stack[i] != myStack.stack[i]) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // format: "{0,1,2,3,4,5}"
    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < stack.length; i++) {
            if (i == stack.length - 1) {
                s += String.valueOf(stack[i]);
            } else {
                s += String.valueOf(stack[i]) + ",";
            }
        }
        return s + "}";
    }

}
