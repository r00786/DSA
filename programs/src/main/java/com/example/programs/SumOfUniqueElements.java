package com.example.programs;

import java.util.HashSet;
import java.util.Set;

public class SumOfUniqueElements {
    public static void main(String[] arr){
        System.out.println(new SumOfUniqueElements().sumOfUnique(new int[]{1,2,3,2}));
    }

        public int sumOfUnique(int[] nums) {
            Set<Integer> allElements = new HashSet();
            Set<Integer> duplicateElements = new HashSet();
            for(int num:nums){
                if(!allElements.add(num)){
                    duplicateElements.add(num);
                }
            }

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (duplicateElements.contains(nums[i])) {
                    sum -= nums[i];
                }
            }
            return sum;
        }

}
