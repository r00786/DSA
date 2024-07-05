package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */

public class RansomNote {
    public static void main(String[] arr){
        System.out.println(new RansomNote().canConstruct("aa","aab"));
    }
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> magazineMap = new HashMap();
            for (int i = 0; i < magazine.length(); i++) {
                magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                if (magazineMap.containsKey(ransomNote.charAt(i))) {
                    int count = magazineMap.get(ransomNote.charAt(i));
                    if (count - 1 == 0) {
                        magazineMap.remove(ransomNote.charAt(i));
                    } else {
                        magazineMap.put(ransomNote.charAt(i), count - 1);
                    }

                } else {
                    return false;
                }

            }
            return true;


        }
}
