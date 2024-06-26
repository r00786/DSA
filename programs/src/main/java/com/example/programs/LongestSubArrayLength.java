package com.example.programs;


public class LongestSubArrayLength {
    public static void main(String[] arr){
        System.out.println(new LongestSubArrayLength().findLength(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5},8));

    }

    public int findLength(int[] arr,int k){
        int left=0;
        int current=0;
        int answer=0;

        for(int right=0;right<arr.length;right++){
           current+=arr[right];
            while(current>k){
                current-=arr[left];
                left++;
            }
            answer=Math.max(right-left+1,answer);

        }
        return answer;
    }
}
