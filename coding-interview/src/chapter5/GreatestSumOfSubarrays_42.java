package chapter5;

import java.util.Scanner;

public class GreatestSumOfSubarrays_42 {

    public static void main(String[] args) {
        GreatestSumOfSubarrays_42 gss = new GreatestSumOfSubarrays_42();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        gss.findGreatestSubarrsys(arr);
    }

    private void findGreatestSubarrsys(int[] arr) {
        //空引用与空数组判断
        if(arr == null || arr.length ==0)
            return ;
        int sum = 0;
        int Maxsum = 0;

        for(int i=0;i<arr.length;i++) {

            if(sum<=0)
                sum = arr[i];
            else
                sum+=arr[i];

            if(sum>Maxsum)
                Maxsum = sum;
        }
        System.out.println("最大的子数组和："+Maxsum);
    }
}
