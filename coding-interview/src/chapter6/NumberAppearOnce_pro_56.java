package chapter6;

import java.util.Scanner;

public class NumberAppearOnce_pro_56 {
    public static void main(String[] args) {
        NumberAppearOnce_pro_56 naop = new NumberAppearOnce_pro_56();
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = scanner.nextInt();

        int num = naop.findTheOne(arr);
    }

    private int findTheOne(int[] arr) {
        int[] bit = new int[32];
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            int bitindex = 1;
            for (int j = 31; j >= 0; j--) {
                num = arr[i] & bitindex;
                if (num != 0)
                    bit[j] += 1;
                bitindex = bitindex << 1;
            }
        }

        for(int i=0;i<32;i++)
            System.out.print(bit[i]+" ");

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bit[i] % 3;
        }
        System.out.println();
        System.out.println(result);
        return result;
    }
}
