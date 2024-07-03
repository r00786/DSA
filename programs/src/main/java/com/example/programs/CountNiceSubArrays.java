package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Example 5: 1248. Count Number of Nice Subarrays
 *
 * Given an array of positive integers nums and an integer k. Find the number of subarrays with exactly k odd numbers in them.
 *
 * For example, given nums = [1, 1, 2, 1, 1], k = 3, the answer is 2. The subarrays with 3 odd numbers in them are [1, 1, 2, 1, 1] and [1, 1, 2, 1, 1].
 *
 * In the previous example, the constraint metric was a sum, so we had curr record a prefix sum. In this problem, the constraint metric is odd number count. Therefore, let's have curr track the count of odd numbers. At every element, we can query curr - k again. In the example test case, at the final index, curr = 4 because there are 4 odd numbers in the array. At the first index, curr = 1. This means that the subarray starting after the first index until the last index has 4 - 1 = 3 = k odd numbers, and you can see that the subarray from index 1 to 4 is one of the answers ([1, 1, 2, 1, 1]).
 *
 * We can check if a number is odd by taking it mod 2. If x is odd, then x % 2 = 1.
 */

public class CountNiceSubArrays {
    public static void main(String[] arr){
        System.out.println(new CountNiceSubArrays().numberOfSubarrays(new int[]{1, 1, 2, 1, 1},3));
    }


    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int ans = 0;
        int curr = 0;

        for (int num: nums) {
            curr += num % 2;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
}
