package com.example.programs;

import java.util.Arrays;

public class KRadiusSubArray {

    public int[] getAverages(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        int[] ans= new int[nums.length];
        Arrays.fill(ans,-1);
        prefix[0]=nums[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=k;i<(nums.length-k);i++){
            int x=i-k;
            int y=i+k;
            long currentSum = prefix[y]-prefix[x]+nums[x];
            ans[i]=(int)(currentSum/(2*k+1));
        }
        return ans;
    }

}
