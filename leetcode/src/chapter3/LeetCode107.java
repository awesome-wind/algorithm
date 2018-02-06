package chapter3;

import java.util.*;

import static java.lang.System.in;

/**
 * @Author James Wang
 * @Date 2018/2/6 20:45
 */

public class LeetCode107 {
    private static TreeNode root = null;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCode107 leetCode107 = new LeetCode107();
        Scanner scanner = new Scanner(in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i = 0;i<length;i++)
            arr[i] = scanner.nextInt();

        for(int i =0 ;i<length;i++)
            leetCode107.builtTree(root,arr[i]);

        leetCode107.print(root);

        List<List<Integer>> list = leetCode107.levelOrderBottom(root);
    }

    private List<List<Integer>> levelOrderBottom(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();
        Stack[] stack = new Stack[2];
        stack[0] = new Stack<Integer>();
        stack[1] = new Stack<Integer>();
        int flag = 1;
        if(node == null)
            return null;

        stack[flag].push(node);

        while(!stack[flag].empty()) {

            stack[1-flag].clear();
            List<Integer> tempList = new ArrayList<>();

            Iterator it = stack[flag].iterator();
            while(it.hasNext()) {
                TreeNode treeNode = (TreeNode) it.next();
                tempList.add(treeNode.val);

                System.out.print("节点的值为:"+treeNode.val+" ");
                if(treeNode.left !=null)
                    stack[1-flag].push(treeNode.left);
                if(treeNode.right !=null)
                    stack[1-flag].push(treeNode.right);
            }
            System.out.println();
            list.add(new ArrayList<>(tempList));
            flag = 1-flag;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = list.size()-1;i>=0;i --)
            resultList.add(list.get(i));

        return resultList;
    }

    private void builtTree(TreeNode node,int val) {
        if(root == null)
            root = new TreeNode(val);
        else
        {
            if(val < node.val) {
                if(node.left == null)
                    node.left = new TreeNode(val);
                else
                    builtTree(node.left,val);
            } else {
                if(node.right == null)
                    node.right = new TreeNode(val);
                else
                    builtTree(node.right,val);
            }

        }
    }

    private void print(TreeNode node) {
        if(node!=null) {
            System.out.print(node.val+" ");
            print(node.left);
            print(node.right);
        }
    }
}
