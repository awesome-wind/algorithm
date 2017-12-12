package chapter5;

import java.util.Scanner;

public class TransferDigitsIntoString_46_recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        String numStr = String.valueOf(num);
        char[] ch = numStr.toCharArray();

        int result = transferIntoStr(ch, 0);
        System.out.println(result);
    }

    private static int transferIntoStr(char[] ch, int i) {
        if (ch.length == 0 || ch == null)
            return 0;

        if(i>ch.length)
            return 0;

        if (i == ch.length)
            return 1;
        else
            return transferIntoStr(ch, i + 1) + judge(ch, i + 1, i + 2) * transferIntoStr(ch, i + 2);
    }

    private static int judge(char[] ch, int i, int i1) {
        if(i1>=ch.length)
            return 0;

        int m = ch[i] - '0';
        int n = ch[i1] - '0';
        int num = m * 10 + n;
        if(num>=10 && num<=25)
            return 1;
        else
            return 0;
    }
}
