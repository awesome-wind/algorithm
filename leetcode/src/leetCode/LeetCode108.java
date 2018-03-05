package leetCode;

import java.util.Scanner;

/**
 * @Author James Wang
 * @Date 2018/2/7 20:25
 */

public class LeetCode108 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCode108 leetCode108 = new LeetCode108();
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] arr = new int[length];
        for(int i = 0;i<length;i++)
            arr[i] = scanner.nextInt();

        TreeNode root = leetCode108.sortedArrayToAVL(arr);
    }

    private TreeNode sortedArrayToAVL(int[] nums){
        if(nums == null || nums.length <= 0)
            return null;

        return built(nums,0,nums.length-1);
    }

    private TreeNode built(int[] nums, int start, int end) {
        if(start<=end) {
            int mid = start+((end-start)>>1);
            TreeNode root = new TreeNode(nums[mid]);

            root.left = built(nums,start,mid-1);
            root.right = built(nums,mid+1,end);

            return root;
        }
        return null;
    }

}
