package com.example.programs;


/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */

public class MinSubArrayLength {
    public static void main(String[] arr){
        System.out.println(new MinSubArrayLength().minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }


    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int currentSum=0;
        int minLength=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            currentSum+=nums[right];
            while(currentSum>=target){
                minLength= Math.min(minLength,right-left+1);
                currentSum-=nums[left];
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;

    }
}
