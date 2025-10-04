package BinaryTree;

//Leetcode question number 113
import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
            List<List<Integer>> ll = new ArrayList<>();
            List<Integer> pathS = new ArrayList<>();
            helper(root,targetSum,ll,pathS);
            return ll;
        }
        public void helper(TreeNode root, int targetSum, List<List<Integer>> ll, List<Integer> pathS ) {
            if (root == null) {
                return;
            }
            targetSum -= root.val;
            pathS.add(root.val);
            if (root.left == null && root.right == null) {
                if (targetSum == 0) {
                    ll.add(new ArrayList<>(pathS));
                }
            }
            helper(root.left, targetSum,ll,pathS);
            helper(root.right, targetSum,ll,pathS);
            pathS.remove(pathS.size() - 1);
        }
}
