package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/9 20:29
 */

public class AddTwoNumber_65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num = 0,carry = 0;
        do{
            num = num1^num2;
            carry = (num1&num2)<<1;
            num1 = num;
            num2 = carry;
        }while(num2!=0);
        System.out.println("结果为："+num);

    }
}
