package chapter3;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/2/5 20:28
 */

public class LeetCode106 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCode106 leetCode106 = new LeetCode106();
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] inOrder = new int[length];
        int[] postOrder = new int[length];

        for (int i = 0; i < length; i++)
            inOrder[i] = scanner.nextInt();
        for (int i = 0; i < length; i++)
            postOrder[i] = scanner.nextInt();

        TreeNode root = leetCode106.builtTheTree(inOrder,postOrder);
        leetCode106.print(root);
    }

    private TreeNode builtTheTree(int[] inOrder,int[] postOrder){
        if(inOrder == null || inOrder.length == 0){
            System.out.println("inOrder输入不合法");
            return null;
        }
        if(postOrder == null || postOrder.length == 0)
        {
            System.out.println("postOrder输入不合法");
            return null;
        }
        if(inOrder.length != postOrder.length)
        {
            System.out.println("inOrder的长度与postOrder的长度不匹配");
        }
        return builtTree(inOrder,postOrder,postOrder.length - 1,0,inOrder.length - 1);
    }

    private TreeNode builtTree(int[] inOrder,int[] postOrder,int index,int start,int end){
        if(start>end)
            return null;
        TreeNode node = new TreeNode(postOrder[index]);
        int index_inOrder = 0;
        for(int i = 0;i<inOrder.length;i++)
            if(inOrder[i] == node.val)
                index_inOrder = i;
        int leftLen = index_inOrder - start;
        int rightLen = end - index_inOrder;

        if(leftLen > 0)
            node.left = builtTree(inOrder,postOrder,index - rightLen - 1,start,index_inOrder - 1);
        if(rightLen > 0)
            node.right = builtTree(inOrder,postOrder,index - 1,index_inOrder+1,end);

        return node;
    }

    private void print(TreeNode node) {
        if(node != null) {
            print(node.left);
            System.out.print(node.val+" ");
            print(node.right);
        }
    }

}
