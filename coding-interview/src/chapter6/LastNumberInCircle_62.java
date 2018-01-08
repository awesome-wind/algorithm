package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/8 21:44
 */

public class LastNumberInCircle_62 {
    static class node {
        int val;
        node next;
        node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        LastNumberInCircle_62 lnc = new LastNumberInCircle_62();
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i = 0;i<length;i++)
            arr[i] = scanner.nextInt();

        node head = lnc.getNodeCircle(arr);
        int num = lnc.getLastNumber(k,head);
        System.out.println("the result is "+num);
    }

    private int getLastNumber(int k, node head) {
        node current = null;
        while(head.next != head)
        {
            for(int i = 0;i<k;i++) {
                if(head == head.next)
                    return head.val;
                current = head;
                head = head.next;
            }
            current.next = head.next;
            print(head);
        }
        return current.val;
    }

    private void print(node head) {
        for(int i = 0;i<20;i++) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    private node getNodeCircle(int[] arr) {
        node head = new node(arr[0]);
        node head1 = head;
        for(int i = 1;i<arr.length;i++)
        {
            head.next = new node(arr[i]);
            head = head.next;
        }
        head.next = head1;
        return head1;
    }
}
