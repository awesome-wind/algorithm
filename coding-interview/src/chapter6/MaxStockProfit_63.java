package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/9 20:08
 */

public class MaxStockProfit_63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i=0;i<length;i++)
            arr[i] = scanner.nextInt();

        int min = arr[0];
        int maxProfit = arr[1] - arr[0];
        int tempProfit = 0;
        for(int i = 2;i<length;i++) {
            if(arr[i - 1] < min)
                min = arr[i-1];
            tempProfit = arr[i] - min;
            if(tempProfit>maxProfit)
                maxProfit = tempProfit;
        }
        System.out.println("the max profit is "+maxProfit);
    }
}
