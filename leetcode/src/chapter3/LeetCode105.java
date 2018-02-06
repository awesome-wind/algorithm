package chapter3;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/2/2 20:17
 */

public class LeetCode105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCode105 leetCode105 = new LeetCode105();
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] preOrder = new int[length];
        int[] inOrder = new int[length];

        for (int i = 0; i < length; i++)
            preOrder[i] = scanner.nextInt();
        for (int i = 0; i < length; i++)
            inOrder[i] = scanner.nextInt();

        TreeNode root = leetCode105.reBuiltTheTree(preOrder,inOrder);
    }

    public TreeNode reBuiltTheTree(int[] preOrder,int[] inOrder){
        if(preOrder == null||preOrder.length != inOrder.length||inOrder.length == 0)
            return null;

        return built(preOrder,inOrder,0,0,inOrder.length-1);
    }

    /**
     * @Date: 2018/2/2 21:06
     * @Context:  第三个参数针对前序遍历，第四五个参数针对中序遍历
     */
    private TreeNode built(int[] preOrder, int[] inOrder, int indexPre, int start, int end) {
        if(end<start)
            return null;
        TreeNode node = new TreeNode(preOrder[indexPre]);

        int indexIn = getLocationInInOrder(inOrder,preOrder[indexPre]);
        int leftLength = indexIn - start;
        int rightLength = end - indexIn;

        if(indexIn != -1) {
            if(leftLength>0)
                node.left = built(preOrder,inOrder,indexPre+1,start,indexIn-1);
            if(rightLength>0)
                node.right = built(preOrder,inOrder,indexPre+leftLength+1,indexIn+1,end);
        }
        return node;
    }

    private int getLocationInInOrder(int[] inOrder, int val) {
        int index = -1;
        for(int i = 0;i<inOrder.length;i++)
            if(inOrder[i] == val)
                index = i;
        return index;
    }


}
