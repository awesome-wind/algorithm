package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/2 21:55
 */

public class ReverseWordInString_58 {
    public static void main(String[] args) {
        ReverseWordInString_58 rwi = new ReverseWordInString_58();
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        rwi.getReverse(str);
    }

    private void getReverse(String str) {
        if (str == null || str.length() == 0)
            return;

        String getStrReverse = reverseStr(str);
//        System.out.println(getStrReverse);
        String[] getWords = getStrReverse.split(" ");
        String result = "";
        for (int i = 0; i < getWords.length; i++) {
            if (i != getWords.length - 1)
                result += reverseStr(getWords[i]) + " ";
            else
                result += reverseStr(getWords[i]);
        }
        System.out.println(result);
    }

    private String reverseStr(String str) {
        int length = str.length();
        char[] ch = new char[length];
        for (int i = length - 1; i >= 0; i--)
            ch[length - 1 - i] = str.charAt(i);

        String chStr = String.valueOf(ch);
//        String chStr1 = new String(ch);
//        System.out.println(chStr);

        return chStr;
    }
}
