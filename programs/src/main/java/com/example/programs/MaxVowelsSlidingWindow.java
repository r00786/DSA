package com.example.programs;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
public class MaxVowelsSlidingWindow {
    public static void main(String[] arr){
        System.out.println(new MaxVowelsSlidingWindow().maxVowels("abciiidef",3));
    }


    public int maxVowels(String s, int k) {
        int left=0;
        int currentVowels=0;
        int maxVowels=0;
        for(int right=0;right<s.length();right++){
            if(isVowel(s.charAt(right))){
                currentVowels++;
            }
            if(right>=k-1){
                maxVowels=Math.max(maxVowels,currentVowels);
                if(isVowel(s.charAt(left))){
                    currentVowels-=1;
                }
                left++;
            }

        }
        return maxVowels;
    }
    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
