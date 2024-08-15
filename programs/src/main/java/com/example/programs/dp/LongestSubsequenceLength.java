package com.example.programs.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestSubsequenceLength {


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        List<Integer> tails = new ArrayList<>();
        // {10, 9, 2, 5, 3, 7, 101, 18};
        for (int num : nums) {
            // Binary search to find the insertion point
            int left = 0, right = tails.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Replace or append
            if (left < tails.size()) {
                tails.set(left, num);
            } else {
                tails.add(num);
            }
        }

        return tails.size();
    }

    public static void main(String[] args) {
        LongestSubsequenceLength lis = new LongestSubsequenceLength();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lis.lengthOfLIS(nums)); // Output should be 4
    }
}
