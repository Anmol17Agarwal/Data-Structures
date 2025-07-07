package LInkedList;

public class Main {
    public static void main(String[] args)throws Exception {
        LinkedList ll = new LinkedList();

        ll.addFirst(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addFirst(40);
        ll.addFirst(50);
        ll.display();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.getAt(2));
        ll.addNodeAt(15,2);
        ll.display();
        ll.removeFirstNode();
        ll.display();
        ll.removeLastNode();
        ll.display();
        ll.removeNthNode(2);
        ll.display();
        ll.reverseLinkList();
        System.out.println("he");
        ll.display();
    }
}
