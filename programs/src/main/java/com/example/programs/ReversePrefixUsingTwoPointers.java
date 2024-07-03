package com.example.programs;

/**
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
 *
 * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
 * Return the resulting string.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "abcdefd", ch = "d"
 * Output: "dcbaefd"
 * Explanation: The first occurrence of "d" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
 * Example 2:
 *
 * Input: word = "xyxzxe", ch = "z"
 * Output: "zxyxxe"
 * Explanation: The first and only occurrence of "z" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
 * Example 3:
 *
 * Input: word = "abcd", ch = "z"
 * Output: "abcd"
 * Explanation: "z" does not exist in word.
 * You should not do any reverse operation, the resulting string is "abcd".
 */
public class ReversePrefixUsingTwoPointers {
    public static void main(String[] arr){
        System.out.println(new ReversePrefixUsingTwoPointers().reversePrefix("abcdefd",'d'));
    }


    public String reversePrefix(String word, char ch) {
        StringBuilder reversedString= new StringBuilder(word);
        int right=-1;
        int left=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                right=i;
                break;
            }
        }
        if(right==-1){
            return word;
        }
        while (left < right) {
            // Swap the characters at the left and right pointers
            char temp = word.charAt(left);
            reversedString.setCharAt(left,word.charAt(right));
            reversedString.setCharAt(right,temp);
            // Move the pointers towards each other
            left++;
            right--;
        }


        return reversedString.toString();

    }
}
