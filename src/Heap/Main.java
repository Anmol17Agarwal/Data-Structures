package Heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(10);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(3);
        heap.display();
        heap.add(42);
        heap.display();
        heap.add(5);
        heap.display();

        System.out.println(heap.delete());
        heap.display();
        System.out.println(heap.delete());
        heap.display();
    }
}
