package BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50,60,70};
        BST bst = new BST(arr);
        bst.display();
        System.out.println(bst.find(44));
        bst.add(44);
        System.out.println(bst.find(44));
        System.out.println(bst.max());
    }
}
