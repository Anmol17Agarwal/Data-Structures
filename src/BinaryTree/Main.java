package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.display();
        System.out.println("Height of tree is "+tree.height());
        tree.preOrder();
        tree.postOrder();
        tree.inOrder();
        tree.levelOrder();
        System.out.println(tree.isBST());
    }
}
