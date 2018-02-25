package chapter3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author James Wang
 * @Date 2018/2/25 20:57
 */

public class LeetCode112 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode root = null;

    public static void main(String[] args) {
        LeetCode112 leetCode = new LeetCode112();
        Scanner scanner = new Scanner(System.in);

        int sum = scanner.nextInt();
        int numOfNodes = scanner.nextInt();
        int[] arr = new int[numOfNodes];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();

        for (int i = 0; i < arr.length; i++)
            leetCode.builtBinaryTree(root, arr[i]);

        leetCode.print(root);

        System.out.println("是否存在此路径："+leetCode.isPath(root,sum));
    }

    private Boolean isPath(TreeNode node,int sum) {
        if(node == null)
        {
            return false;
        }
        if(node.left == null && node.right==null && node.val==sum)
            return true;
        return isPath(node.left, sum - node.val) || isPath(node.right, sum-node.val);
    }

    private void builtBinaryTree(TreeNode node, int value) {
        if (root == null)
            root = new TreeNode(value);
        else {
            if (value < node.val) {
                if (node.left == null)
                    node.left = new TreeNode(value);
                else
                    builtBinaryTree(node.left, value);
            } else {
                if (node.right == null)
                    node.right = new TreeNode(value);
                else
                    builtBinaryTree(node.right,value);
            }
        }
    }

    private void print(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        if(node != null) {
            stack.push(node);
            while(!stack.empty()){
                node = stack.pop();
                System.out.print(node.val+" ");
                if(node.right != null)
                    stack.push(node.right);
                if(node.left !=null)
                    stack.push(node.left);
            }
        }
    }
}
