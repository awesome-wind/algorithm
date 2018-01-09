package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/9 21:06
 */

public class ConstructArray_66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        for (int i = 0; i < length; i++)
            arr1[i] = i + 1;
        System.out.println(123);
        getTheResult(arr1, arr2);
        for (int i = 0; i < length; i++)
            System.out.print(arr2[i] + " ");
    }

    private static void getTheResult(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length != arr2.length || arr2.length < 1)
            return;
        System.out.println(123);
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++)
            arr2[i] = arr2[i - 1] * arr1[i - 1];

        for (int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");

        int temp = 1;
        for (int i = arr2.length - 2; i >= 0; i--) {
            temp *= arr1[i + 1];
            arr2[i] *= temp;
        }
    }
}
