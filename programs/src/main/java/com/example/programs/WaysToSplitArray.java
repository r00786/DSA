package com.example.programs;

/**
 * splitting array into to subarrays such that left subarray sum is greater than and equal to right
 * subarray and returning the ways in which it can be done
 */
public class WaysToSplitArray {
    public static void main(String[] arr){
        System.out.println(new WaysToSplitArray().waysToSplitArray(new int[]{10,4,-8,7}));
        System.out.println(new WaysToSplitArray().waysToSplitArray2(new int[]{10,4,-8,7}));


    }

    /**
     * O(n) space complexity
     * O(n) time complexity
     * @param nums
     * @return
     */
    public int waysToSplitArray(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int leftSum=nums[i];
            int rightSum = nums[nums.length-1]-nums[i];
            if(leftSum>=rightSum){
                ans++;
            }

        }
        return ans;
    }
    /**
     * O(1) space complexity
     * O(n) time complexity
     * @param nums
     * @return
     */
    public int waysToSplitArray2(int[] nums){
        int leftSection=0;
        int ans=0;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        for(int i=0;i<nums.length;i++){
            leftSection+=nums[i];
            int rightSection = total-leftSection;
            if(leftSection>=rightSection){
                ans++;
            }

        }
        return ans;
    }




}
