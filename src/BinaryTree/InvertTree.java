package BinaryTree;

//LeetCode question number 226
public class InvertTree {
    public BinaryTree.IsSameTree.TreeNode invertTree(BinaryTree.IsSameTree.TreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTree.IsSameTree.TreeNode left = invertTree(root.left);
        BinaryTree.IsSameTree.TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

