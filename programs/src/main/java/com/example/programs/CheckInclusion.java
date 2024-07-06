package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */

public class CheckInclusion {
    public static void main(String[] arr){
        System.out.println(new CheckInclusion().checkInclusion("hello","ooolleoooleh"));
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> frequencies= new HashMap();
        Map<Character,Integer> frequencies1= new HashMap();
        for(Character c:s1.toCharArray()){
            frequencies1.put(c,frequencies1.getOrDefault(c,0)+1);
        }

        int left=0;
        int windowSize=s1.length()-1;
        for(int right=0;right<s2.length();right++){
            frequencies.put(s2.charAt(right), frequencies.getOrDefault(s2.charAt(right), 0) + 1);
            while(right-left>windowSize){
                int freq = frequencies.getOrDefault(s2.charAt(left), -1);
                if (freq != -1) {
                    if (freq - 1 == 0) {
                        frequencies.remove(s2.charAt(left));
                    } else {
                        frequencies.put(s2.charAt(left), freq - 1);
                    }
                }
                left++;
            }
            if(matches(frequencies1,frequencies)){
                return true;
            }

        }
        return false;

    }

    public boolean matches(Map<Character, Integer> s1map, Map<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
                return false;
        }
        return true;
    }
}
