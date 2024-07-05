package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * Example 2:
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 */

public class NumArrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> currentSumMap= new HashMap();
        int currentSum=0;
        int totalCount=0;
        for(int num:nums){
            currentSum+=num;
            if(goal==currentSum){
                totalCount++;
            }
            if(currentSumMap.containsKey(currentSum-goal)){
                totalCount+=currentSumMap.get(currentSum-goal);
            }
            currentSumMap.put(currentSum,currentSumMap.getOrDefault(currentSum,0)+1);

        }
        return totalCount;

    }
}
