package com.example.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example 2: 2248. Intersection of Multiple Arrays
 *
 * Given a 2D array nums that contains n arrays of distinct integers, return a sorted array containing all the numbers that appear in all n arrays.
 *
 * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]], return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
 */
public class IntersectionMultipleArrays {
    public static void main(String[] arr){
        System.out.println(new IntersectionMultipleArrays().intersection(new int[][]{
                {3,1,2,4,5},{1,2,3,4},{3,4,5,6}
        }));
    }


    public List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        List<Integer> intersectionList= new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()== nums.length){
                intersectionList.add(entry.getKey());
            }
        }
        Collections.sort(intersectionList);
        return  intersectionList;
    }
}
