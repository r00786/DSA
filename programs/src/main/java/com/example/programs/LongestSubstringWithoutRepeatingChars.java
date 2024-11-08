package com.example.programs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] arr){
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("abcabcbb"));
    }


        public int lengthOfLongestSubstring(String s) {
            Set<Character> set= new HashSet();
            int left=0;
            int ans=0;
            for(int right=0;right<s.length();right++){
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                ans=Math.max(ans,right-left+1);
            }
            return ans;

        }

}
