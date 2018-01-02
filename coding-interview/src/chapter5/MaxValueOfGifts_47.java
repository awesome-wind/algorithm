package chapter5;

import java.util.Scanner;

public class MaxValueOfGifts_47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int [][]arr = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();

        if(arr == null || arr.length == 0|| arr[0].length == 0)
            return ;

        int [][]result = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                result[i][j] = arr[i][j];

        if(result[0].length == 1) {
            for(int i=1;i<m;i++)
                result[i][0] += result[i-1][0];
        }
        else if(result.length == 1) {
            for(int j=1;j<n;j++)
                result[0][j] += result[0][j-1];
        }
        else
        {
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++) {
                    if(i==0 && j==0)
                        continue;

                    if(i == 0)
                        result[i][j] += result[i][j-1];
                    else if(j==0)
                        result[i][j] += result[i-1][j];
                    else
                        result[i][j] += Math.max(result[i-1][j],result[i][j-1]);
                    System.out.println(result[i][j]);
                }
        }


        System.out.println(result[m-1][n-1]);
    }
}
