package BinaryTree;

import java.util.LinkedList;

import java.util.Scanner;

public class BinaryTree {

    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root = null;
    private int size =0;

    BinaryTree(){
        Scanner s = new Scanner(System.in);
        this.root = takeInput(s,null,false);
    }

    public Node takeInput(Scanner s, Node parent, boolean isLeftOrRight){
        if(parent==null){
            System.out.println("Enter the data for the root node");
        }else{
                if(isLeftOrRight){
                    System.out.println("Enter the data to left of "+parent.data);
                }else{
                    System.out.println("Enter the data to right of "+parent.data);
                }
        }
        int nodeData = s.nextInt();
        Node node = new Node(nodeData,null,null);
        this.size++;

        boolean choice = false;
        System.out.println("DO you have left child for "+node.data);
        choice = s.nextBoolean();

        if(choice){
            node.left = takeInput(s,node,true);
        }
        choice = false;
        System.out.println("DO you have right child for "+node.data);
        choice = s.nextBoolean();

        if(choice){
            node.right = takeInput(s,node,false);
        }
        return node;
    }

    public void display(){
        this.display(this.root);
    }
    public void display(Node node){
        String str = "";
        if(node.left!=null){
            str = str + node.left.data + "=>";
        }else{
            str = str + "=> END";
        }

        str = str + node.data;

        if(node.right!=null){
            str = str +"<="+ node.right.data;
        }else{
            str = str + "<= END";
        }
        System.out.println(str);
    }

    public int height(){
     return this.height(this.root);
    }
    private int height(Node node){
        if(node == null){
            return -1;
        }
        int lheight = this.height(node.left);
        int rheight = this.height(node.right);
        int height = Math.max(lheight,rheight)+1;
        return height;
    }

    public void preOrder(){
        this.preOrder(this.root);
        System.out.print("END");
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        this.postOrder(this.root);
        System.out.print("END");
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+", ");
    }

    public void inOrder(){
        this.inOrder(this.root);
        System.out.print("END");
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+", ");
        inOrder(node.right);
    }
    public void levelOrder(){
        LinkedList<Node> queue = new LinkedList();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node rv = queue.removeFirst();
            System.out.print(rv.data+", ");
            if(rv.left!=null){
                queue.addLast(rv.left);
            }if(rv.right!=null){
                queue.addLast(rv.right);
            }
        }
        System.out.print("END");
    }
}
