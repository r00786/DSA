package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,3,9,4,9,8,3,1]
 * Output: 8
 * Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.
 * Example 2:
 *
 * Input: nums = [9,9,8,8]
 * Output: -1
 * Explanation: There is no number that occurs only once.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 1000
 */
public class LargestUniqueNumber {
    public static void main(String[] arr){
        System.out.println(new LargestUniqueNumber().largestUniqueNumber(new int[]{5,7,3,9,4,9,8,3,1}));
    }

        public int largestUniqueNumber(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap();
            int maxValue = -1;
            for (int i = 0; i < nums.length; i++) {
                countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) {
                    maxValue = Math.max(maxValue, entry.getKey());
                }
            }

            return maxValue;
        }
}
