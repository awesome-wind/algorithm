package chapter5;

import java.util.Scanner;

public class DigitInSequence_44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(k<=0 || n<=0)
            return ;
        String str="";
        for(int i=0;i<n;i++)
            str+=i;

        int i=1,temp,m;
        temp = k;
        int zone = (int) (k - Math.pow(10,1));

        while(zone>0) {
            i++;
            temp = zone;
            zone = (int) (zone - (Math.pow(10,i)-Math.pow(10,i-1))*i);
        }

        if(temp == k)
            m = temp - 1;
        else
            m = (int) (temp/i+Math.pow(10,i-1));
        int index = temp%i;
        String num = String.valueOf(m);
        System.out.println(num.charAt(index));

    }
}
