package chapter6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TwoNumSumIsK_57 {
    public static void main(String[] args) {
        TwoNumSumIsK_57 tnsi = new TwoNumSumIsK_57();
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for(int i=0;i<length;i++)
            arr[i] = scanner.nextInt();

        List<List<Integer>> list = tnsi.getSumIsK(arr,k);

        Iterator it = list.iterator();
        while(it.hasNext()) {
            List<Integer> numPair = (List<Integer>) it.next();
            Iterator pair = numPair.iterator();
            while(pair.hasNext()){
                System.out.print(pair.next()+" ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> getSumIsK(int[] arr,int k) {
        int low = 0,high = arr.length-1;
        List<List<Integer>> list = new ArrayList<>();
        while(low<=high) {
            if((arr[low]+arr[high]) == k) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(arr[low]);
                tempList.add(arr[high]);
//                System.out.println(arr[low]+" "+arr[high]);
                list.add(new ArrayList<>(tempList));

                low++;high--;
            }
            else if((arr[low]+arr[high]) > k)
                high--;
            else
                low++;

//            System.out.println(low +" "+high);
        }
        return list;
    }
}
