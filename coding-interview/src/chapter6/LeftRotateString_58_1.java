package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/2 22:32
 */

public class LeftRotateString_58_1 {
    public static void main(String[] args) {
        LeftRotateString_58_1 lrs = new LeftRotateString_58_1();
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        String inputStr = scanner.next();

        String result = lrs.getLeftRotateString(inputStr, k);
        System.out.println(result);
    }

    private String getLeftRotateString(String inputStr, int k) {
        if(inputStr == null || inputStr.length()<=0)
            return null;

        String str1 = inputStr.substring(0,k);
        String str2 = inputStr.substring(k);

        str1 = getReverse(str1);
        str2 = getReverse(str2);
        String result = str1 + str2;
        result = getReverse(result);
        return result;
    }

    private String getReverse(String str) {
        int length = str.length();
        char[] ch = new char[length];
        for(int i = length-1;i>=0;i--)
            ch[length-1-i] = str.charAt(i);

        return String.valueOf(ch);
    }
}
