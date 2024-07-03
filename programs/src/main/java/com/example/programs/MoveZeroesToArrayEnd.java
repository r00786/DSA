package com.example.programs;

import java.util.Arrays;

public class MoveZeroesToArrayEnd {
    public static void main(String[] arr){
        System.out.println(Arrays.toString(new MoveZeroesToArrayEnd().moveZeroes(new int[]{0,1,0,3,12})));
    }


        public int[] moveZeroes(int[] nums) {
            int j=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    nums[j]=nums[i];
                    j++;
                }

            }
            for(int i=j;i<nums.length;i++){
                nums[i]=0;
            }
            return nums;

        }

}
