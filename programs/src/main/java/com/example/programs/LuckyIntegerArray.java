package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
 *
 * Return the largest lucky integer in the array. If there is no lucky integer return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 *
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 *
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class LuckyIntegerArray {
    public static void main(String[] arr){
        System.out.println(new LuckyIntegerArray().findLucky(new int[]{1,2,2,3,3,3}));
    }

    public int findLucky(int[] arr) {
        Map<Integer,Integer> frequencies=new HashMap();
        for(int num:arr){
            int frequency = frequencies.getOrDefault(num,0)+1;
            frequencies.put(num,frequency);
        }
        int maxLuckyNumber=-1;

        for(Map.Entry<Integer,Integer> entry:frequencies.entrySet()){
            if(entry.getValue()==entry.getKey()){
                maxLuckyNumber=Math.max(maxLuckyNumber,entry.getKey());
            }
        }
        return maxLuckyNumber;


    }
}
