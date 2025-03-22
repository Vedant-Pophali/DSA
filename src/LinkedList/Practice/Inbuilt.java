package LinkedList.Practice;

import java.util.Iterator;
import java.util.LinkedList;

public class Inbuilt {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.add(60);
        ll.add(70);
        ll.add(80);
        ll.add(90);
        ll.add(90);
        ll.add(90);
        ll.add(100);
        ll.add(100);
        ll.add(100);

        System.out.println("Linked List");
        //Prints elements of the linked list
        Iterator<Integer> it = ll.iterator();
        while (it.hasNext()) {
            System.out.print((it.next()+" "));
        }

        System.out.println("\n\nRemoving elements from linked list");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();
        ll.removeLastOccurrence(90);
        
        it=ll.iterator();
        while (it.hasNext()) {
            System.out.print((it.next()+" "));
        }
        //Checks if element is present
        System.out.println("\n");
        System.out.println("Is 3 present ? "+ll.contains(3));
        System.out.println("Is 40 present ? "+ll.contains(40));

        System.out.println("\nReversed Linked List");
        //Traverse from backwards
        Iterator<Integer> iter = ll.descendingIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next()+" ");
        }
    }
}
