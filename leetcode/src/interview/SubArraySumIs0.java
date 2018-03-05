package interview;

import java.util.*;

/**
 * @Author James Wang
 * @Date 2018/3/5 19:33
 */

public class SubArraySumIs0 {
    /**
     * @Date: 2018/3/5 21:19
     * @Context:  向一个map中存数组数据，如果某两次的和一样，那么两值区间的和便为0
     * [-3,1,2,-3,4]那么返回的就是[0,2]或者[1,3]
     */
    public static void main(String[] args) {
        SubArraySumIs0 subarry = new SubArraySumIs0();
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i = 0;i<arr.length;i++)
            arr[i] = scanner.nextInt();

        List<List<Integer>> list = subarry.findTheSubArr(arr);
        System.out.println(list.toString());
    }

    private List<List<Integer>> findTheSubArr(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return list;
        HashMap<Integer,int[]> map = new HashMap<>();
        map.put(0,new int[]{-1});
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum += arr[i];
            int[] value = map.get(sum);
            if(value==null){
                value = new int[]{i};
                map.put(sum,value);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(value[0]+1);
                tempList.add(i);
                list.add(new ArrayList<>(tempList));
            }
        }
        return list;
    }


}
