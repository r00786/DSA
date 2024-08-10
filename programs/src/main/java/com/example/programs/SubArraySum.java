package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubArraySum {


    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> counts= new HashMap();
        counts.put(0,1);
        int ans=0;
        int sum=0;
        for(int num:nums){
            sum+=num;
            ans+=counts.getOrDefault(sum-k,0);
            counts.put(sum,counts.getOrDefault(sum,0)+1);
        }
        return ans;

    }
}
