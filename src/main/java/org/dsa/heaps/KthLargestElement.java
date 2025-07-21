package org.dsa.heaps;

import java.util.PriorityQueue;

/**
 * LeetCode 215: Kth Largest Element in an Array (Medium)
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Problem Link</a>
 * This problem involves finding the k-th largest element in an unsorted array using a heap.
 * It can be solved using a min-heap of size k, where we maintain the k largest elements seen so far.
 * The top of the min-heap will be the k-th largest element once all elements have been processed.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        int i = 0;
        while (i < k) {
            q.offer(nums[i++]);
        }
        while (i < nums.length) {
            if (nums[i] >=  q.peek()) {
                q.poll();
                q.offer(nums[i]);
            }
            i++;
        }
        return q.peek();
    }
}
