package QueueDSA;

import java.util.LinkedList;
import java.util.Queue;

public class Basic {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);

        System.out.println(q.peek());
        System.out.println(q.poll());// prints ht first element and removes it
        System.out.println(q.element());
        System.out.println(q.poll());
    }
}
