package algo;

import java.util.Arrays;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 * **/

public class LeetCode912 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        System.out.println(Arrays.toString(new LeetCode912().sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            System.out.println(String.format("sorting {%s} to {%s}", left, mid));
            sort(nums, left, mid);

            System.out.println(String.format("sorting {%s} to {%s}", mid + 1, right));
            sort(nums, mid + 1, right);

            System.out.println(String.format("merge {%s} to {%s} and {%s} to {%s}", left, mid, mid + 1, right));
            merge(nums, left, mid, mid + 1, right);

            System.out.println(String.format("result {%s} to {%s} and {%s} to {%s}: {%s}", left, mid, mid + 1, right, Arrays.toString(nums)));
        }
    }

    public void merge(int[] nums, int a, int b, int m, int n) {
        //nums1 is from index [a,b]; nums2 is from index [m,n];
        int i = a;//start of nums1
        int j = m; //start of nums2;
        int[] result = new int[n - a + 1];
        int p = 0;

        while (i <= b || j <= n) {
            if (i <= b && j <= n) {
                if (nums[i] <= nums[j]) {
                    result[p] = nums[i++];
                } else {
                    result[p] = nums[j++];
                }
            } else if (i > b)
                result[p] = nums[j++];
            else if (j > n)
                result[p] = nums[i++];

            p++;
        }

        p = 0;
        while (p < result.length) {
            nums[a++] = result[p++];
        }
    }

}
