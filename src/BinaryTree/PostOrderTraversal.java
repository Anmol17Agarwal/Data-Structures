package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//LeetCode question number 145
public class PostOrderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(BinaryTree.IsSameTree.TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}

