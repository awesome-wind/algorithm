package chapter6;

import java.util.Scanner;

public class KthNodeInBST_54 {
    class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }
    }

    private static Tree root = null;
    private static int K;

    public static void main(String[] args) {
        KthNodeInBST_54 knt = new KthNodeInBST_54();
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        K = k;
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            knt.builtBinaryTree(arr[i], root);

        knt.prePrint(root);

        Tree target = knt.findKthNode(root);
        if(target != null)
            System.out.println(target.val);
        else
            System.out.println("null");
    }

    private void builtBinaryTree(int value, Tree node) {
        if (root == null)
            root = new Tree(value);
        else {
            if (value < node.val) {
                if (node.left == null)
                    node.left = new Tree(value);
                else
                    builtBinaryTree(value, node.left);
            } else {
                if (node.right == null)
                    node.right = new Tree(value);
                else
                    builtBinaryTree(value, node.right);
            }
        }
    }

    private void prePrint(Tree node) {
        if (node != null) {
            System.out.print(node.val + " ");
            prePrint(node.left);
            prePrint(node.right);
        }
    }

    private Tree findKthNode(Tree node) {

        Tree target = null;

        if(node.left != null)
            target = findKthNode(node.left);


        if(target == null) {
            if(K == 1)
                target = node;

            K--;
        }

        if(target == null && node.right != null)
            target = findKthNode(node.right);

        return target;
    }

}
