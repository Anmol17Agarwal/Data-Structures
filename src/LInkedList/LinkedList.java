package LInkedList;

public class LinkedList {
    private class Node {
        private int data;
        private Node next;
    }
        private Node head;
        private Node tail;
        private int size;


        public void display() {
            System.out.println("-------------------------------------");
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+",");
                temp = temp.next;
            }
            System.out.println(".");
            System.out.println("-------------------------------------");
        }

        public void addLast(int item){
            Node nn = new Node();
            nn.data = item;
            nn.next=null;

            if(this.size>=1){
                this.tail.next=nn;
            }
            if(size==0){
                this.head = nn;
                this.tail = nn;
                this.size++;
            }else{
                this.tail =nn;
                this.size++;
            }
        }

        public void addFirst(int item){
            Node nn = new Node();
            nn.data=item;
            nn.next=null;
            if(this.size>=1){
                nn.next = head;
            }
            if(size==0){
                this.head=nn;
                this.tail=nn;
                this.size++;
            }
            else{
                this.head=nn;
                this.size++;
            }
        }
        public int getFirst() throws Exception{
            if(this.size==0){
                throw new Exception("LinkList is Empty");
            }
            return head.data;
        }
        public int getLast() throws Exception{
            if(this.size==0){
                throw new Exception("LinkList is Empty");
            }
            return tail.data;
        }
        public int getAt(int index)throws Exception{
            if(this.size==0){
                throw new Exception("LinkedList is empty");
            }
            if(index<0 || index>=this.size){
                throw new Exception("Invalid Index Exception");
            }
            Node temp = this.head;
            for(int i = 1; i < index; i++) {
                temp  =temp.next;
            }
            return temp.data;
        }

    private Node getNodeAt(int index)throws Exception{
        if(this.size==0){
            throw new Exception("LinkedList is empty");
        }
        if(index<0 || index>=this.size){
            throw new Exception("Invalid Index Exception");
        }
        Node temp = this.head;
        for(int i = 1; i < index; i++) {
            temp  =temp.next;
        }
        return temp;
    }
    public void addNodeAt(int item, int index)throws Exception{
        if(index<0 || index>=this.size){
            throw new Exception("Invalid Index Exception");
        }
        if(index==0){
            addFirst(item);
        }if(index==this.size){
            addLast(item);
        }
        Node nn = new Node();
        nn.data = item;
        nn.next = null;

        Node nm1 = getNodeAt(index-1);
        Node np1 = nm1.next;
        nm1.next = nn;
        nn.next = np1;
        this.size++;
    }

    public void removeFirstNode() throws Exception{
        if(this.size==0){
            throw new Exception("LinkedList is empty");
        }
        int rv = this.head.data;
        if(this.size==1){
            this.head=null;
            this.tail=null;
            this.size=0;
        }else{
            this.head = this.head.next;
            this.size--;
        }
    }
    public void removeLastNode() throws Exception{
        if(this.size==0){
            throw new Exception("LinkedList is empty");
        }
        int rv = this.head.data;
        if(this.size==1){
            this.head=null;
            this.tail=null;
            this.size=0;
        }else{
            Node nm2 = getNodeAt(this.size-1);
            this.tail = nm2;
            this.tail.next=null;
            this.size--;
        }
    }
    public void removeNthNode(int index)throws Exception{
        if(this.size==0){
            throw new Exception("LinkedList is empty");
        }
        if(index<0 || index>=this.size){
            throw new Exception("Invalid Index Exception");
        }
        if(index==1){
            removeFirstNode();
        }if(index==this.size){
            removeLastNode();
        }else{
            Node nm1 = getNodeAt(index-1);
            Node n = nm1.next;
            Node np1 = n.next;
            nm1.next = np1;
            this.size--;
        }
    }
    public void reverseLinkList() throws Exception {
            int left=0;
            int right=this.size-1;
            while(left<right){
                Node leftNode = getNodeAt(left);
                Node rightNode  = getNodeAt(right);
                int temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data=temp;
                left++;
                right--;
            }
    }
    public int mid(){
            Node slow = this.head;
            Node fast = this.head;
            while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
    }
}
