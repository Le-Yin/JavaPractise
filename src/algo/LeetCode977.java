package algo;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 * **/

public class LeetCode977 {
    public static void main(String[] args) {
        int[] input = {-4,-1,0,3,10};
        System.out.println(new LeetCode977().sortedSquares(input));
    }

    /*public int[] sortedSquares(int[] A) {//Java 8 version. Clean but slow.
        return Arrays.stream(A).map(i -> i*i).sorted().toArray();
    }*/

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i=0;
        int j=A.length-1;
        for(int t=A.length-1;t>=0;t--) {
            if(Math.abs(A[i]) < Math.abs(A[j])) {
                result[t] = A[j] * A[j];
                j--;
            } else {
                result[t] = A[i] * A[i];
                i++;
            }
        }
        return result;
    }
}
