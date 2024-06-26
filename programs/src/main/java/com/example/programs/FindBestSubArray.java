package com.example.programs;

public class FindBestSubArray {
    public static void main(String[] arr){
        System.out.println(new FindBestSubArray().findBestSubArray(new int[]{3,-1,4,12,-8,56},4));
        System.out.println(new FindBestSubArray().findBestSubarray2(new int[]{3,-1,4,12,-8,56},4));

    }

    public int findBestSubarray2(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    public int findBestSubArray(int[] arr,int k){
        int left=0;
        int currSum=0;
        int answer=0;
        for(int right=0;right<arr.length;right++){
            currSum+=arr[right];
            if((right-left+1)==k){
                answer=Math.max(currSum,answer);
                currSum-=arr[left];
                left++;
            }
        }
        return answer;
    }
}
