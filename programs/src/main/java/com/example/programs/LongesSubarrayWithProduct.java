package com.example.programs;

public class LongesSubarrayWithProduct {
    public static void main(String[] arr){
        System.out.println(new LongesSubarrayWithProduct().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6},100));

    }
    public int numSubarrayProductLessThanK(int[] arr,int k){
        if(k<=1){
            return 0;
        }
        int current=1;
        int left=0;
        int answer=0;
        for(int right=0;right<arr.length;right++){
            current*=arr[right];
            while(current>=k){
                current/=arr[left];
                left++;
            }
          answer+=(right-left+1);
        }
        return answer;

    }
}
