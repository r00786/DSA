package com.example.programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 104
 * text consists of lower case English letters only.
 */

public class MaxNumberOfBalloons {
    public static void main(String[] arr){
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("loonbalxballpoon"));
    }

    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> countMap= new HashMap();
        int wordCount=Integer.MAX_VALUE;
        for(char c:text.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        for(char c2:"balon".toCharArray()){
            if(!countMap.containsKey(c2) || countMap.getOrDefault('l',0)<2 || countMap.getOrDefault('o',0)<2){
                wordCount=0;
                break;
            }
            int c3= c2=='l'||c2=='o'?countMap.get(c2)/2:countMap.get(c2);
            wordCount=Math.min(wordCount,c3);
        }
        return wordCount;

    }
}
