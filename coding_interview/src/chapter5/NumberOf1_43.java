package chapter5;

import java.util.Scanner;

public class NumberOf1_43 {

    public static void main(String[] args) {
        NumberOf1_43 no1 = new NumberOf1_43();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = no1.NumberOf1Between1AndN(n);
        System.out.println(result);
    }

    private int NumberOf1Between1AndN(int n) {
        if (n <= 0)
            return 0;

        String num = Integer.toString(n);
        return NumberOf1(num, 0);
    }

    private int NumberOf1(String num, int index) {
        if (index == num.length() || num.charAt(index) < '0' || num.charAt(index) > '9')
            return 0;

        int first = num.charAt(index) - '0';
        int length = num.length()- index;

        if (length == 1 && first == 0)
            return 0;
        if (length == 1 && first > 0)
            return 1;

        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = (int) Math.pow(10, length - 1);
        else if (first == 1)
            numFirstDigit = Integer.parseInt(num.substring(index + 1))+1;

        int numOtherDigits = (int) (first * (length - 1) * Math.pow(10, length - 2));
        int numRecursive = NumberOf1(num,index+1);

        System.out.println(numFirstDigit+" " +numOtherDigits+" " +numRecursive);
        return numFirstDigit+numOtherDigits+numRecursive;
    }


}
