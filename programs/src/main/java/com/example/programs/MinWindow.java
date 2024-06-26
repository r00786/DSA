package com.example.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow {
    public static void main(String[] args) {
       System.out.println("CheckIfInMinwindow "+new MinWindow().minWindow("ADOBECODEBANC","ABC"));
    }
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int startIndex=0;
        int minLength=Integer.MAX_VALUE;
        int count =map.size();
        for(int left=0, right=0;right<s.length();right++){
            char rightCar= s.charAt(right);
            //traversing and setting count to 0 till
            // we find all the characters
            if(map.containsKey(rightCar)){
                map.put(rightCar, map.get(rightCar) - 1);
                if(map.get(rightCar)==0){
                    count-=1;
                }
            }
            while (count<=0){
                char leftChar=s.charAt(left);
                //if the character is found  in the string then adding it in the map
                // so that the window is made small and we can find the smallest window possible
                //in which all the characters of t are found it is done so as to denote in the map
                //that characters are not present in the window which we removed from the map above
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)>=1){
                        count+=1;
                    }
                }
                //calculate the and set the startIndex in which the substring is found
                // and set the min length so that you can substring the string and return it
                //after wards
                if(right-left+1<minLength){
                    startIndex=left;
                    minLength=right-left+1;
                }
                left++;
            }

        }
        return minLength==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLength);
    }
}