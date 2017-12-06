package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamMedian_41 {
    static int flag = 0;

    public static void main(String[] args) {
        StreamMedian_41 sm = new StreamMedian_41();
        List<Integer> maxList = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        while (m != -1) {
            sm.addIntoHeap(m, maxList, minList);
            m = sc.nextInt();
        }
    }

    private void addIntoHeap(int m, List<Integer> maxList, List<Integer> minList) {
        int temp;

        if (flag == 0) {
            if (maxList.isEmpty())
                maxList.add(m);
            else {
                if (m < minList.get(0)) {
                    maxList.add(m);
                } else {
                    temp = minList.get(0);
                    minList.set(0, m);
                    maxList.add(temp);
                }
            }
        } else {
            if (minList.isEmpty()) {
                System.out.println(maxList.size());
                if (m < maxList.get(0)) {
                    temp = maxList.get(0);
                    maxList.set(0, m);
                    minList.add(temp);
                } else {
                    minList.add(m);
                }
            } else {
                if (m > maxList.get(0))
                    minList.add(m);
                else {
                    temp = maxList.get(0);
                    maxList.set(0, m);
                    minList.add(temp);
                }
            }
        }
        builtMaxHeap(maxList);
        System.out.println("最大堆：");
        for (Integer ma : maxList)
            System.out.print(ma + " ");
        System.out.println();

        builtMinHeap(minList);
        System.out.println("最小堆：");
        for (Integer mi : minList)
            System.out.print(mi + " ");
        System.out.println();

        flag = 1 - flag;
        if(flag==0)
            System.out.println("avg="+((minList.get(0)+maxList.get(0))>>1));
        else
            System.out.println("avg="+maxList.get(0));
    }

    private void builtMaxHeap(List<Integer> maxList) {
        int max, left, right, temp;
        for (int i = (maxList.size() >> 1) - 1; i >= 0; i--) {
            max = i;
            left = (i << 1) + 1;
            right = (i + 1) << 1;

            if (maxList.get(max) < maxList.get(left))
                max = left;
            if (right < maxList.size() && maxList.get(max) < maxList.get(right))
                max = right;

            if (max != i) {
                temp = maxList.get(i);
                maxList.set(i, maxList.get(max));
                maxList.set(max, temp);

                adjustMaxHeap(maxList, max);
            }
        }
    }

    private void builtMinHeap(List<Integer> minList) {
        int min, left, right, temp;
        for (int i = (minList.size() >> 1) - 1; i >= 0; i--) {
            min = i;
            left = (i << 1) + 1;
            right = (i + 1) << 1;

            if (minList.get(min) > minList.get(left))
                min = left;
            if (right < minList.size() && minList.get(min) > minList.get(right))
                min = right;

            if (min != i) {
                temp = minList.get(i);
                minList.set(i, minList.get(min));
                minList.set(min, temp);

                adjustMinHeap(minList, min);
            }
        }
    }

    private void adjustMaxHeap(List<Integer> maxList, int index) {
        int max = index;
        int left = (index << 1) + 1;
        int right = (index + 1) << 1;

        if (left < maxList.size() && maxList.get(max) < maxList.get(left))
            max = left;
        if (right < maxList.size() && maxList.get(max) < maxList.get(right))
            max = right;

        if (max != index) {
            int temp = maxList.get(index);
            maxList.set(index, maxList.get(max));
            maxList.set(max, temp);

            adjustMaxHeap(maxList, max);
        }
    }

    private void adjustMinHeap(List<Integer> minList, int index) {
        int min = index;
        int left = (index << 1) + 1;
        int right = (index + 1) << 1;

        if (left < minList.size() && minList.get(min) > minList.get(left))
            min = left;
        if (right < minList.size() && minList.get(min) > minList.get(right))
            min = right;

        if (min != index) {
            int temp = minList.get(index);
            minList.set(index, minList.get(min));
            minList.set(min, temp);

            adjustMinHeap(minList, min);
        }
    }

}
