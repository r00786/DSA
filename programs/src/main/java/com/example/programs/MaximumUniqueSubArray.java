package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-erasure-value/description/
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
 *
 * Return the maximum score you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 *
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */

public class MaximumUniqueSubArray {

    public static void main(String[] arr){
        System.out.println(new MaximumUniqueSubArray().maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }


    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer,Integer> frequencies= new HashMap();
        int left=0;
        int maxSum=0;
        int currentSum=0;
        for(int right=0;right<nums.length;right++){
            currentSum+=nums[right];
            frequencies.put(nums[right], frequencies.getOrDefault(nums[right], 0) + 1);
            while (frequencies.get(nums[right])>1) {
                currentSum-=nums[left];
                int freq = frequencies.getOrDefault(nums[left], -1);
                if (freq != -1) {
                    if (freq - 1 == 0) {
                        frequencies.remove(nums[left]);
                    } else {
                        frequencies.put(nums[left], freq - 1);
                    }
                }
                left++;
            }
            maxSum=Math.max(currentSum,maxSum);

        }
        return maxSum;

    }
}
