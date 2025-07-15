package BinarySearchTree;

public class BST {

    private class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;

    public BST(int arr[]) {
        this.root = construct(arr,0,arr.length-1);
    }

    private Node construct(int[] arr, int lo, int hi) {
    if(lo>hi){
        return null;
    }
    int mid = (lo+hi)/2;
    Node node = new Node();
    node.data = arr[mid];
    node.left = construct(arr,lo,mid-1);
    node.right = construct(arr,mid+1,hi);
    return node;
    }

    public void display(){
        this.display(this.root);
    }

    private void display(Node node){
        if(node==null){
            return;
        }
        String str = "";
        if(node.left==null){
            str = str + "END";
        }else{
            str = str + node.left.data;
        }
        str = str +" => "+ node.data + " <= ";
        if(node.right==null){
            str = str + "END";
        }else{
            str = str + node.right.data;
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public boolean find(int key){
        return find(root,key);
    }
    private boolean find(Node node,int key){
        if(node==null){
            return false;
        }
        if(node.data==key){
            return true;
        }
        if(node.data>key){
            return find(node.left,key);
        }
        return find(node.right,key);
    }
}
