package org.dsa.arraysandhash;

/**
 * LeetCode 53. Maximum Subarray (Medium)
 * <a href="https://leetcode.com/problems/maximum-subarray/">URL</a>
 * Kadane's Algorithm is used to find the maximum sum of a contiguous subarray in an array of integers.
 * It operates in O(n) time complexity, making it efficient for this problem.
 * The algorithm works by iterating through the array while maintaining a running sum of the current subarray.
 * If the running sum becomes negative, it is reset to zero, as a negative sum would not contribute positively to any future subarray.
 * The maximum sum encountered during the iteration is stored and returned as the result.
 */
public class KadaneAlgorithm {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            sum = Math.max(sum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return sum;
    }
}
