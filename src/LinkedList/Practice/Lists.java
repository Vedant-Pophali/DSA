package LinkedList.Practice;

public class Lists {
    public static void main(String[] args) {
        Node ten = new Node(10);
        Node twenty = new Node(20);
        Node thirty = new Node(30);
        Node fourty = new Node(40);
        Node fifty = new Node(50);

        Node head=ten;
        ten.setNext(twenty);
        twenty.setNext(thirty);
        thirty.setNext(fourty);
        fourty.setNext(fifty);
        fifty.setNext(null);

        head=insBeg(head,5);
        printLinkedList(head);
        System.out.println();
        head=delBeg(head);
        printLinkedList(head);
    }

    public static Node insBeg(Node  head,int data){
        Node newNode = new Node(data);
        newNode.setNext(null);
        if(head==null){
            head=newNode;
        }
        else{
            newNode.setNext(head);
            head=newNode;
        }
        return head;
    }

    public static Node delBeg(Node head){
        if(head==null){
            System.out.println("List is empty");
        }
        else{
            head=head.getNext();
        }
        return head;
    }
    public static void printLinkedList(Node head) {
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.getData()+" ");
            curr=curr.getNext();
        }
    }
}