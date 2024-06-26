package com.example.programs.dsa.search;

public class BinarySearch {
    public static void main(String[] arr){
        System.out.println(new BinarySearch().binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10},10));
    }


    public int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length;
        while(left<=right){
            int mid = left+(right-left)/2;

            if(arr[mid]==target){
                return mid;
            }
            if(target<arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }

        }
        return -1;

    }
}
