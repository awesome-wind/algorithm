package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/2/9 11:01
 */

public class LeetCode109 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCode109 leetCode109 = new LeetCode109();
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i = 0;i<length;i++)
            arr[i] = scanner.nextInt();

        ListNode head = leetCode109.builtList(arr);
        leetCode109.print(head);
        TreeNode root = leetCode109.builtAVLTree(head);
        leetCode109.printTree(root);
    }

    private ListNode builtList(int[] arr) {
        if(arr == null|| arr.length < 1)
            return null;
        ListNode head1 = new ListNode(0);
        ListNode head = head1;

        for(int i = 0;i<arr.length;i++)
        {
            ListNode node = new ListNode(arr[i]);
            head.next = node;
            head = head.next;
        }
        return head1.next;
    }

    private void print(ListNode head) {
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    private TreeNode builtAVLTree(ListNode head) {
        if(head == null)
            return null;
        ListNode head1 = head;
        List<Integer> list = new ArrayList<>();
        while(head1!=null){
            list.add(head1.val);
            head1 = head1.next;
        }

        int length = list.size();
        return SortedListToAVL(list,0,length-1);
    }

    private TreeNode SortedListToAVL(List<Integer> list,int start, int end) {
        if(start > end)
            return null;

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = SortedListToAVL(list,start,mid - 1);
        node.right = SortedListToAVL(list,mid+1,end);
        return node;

    }

    private void printTree(TreeNode node) {
        if(node != null) {
            System.out.print(node.val+" ");
            printTree(node.left);
            printTree(node.right);
        }
    }


}
