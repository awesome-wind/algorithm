package chapter6;

import java.util.Scanner;

public class NumberOfK_53 {
    public static void main(String[] arg){
        NumberOfK_53 nfk = new NumberOfK_53();
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int begin = nfk.getFirstK(arr,k,0,n-1);
        int end = nfk.getLastK(arr,k,0,n-1);
        int count = end-begin+1;
        System.out.println(count);
    }



    private int getFirstK(int[] arr, int k,int begin,int end) {
        int middle = (end+begin)/2;
        if(arr[middle] == k) {
            if(middle == 0 || (middle>1&&arr[middle-1] != k))
                return middle;
            else
                end = middle-1;
        }
        else if(arr[middle] > k)
            end = middle-1;
        else
            begin = middle +1;
        System.out.println(begin+" "+middle+" "+end);
        return getFirstK(arr,k,begin,end);
    }

    private int getLastK(int[] arr, int k, int begin, int end) {
        int middle = (end+begin)/2;
        if(arr[middle] == k) {
            if(middle == arr.length-1 || (middle<arr.length-1&&arr[middle+1] != k))
                return middle;
            else
                begin = middle+1;
        }
        else if(arr[middle] > k)
            end = middle-1;
        else
            begin = middle +1;
        return getLastK(arr,k,begin,end);
    }

}
