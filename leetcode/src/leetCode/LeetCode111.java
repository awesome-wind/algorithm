package leetCode;

/**
 * @Author James Wang
 * @Date 2018/2/25 20:55
 */

public class LeetCode111 {
     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null)
            return 1+minDepth(root.right);
        else if(root.right == null)
            return 1+minDepth(root.left);
        else
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}



