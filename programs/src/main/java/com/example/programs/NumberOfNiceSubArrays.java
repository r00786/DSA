package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */

public class NumberOfNiceSubArrays {


    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> counts= new HashMap();
        counts.put(0,1);
        int ans=0;
        int sum=0;
        for(int num:nums){
            sum+=num%2;
            ans+=counts.getOrDefault(sum-k,0);
            counts.put(sum,counts.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
