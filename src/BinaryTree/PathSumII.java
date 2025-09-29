package BinaryTree;

//Leetcode question number 113
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(BinaryTree.IsSameTree.TreeNode root, int targetSum){
            List<List<Integer>> ll = new ArrayList<>();
            List<Integer> pathS = new ArrayList<>();
            helper(root,targetSum,ll,pathS);
            return ll;
        }
        public void helper(BinaryTree.IsSameTree.TreeNode root, int targetSum, List<List<Integer>> ll, List<Integer> pathS ) {
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
