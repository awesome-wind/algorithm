package chapter6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/1/2 21:19
 */

public class ContinusSequenceSumIsK_57_1 {
    public static void main(String[] args) {
        ContinusSequenceSumIsK_57_1 cssk = new ContinusSequenceSumIsK_57_1();
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int length = (K >> 1) + 1;
        int[] arr = new int[length];
        for (int i = 1; i <= length; i++)
            arr[i - 1] = i;

        List<List<Integer>> list = cssk.getTheSequence(arr, K);

        Iterator itList = list.iterator();
        while (itList.hasNext()) {
            List<Integer> numPair = (List<Integer>) itList.next();
            Iterator it = numPair.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + "  ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> getTheSequence(int[] arr, int k) {
        List<List<Integer>> list = new ArrayList<>();

        if (arr.length <= 1) {
            System.out.println("the length is illegal");
            return null;
        }

        int low = 0, high = 1,sum = 0;
        while (high < arr.length) {
            sum = 0;
            for(int i=low;i<=high;i++)
                sum+=arr[i];

            if (sum == k) {
                List<Integer> tempList = new ArrayList<Integer>();
                for (int j = low; j <= high; j++)
                    tempList.add(arr[j]);
                list.add(new ArrayList<>(tempList));
                low++;
                high++;
            } else if (sum > k && low < high)
                low++;
            else
                high++;
        }
        return list;
    }


}
