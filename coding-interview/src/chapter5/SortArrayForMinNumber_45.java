package chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class StrComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        System.out.println(o2.compareTo(o1));
        return o2.compareTo(o1);
    }
}

public class SortArrayForMinNumber_45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        String []str = new String[n];
        for (int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        for (int i=0;i<n;i++)
            str[i] = String.valueOf(arr[i]);
        /**
         * 默认为升序
         */
        Arrays.sort(str,new StrComparator());
        for(int i=0;i<n;i++)
            System.out.print(str[i]);
    }

}
