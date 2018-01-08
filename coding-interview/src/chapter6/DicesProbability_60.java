package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/4 21:47
 */

public class DicesProbability_60 {
    private static int  dice = 6;
    public static void main(String[] args) {
        DicesProbability_60 dp = new DicesProbability_60();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] probality = new int[number*dice+1];
        dp.getProbability(number,probality);
        for(int i = number;i<=number*dice;i++)
            System.out.print(probality[i] +" ");
    }

    private void getProbability(int number, int[] probality) {
        if(number <= 0)
            return ;

        for(int i=1;i<=dice;i++)
            getCount(number,number,i,probality);
    }

    private void getCount(int number, int current, int sum, int[] probality) {
        if(current == 1)
            probality[sum]++;
        else
            for(int i=1;i<=dice;i++)
                getCount(number,current-1,i+sum,probality);
    }
}
