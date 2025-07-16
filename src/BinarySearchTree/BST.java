package BinarySearchTree;

import java.util.ArrayList;

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

    public void add(int key){
        add(this.root,key);
    }
    private void add(Node node,int key){
        if(key>node.data){
            if(node.right==null){
                node.right = new Node();
                node.right.data = key;
            }else{
                add(node.right,key);
            }
        }else{
            if(node.left==null){
                node.left = new Node();
                node.left.data = key;
            }else{
                add(node.left,key);
            }
        }
    }

    public int max(){
        return max(root);
    }
    private int max(Node node){
        if(node.right==null){
            return node.data;
        }

        return max(node.right);
    }

    public ArrayList<Integer> convertTreeToArray(){
        ArrayList<Integer> list = new ArrayList<>();
        this.convertTreeToArray(this.root,list);
        return list;
    }
    private void convertTreeToArray(Node node,ArrayList<Integer> list){
            if((node==null)){
                return;
            }
            if(node.left==null && node.right==null){
                return;
            }
        if(node.left!=null){
            list.add(node.data);
            list.add(node.left.data);
        }else {
            list.add(null);
        }
        if(node.right!=null){
            list.add(node.right.data);
        }else {
            list.add(null);
        }
        convertTreeToArray(node.left,list);
        convertTreeToArray(node.right,list);
    }
}
