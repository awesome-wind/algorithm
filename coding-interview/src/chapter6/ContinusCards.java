package chapter6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/8 20:48
 */

public class ContinusCards {
    private static int cards = 5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[cards];
        for(int i = 0;i<cards;i++)
            arr[i] = scanner.nextInt();
        Arrays.sort(arr);

        int adapt = 0,interval = 0;
        for(int i = 0;i<4;i++) {
            if(arr[i] == 0)
                adapt ++;
            if(arr[i]!=0 && arr[i+1] == arr[i])
            {
                System.out.println("不是顺子");
                return ;
            }
            interval += arr[i+1] - arr[i] - 1;
        }

        if(interval<=adapt)
            System.out.println("是顺子");
        else
            System.out.println("不是顺子");
    }
}
