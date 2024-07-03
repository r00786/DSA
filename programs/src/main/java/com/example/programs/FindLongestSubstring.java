package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1: You are given a string s and an integer k. Find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece".
 */
public class FindLongestSubstring {
    public static void main(String[] arr){
        System.out.println(new FindLongestSubstring().findLongestSubstring("eceba",2));
    }

    public int findLongestSubstring(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while (counts.size() > k) {
                char remove = s.charAt(left);
                counts.put(remove, counts.getOrDefault(remove, 0) - 1);
                if (counts.get(remove) == 0) {
                    counts.remove(remove);
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
