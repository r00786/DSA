package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */

public class FrequencySort {
    public static void main(String[] arr){
        System.out.println(new FrequencySort().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character,Integer> frequencies = new HashMap();
        int maxFrequency=0;
        for(char str:s.toCharArray()){
            int frequency=frequencies.getOrDefault(str,0)+1;
            frequencies.put(str,frequency);
            maxFrequency=Math.max(maxFrequency,frequency);
        }
        StringBuilder sb= new StringBuilder();
        while(maxFrequency>0){
            for(Map.Entry<Character,Integer> entry:frequencies.entrySet()){
                if(entry.getValue()==maxFrequency){
                    sb.append(String.valueOf(entry.getKey()).repeat(maxFrequency));
                }

            }
            maxFrequency--;

        }
        return sb.toString();

    }
}
