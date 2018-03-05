package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/3/1 16:28
 */

public class LeetCode_78 {
    public static void main(String[] args) {
        LeetCode_78 leetCode = new LeetCode_78();
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i=0;i<arr.length;i++)
            arr[i] = scanner.nextInt();

        leetCode.subsets(arr);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            System.out.println(list.toString());
            tempList.remove(tempList.size() - 1);
        }
    }

}
