package chapter6;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author James Wang
 * @Date 2018/1/3 20:17
 */

public class MaxInQueue_59 {
    public static void main(String[] args) throws InterruptedException {
        MaxInQueue_59 miq = new MaxInQueue_59();
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[length];
        for(int i=0;i<length;i++)
            arr[i] = scanner.nextInt();

//        List<Integer> list = miq.getMaxInQueue(arr, k);
//        Iterator it = list.iterator();
//        while(it.hasNext()) {
//            System.out.print(it.next()+" ");
//        }

        int result = miq.getMaxInQueuePro(arr,k);
        System.out.println(result);
    }

    private int getMaxInQueuePro(int[] arr, int k) throws InterruptedException {
        if(k<=0 || arr == null || arr.length == 0)
            return -1;

        BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<Integer>(k);
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0;i<arr.length;i++) {
            if(i>2) {
                int temp = bqueue.poll();
//                System.out.println("从队列中移除："+temp);
                if(temp == queue.element())
                    queue.poll();
            }

            bqueue.offer(arr[i]);
//            System.out.println("向阻塞元素中添加元素:"+arr[i]);

            if(i == 0)
                queue.offer(arr[i]);
            else
            {
                if(arr[i]>queue.peek()) {
                    queue.clear();
                    queue.offer(arr[i]);
                } else {
                    while(arr[i] > queue.getLast()) {
                        queue.pollLast();
                    }
                    queue.offer(arr[i]);
                }
            }

            Iterator it = queue.iterator();
            while(it.hasNext()) {
                System.out.print(it.next()+" ");
            }
            System.out.println();
        }
        return queue.peek();
    }

    private List<Integer> getMaxInQueue(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            max = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j]>max)
                    max = arr[j];
            }
            list.add(max);
        }
        return list;
    }
}
