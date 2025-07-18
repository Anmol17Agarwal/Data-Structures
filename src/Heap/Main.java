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


    /*
    what are the minimum number of nodes required in CBT to have a height h?
    2^0 + 2^1 + 2^2 + 2^3 + 2^4+........+ 2^(h) + 1 = n
    now its become GP and we can find the formula of GP a(r^n-1)/r-1

    2^(h+1)-1 = n
    2^(h+1) = n+1
    h+1 = log(n+1)
    h = log(n+1)-1

    h = O(log(n))
    */

}
