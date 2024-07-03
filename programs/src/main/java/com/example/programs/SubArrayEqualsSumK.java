package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 4: 560. Subarray Sum Equals K
 *
 * Given an integer array nums and an integer k, find the number of subarrays whose sum is equal to k.
 *
 * Let's walk through an example to see why the algorithm described above works for this problem. Let's say we have nums = [1, 2, 1, 2, 1], k = 3. There are four subarrays with sum 3 - [1, 2] twice and [2, 1] twice.
 *
 * The prefix sum for this input, which is what curr represents during iteration, is [1, 3, 4, 6, 7]. You can see that there are three differences in this array of 3:   (4 - 1), (6 - 3), (7 - 4).
 *
 * But we said that there are four valid subarrays? Recall that we need to initialize our hash map with 0: 1, considering the empty prefix. This is because if there is a prefix with a sum equal to k, then without initializing 0: 1, curr - k = 0 wouldn't show up in the hash map and we would "lose" this valid subarray.
 *
 * So at indices 1, 2, 3, and 4, we find curr - k has been seen prior. The elements are all positive so each value of curr - k only showed up once, and hence our answer is 4.
 */

public class SubArrayEqualsSumK {
    public static void main(String[] arr){
        System.out.println(new SubArrayEqualsSumK().subarraySum(new int[]{1, 2, 1, 2, 1},3));
    }


    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumMap= new HashMap<>();
        prefixSumMap.put(0,1);
        int curr=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            ans+=prefixSumMap.getOrDefault(curr-k,0);
            prefixSumMap.put(curr,prefixSumMap.getOrDefault(curr,0)+1);
        }
        return ans;
    }
}
