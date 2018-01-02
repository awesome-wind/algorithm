package chapter6;

import java.util.Scanner;

public class NumberAppearOnce_56 {
    public static void main(String[] args) {
        NumberAppearOnce_56 nao = new NumberAppearOnce_56();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++)
            arr[i] = scanner.nextInt();

//        int num = nao.getOne(arr);
        int num1 = 0, num2 = 0;
        int indexBit = nao.divideIntoTwoArr(arr);
        for(int i=0;i<arr.length;i++) {
            if(nao.isBit(arr[i],indexBit))
                num1^=arr[i];
            else
                num2^=arr[i];
        }
        System.out.println("num1="+num1+" num2="+num2);
    }

    private boolean isBit(int num, int indexBit) {
        num = num>>indexBit;
        if((num & 1) == 1)
            return true;
        else
            return false;
    }


    private int divideIntoTwoArr(int[] arr) {
        int num = 0;
        for(int i=0;i<arr.length;i++)
            num ^= arr[i];

        int indexBit = 0;
        while((num&1) == 0&& indexBit< Integer.SIZE){
            num = num>>1;
            ++indexBit;
        }
        return indexBit;
    }


    private int getOne(int[] arr) {
        int number = 0;
        for(int i=0;i<arr.length;i++){
            number^=arr[i];
        }
        return number;
    }
}
