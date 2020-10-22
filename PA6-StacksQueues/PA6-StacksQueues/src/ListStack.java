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
        if (size == 0) {
            front.data = value;
        } else if(size == 1) {
            front.next.data = value;
        } else {
            ListNode cur = front;
            ListNode next = front.next;
            while (cur.next != null) {
                ;
            }
        }
        size++;
    }

    @Override
    public int pop() {
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
    
    @Override
    public boolean equals(Object ls) {
        return false;
    }

    // format: "{0,1,2,3,4,5}"
    @Override
    public String toString() {
        return "";
    }    
}
