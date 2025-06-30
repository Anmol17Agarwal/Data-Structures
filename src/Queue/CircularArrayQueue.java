package Queue;

public class CircularArrayQueue {
    private int[] arr;
    private int cs;
    private int ms;
    private int front;
    private int rear;

    public static int DEFAULT_CAPACITY = 10;

    CircularArrayQueue(){
        this(DEFAULT_CAPACITY);
    }
    CircularArrayQueue(int capacity){
        this.arr = new int[capacity];
        this.cs =0;
        this.ms = capacity;
        this.front=0;
        this.rear=capacity-1;
    }

    public boolean isFull(){
        return this.cs==this.ms;
    }
    public boolean isEmpty(){
        return this.cs==0;
    }
    public void enqueue(int data){
        if(!this.isFull()){
            this.rear = (this.rear+1)%this.arr.length;
            this.arr[this.rear]=data;
            this.cs = this.cs+1;
        }
    }
    public void dequeue(){
        if(!this.isEmpty()){
            this.front = (this.front+1)% this.arr.length;
            this.cs=this.cs-1;
        }
    }

    public int getFront(){
        return  this.arr[this.front];
    }

    public static void main(String[] args) {
        CircularArrayQueue caq = new CircularArrayQueue();
        for (int i = 0; i < 6; i++) {
            caq.enqueue(i);
        }
        caq.dequeue();
        caq.dequeue();
        caq.enqueue(7);
        while (!caq.isEmpty()){
            System.out.println(caq.getFront());
            caq.dequeue();
        }
    }
}
