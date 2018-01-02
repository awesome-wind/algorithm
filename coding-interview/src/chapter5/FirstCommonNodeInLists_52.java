package chapter5;

import java.util.Scanner;

public class FirstCommonNodeInLists_52 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FirstCommonNodeInLists_52 fcnl = new FirstCommonNodeInLists_52();
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for (int i = 0; i < m; i++)
            arr1[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();

        ListNode head1 = fcnl.builtList(arr1);
        ListNode head2 = fcnl.builtList(arr2);
        print(head1);
        print(head2);

        fcnl.LinkH1AndH2(head1, head2);
        print(head1); //5 4 3 2 1
        print(head2); //9 8 7 6 2 1

        fcnl.getFirstCommonNode(head1, head2);
    }

    private void getFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return;

        ListNode h1 = head1, h2 = head2;
        int i1 = 0, i2 = 0;
        while (head1 != null) {
            i1++;
            head1 = head1.next;
        }

        while (head2 != null) {
            i2++;
            head2 = head2.next;
        }

        if (i1 - i2 > 0) {
            int num = i1 - i2;
            for (int i = 0; i < num; i++)
                h1 = h1.next;
        } else {
            int num = i2 - i1;
            for (int i = 0; i < num; i++)
                h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                h1 = h1.next;
                h2 = h2.next;
            }
            else
            {
                System.out.println(h1.val);
                break;
            }
        }

    }

    private void LinkH1AndH2(ListNode head1, ListNode head2) {
        for (int i = 0; i < 3; i++) {
            head1 = head1.next;
            head2 = head2.next;
        }

        head2.next = head1;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private ListNode builtList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode head = new ListNode(0);
        ListNode head1 = head;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }

        return head1.next;
    }
}
