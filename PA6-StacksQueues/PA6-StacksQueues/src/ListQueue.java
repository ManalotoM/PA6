public class ListQueue implements QueueInterface{

    // fields
    private ListNode head;
    private ListNode tail;
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
                enqueuez(value);
            }
        } while (value != -1);
    }

    @Override
    public void enqueuez(int value) {
        if (head == null) {
            // queue is empty
            ListNode node = new ListNode(value, null);
            head = tail = node;
        } else {
            ListNode oldHead = head;
            head = new ListNode(value, oldHead);
        }
        
        size+=1;
    }

    @Override
    public int dequeue() {
        if (size == 0) return -1;

        ListNode currentNode = head;
        ListNode previousNode = head;
        while (currentNode.next != null)
        {
            previousNode = currentNode;
            currentNode = currentNode.next;            
        }
        tail = previousNode;
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
        return false;
    }

    // format: "{0,1,2,3,4,5}"
    @Override
    public String toString() {
        return "";
    }
}
