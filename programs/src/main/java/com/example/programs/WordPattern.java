package com.example.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * url - https://leetcode.com/problems/word-pattern/description/
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */
public class WordPattern {
    public static void main(String[] arr){
        System.out.println(new WordPattern().wordPattern("abba","dog cat cat dog"));
    }


    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapping = new HashMap();
        Set<String> valueSet = new HashSet();
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length)
            return false;
        for (int i = 0; i < arr.length; i++) {
            if (!mapping.containsKey(pattern.charAt(i))) {
                if (valueSet.contains(arr[i])) {
                    return false;
                }
                mapping.put(pattern.charAt(i), arr[i]);
                valueSet.add(arr[i]);
            }

            if (!mapping.get(pattern.charAt(i)).equals(arr[i])) {
                return false;
            }
        }
        return true;

    }
}
