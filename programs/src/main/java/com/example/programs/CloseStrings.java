package com.example.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloseStrings {
    public static void main(String[] arr){
        System.out.println(new CloseStrings().closeStrings("cabbba","abbccc"));
    }
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] checkExists1= new boolean[26];
        boolean[] checkExists2= new boolean[26];
        for(char c:word1.toCharArray()){
            freq1[c-'a']++;
            checkExists1[c-'a']=true;

        }
        for(char c:word2.toCharArray()){
            freq2[c-'a']++;
            checkExists2[c-'a']=true;

        }

        for(int i=0;i<checkExists1.length;i++){
            if(checkExists1[i]!=checkExists2[i]){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1,freq2);

    }
}
