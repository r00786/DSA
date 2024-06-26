package com.example.programs;

class MaxConsecutivesOne {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int zeroCount=0;
        int maxLength=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeroCount+=1;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount-=1;
                }
                left++;

            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;

    }
}