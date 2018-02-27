package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author James Wang
 * @Date 2018/2/27 20:33
 */

public class LeetCode113 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    private static TreeNode root = null;
    public static void main(String[] args) {
        LeetCode113 leetCode = new LeetCode113();
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int length = scanner.nextInt();
        int[] value = new int[length];
        for(int i=0;i<length;i++)
            value[i] = scanner.nextInt();

        for(int i = 0;i<value.length;i++)
            leetCode.builtTree(root,value[i]);

        leetCode.print(root);

        List<List<Integer>> list = leetCode.pathSum(root,sum);
        System.out.println(list.toString());
    }

    private List<List<Integer>> pathSum(TreeNode node, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(node == null)
            return list;

        findPath(node,list,new ArrayList<>(),sum,0);
        return list;
    }

    private void findPath(TreeNode node, List<List<Integer>> list,List<Integer> tempList , int sum,int currentSum) {
        currentSum += node.val;
        tempList.add(node.val);
        boolean isLeaf = (node.left == null && node.right == null);
        if(currentSum == sum && isLeaf)
        {
            list.add(new ArrayList<>(tempList));
        }

        if(node.left != null)
            findPath(node.left,list,tempList,sum,currentSum);
        if(node.right != null)
            findPath(node.right,list,tempList,sum,currentSum);

        tempList.remove(tempList.size() -1);
    }

    private void builtTree(TreeNode node, int value) {
        if(root == null)
            root = new TreeNode(value);
        else
        {
            if(node.val > value){
                if(node.left == null)
                    node.left = new TreeNode(value);
                else
                    builtTree(node.left,value);
            }
            else {
                if(node.right == null)
                    node.right = new TreeNode(value);
                else
                    builtTree(node.right,value);
            }

        }
    }

    private void print(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if(node != null) {
            stack.push(node);
            while(!stack.empty()){
                node = stack.pop();
                System.out.print(node.val+" ");
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);
            }
        }
    }

}
