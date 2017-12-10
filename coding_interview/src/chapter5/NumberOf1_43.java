package chapter5;

import java.util.Scanner;

public class NumberOf1_43 {

    public static void main(String[] args) {
        NumberOf1_43 no = new NumberOf1_43();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String num = String.valueOf(n);
        int result = NumberOf1(num, 0);
        System.out.println(result);
    }

    private static int NumberOf1(String num, int index) {
        if (num == null || num.length() == 0 || index < 0)
            return 0;

        int length = num.length() - index;

        if (length == 1 && num.charAt(index) == 0)
            return 0;
        if (length == 1 && num.charAt(index) > 0)
            return 1;

        int first = num.charAt(index) - '0';
        System.out.println(first);
        int firstNumbers = 0, otherNumbers, recursiveNumbers;
        if (first > 1)
            firstNumbers = (int) Math.pow(10, (length - 1));
        else if (first == 1)
            firstNumbers = Integer.parseInt(num.substring(index + 1)) + 1;

        otherNumbers = (int) (first * (length - 1) * Math.pow(10, (length - 2)));
        recursiveNumbers = NumberOf1(num, index + 1);
        System.out.println(firstNumbers + " " + otherNumbers + " " + recursiveNumbers);

        return firstNumbers + otherNumbers + recursiveNumbers;
    }


}
