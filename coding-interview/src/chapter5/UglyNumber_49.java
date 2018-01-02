package chapter5;

import java.util.Scanner;

public class UglyNumber_49 {
    public static void main(String[] args) {
        UglyNumber_49 un = new UglyNumber_49();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr= un.getOrderedUglyNumber(n);
        if(arr == null)
            return ;

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private int[] getOrderedUglyNumber(int n) {
        if(n<=0)
            return null;

        int[] arr = new int[n];
        arr[0] = 1;

        int a2 = 1,a3 = 1,a5 = 1;
        for(int i=1;i<n;i++) {
            int num2 = a2*2;
            int num3 = a3*3;
            int num5 = a5*5;

            int num = Math.min(num2,num3);
            num = Math.min(num,num5);
            arr[i] = num;

            if(num == num2)
                a2++;
            if (num == num3)
                a3++;
            if(num == num5)
                a5++;
        }

        return arr;
    }

}
