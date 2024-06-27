package com.example.programs;

/**
 * add such startValue to array such that the array sum at any point will not be negative
 * at any point
 */
public class MinimumPositiveValue {

        public int minStartValue(int[] nums) {
            int currentSum=0;
            int minSum=Integer.MAX_VALUE;

            for(int num:nums){
                currentSum+=num;
                minSum=Math.min(minSum,currentSum);

            }
            return minSum<0?1-minSum:1;

        }
}
