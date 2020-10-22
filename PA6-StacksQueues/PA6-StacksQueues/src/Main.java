public class Main {
    public static void main(String[] args){
        // System.out.println("peepeepoopoo");

        // -------------ArrayStack tests-------------------------
        // ArrayStack arr = new ArrayStack();
        // arr.push(2);
        // arr.push(1);
        // arr.push(10);
        // arr.push(19);
        // System.out.println(arr.toString());
        // int popped = arr.pop();
        // System.out.println(arr.toString());
        // System.out.println("popped element: " + popped);
        // System.out.println(arr.equals(arr));
        // System.out.println("peek " + arr.peek());

        // -------------ArrayQueue tests-------------------------
        // ArrayQueue q = new ArrayQueue();
        // q.enqueuez(1);
        // q.enqueuez(9);
        // q.enqueuez(3);
        // System.out.println(q.toString());

        // int bye = q.dequeue();
        // System.out.println(q.toString());
        // System.out.println("removed element: " + bye);

        // System.out.println("peek " + q.peek());

        // ArrayQueue q2 = new ArrayQueue();
        // System.out.println(q.isEmpty());
        // System.out.println(q2.isEmpty());
        
        // q.clear();
        // System.out.println(q.toString());

        // -------------ListStack tests-------------------------
        // -------------ArrayList tests-------------------------
        // ListStack ls = new ListStack();
        // ls.push(1);

        // -------------ListQueue tests-------------------------
        ListQueue lq = new ListQueue();
        lq.enqueuez(1);
        lq.enqueuez(9);
        lq.enqueuez(3);

        ListQueue lq2 = new ListQueue();
        lq2.enqueuez(1);
        lq2.enqueuez(9);
        lq2.enqueuez(3);
        System.out.println(("lq.equals(lq2) should be true: " + lq.equals(lq2)));

        System.out.println(lq.toString());
        System.out.println("dequeue: " + lq.dequeue());
        System.out.println(lq.toString());
        System.out.println("dequeue: " + lq.dequeue());
        System.out.println(lq.toString());
        System.out.println("dequeue: " + lq.dequeue());
        System.out.println(lq.toString());

        
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
        
        
        
    }
}
