package com.example.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

public class GoodPairsSum {
    public static void main(String[] arr){
        System.out.println(new GoodPairsSum().numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, List<Integer>> pairs= new HashMap();
        int goodPairsSum=0;
        for(int i=0;i<nums.length;i++){
            if(!pairs.containsKey(nums[i])){
                pairs.put(nums[i],new ArrayList());
            }
            pairs.get(nums[i]).add(i);
        }
        for(Map.Entry<Integer,List<Integer>> entry:pairs.entrySet()){
            int n=entry.getValue().size();
            goodPairsSum+=(n*(n-1))/2;
        }
        return goodPairsSum;

    }
}
