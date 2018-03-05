package leetCode;

/**
 * @Author James Wang
 * @Date 2018/2/24 21:28
 */

public class LeetCode110 {
    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftLen = depth(root.left);
        int rightLen = depth(root.right);

        return Math.abs(leftLen-rightLen)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}
