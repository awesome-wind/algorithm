package chapter5;

import java.util.Scanner;

public class InversePairs_51 {
    public static void main(String[] args) {
        InversePairs_51 ip = new InversePairs_51();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int num = ip.findInversePairs(arr);
        System.out.println("逆序对的个数为："+num);
    }

    private int findInversePairs(int[] arr) {
        if(arr == null || arr.length<=0)
            return 0;

        int[] copy = new int[arr.length];
        copy = arr.clone();

        int count = InversePairsCore(arr,copy,0,arr.length-1);
        return count;
    }

    private int InversePairsCore(int[] arr, int[] copy, int start, int end) {
        if(start == end) {
            copy[start] = arr[start];
            return 0;
        }

        int length = (end - start)>>1;
        int left = InversePairsCore(copy,arr,start,start+length);
        int right = InversePairsCore(copy,arr,start+length+1,end);

        int i = start+length;    //前半段最后一个数字的下标
        int j = end;             //后半段最后一个数字的下标
        int indexCopy  = end;
        int count = 0;
        while(i>=start && j>=start+length+1) {
            if(arr[i] > arr[j]) {
                copy[indexCopy--] = arr[i--];
                count+=j-start-length;
            }
            else
            {
                copy[indexCopy--] = arr[j--];
            }

        }

        for(;i>=start;i--)
            copy[indexCopy--] = arr[i];
        for(;j>=start+length+1;j--)
            copy[indexCopy--] = arr[j];

        return left+right+count;
    }


}
