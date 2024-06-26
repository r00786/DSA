package com.example.programs;

class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum=0;
        double maxAvg=0;
        for(int i=0;i<k;i++){
            currentSum+=nums[i];
        }
        maxAvg=currentSum/k;
        for(int right=k;right<nums.length;right++){
            currentSum+=nums[right];
            currentSum-=nums[right-k];
            maxAvg=Math.max(maxAvg,currentSum/k);
        }
        return maxAvg;
    }
}
