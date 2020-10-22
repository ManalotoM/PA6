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

    private class ListNode {
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
