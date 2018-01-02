package chapter6;

public class TreeDepth_55 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode root = null;
    private static int pDepth = 0;
    private static int depthLeft = 0;
    private static int depthRight = 0;

    public static void main(String[] args) {
        int depth = getTreeDepth(root);
        boolean tree = isBalancedTree(root);
        boolean tree1 = isBancedTreePro(root);
    }

    private static boolean isBancedTreePro(TreeNode root1) {
        if(root == null)
        {
            pDepth = 0;
            return true;
        }

        return false;
        // TODO: 2017/12/28   there is something wrong
//        if(isBancedTreePro(root1.left) && isBancedTreePro(root1.right)){
//            int q
//        }
    }

    private static boolean isBalancedTree(TreeNode root) {
        if(root == null)
            return true;

        int nleft = getTreeDepth(root.left);
        int nright = getTreeDepth(root.right);
        int diff = nleft - nright;
        if(Math.abs(diff)>1)
            return false;

        return isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    private static int getTreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int nleft = getTreeDepth(root.left);
        int nright = getTreeDepth(root.right);

        return (nleft > nright)?(nleft+1):(nright+1);
    }
}
