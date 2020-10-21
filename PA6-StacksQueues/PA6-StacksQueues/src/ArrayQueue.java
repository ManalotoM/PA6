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

    public int[] oneMore(int[] queue) {
        int[] newQueue = new int[size];
        for (int i = 0; i < size - 1; i++) {
            newQueue[i] = queue[i];
        }
        return newQueue;
    }

    @Override
    public void enqueuez(int value) {
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int peek() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    // @Override
    // public boolean equals() {
    //     return false;
    // }

    // format: "{0,1,2,3,4,5}"
    @Override
    public String toString() {
        return "";
    }
}
