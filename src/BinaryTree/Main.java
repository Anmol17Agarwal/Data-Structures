package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.display();
        System.out.println("Height of tree is "+tree.height());
        tree.preOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.levelOrder();
        System.out.println(tree.isBST());
//        tree.inOrderTraversal(tree.root);
        System.out.println(tree.diameterOFBT());
        System.out.println(tree.sumofLeafNodes());
    }
}
