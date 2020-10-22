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

    // @Override
    // public boolean equals(Object ls) {
    //     if (ls instanceof ListStack) {
    //         ListStack myStack = (ListStack) ls;
    //         if (size == myStack.size) {
    //             ListNode cur = myStack.front;
    //             ListNode cur1 = ((ListStack)ls).front;
    //             while (cur.next != null) {
    //                 if (cur != cur1) {
    //                     return false;
    //                 }
    //                 cur = cur.next;
    //                 cur1 = cur1.next;
    //             }
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }
    //     return false;
    // }

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
