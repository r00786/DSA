package com.example.programs;

public class RotateArray {

    public static void main(String[] arr) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7},3);

    }

    public void rotate(int[] nums, int k) {
         int[] newarr= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            newarr[(i+k)%nums.length]= nums[i];
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(newarr[i]+",");
        }

    }

}
