package com.example.programs;

import java.util.ArrayList;
import java.util.List;

public class ReverseStringWithWordsOrder {
    public static void main(String[] arr){
        System.out.println(new ReverseStringWithWordsOrder().reverseWords("sunita      is a bad girl"));
    }



        public String reverseWords(String s) {
            String word = "";
            StringBuilder reversedString = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) == ' ' || i == s.length() - 1)) {
                    if (i == s.length() - 1) {
                        word += s.charAt(i) + "";
                    } else if (word.isEmpty()) {
                        reversedString.append(' ');
                        continue;
                    }
                    int left = 0;
                    int right = word.length() - 1;

                    StringBuilder reverseWord = new StringBuilder(word);

                    while (left < right) {
                        reverseWord.setCharAt(left, word.charAt(right));
                        reverseWord.setCharAt(right, word.charAt(left));
                        left++;
                        right--;
                    }
                    reversedString.append(reverseWord);
                    if (s.charAt(i) == ' ') {
                        reversedString.append(' ');
                    }
                    word = "";
                } else {
                    word += s.charAt(i) + "";
                }
            }
            return reversedString.toString();
        }
}
