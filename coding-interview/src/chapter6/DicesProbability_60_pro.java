package chapter6;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/8 20:08
 */

public class DicesProbability_60_pro {
    private static int dice = 6;
    public static void main(String[] args) {
        DicesProbability_60_pro dp = new DicesProbability_60_pro();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[][] probality = new int[2][number*dice+1];
        int[] result = dp.getProbability(number,probality);
        for(int i = number;i<=number*dice;i++)
            System.out.print(result[i] +" ");
    }

    private int[] getProbability(int number, int[][] probality) {
        int flag = 1;
        for(int i=1;i<=dice;i++)
            probality[0][i] = 1;

        for(int k = 2;k<=number;k++) {
            for(int i = k;i<=k*dice;i++) {
                probality[flag][i] = 0;
                for(int j=1;j<i&&j<=dice;j++)
                    probality[flag][i] += probality[1-flag][i-j];
            }
            flag = 1-flag;
        }

        return probality[1-flag];
    }


}
