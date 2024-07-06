package com.example.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * url- https://leetcode.com/problems/isomorphic-strings/description/
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */

public class IsomorphicStrings {
    public static void  main(String[] arr){
    System.out.println(new IsomorphicStrings().isIsomorphic("egg","add"));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> mapping= new HashMap();
        Set<Character> valueSet= new HashSet();

        for(int i=0;i<s.length();i++){
            if(!mapping.containsKey(s.charAt(i))){
                if(valueSet.contains(t.charAt(i))){
                    return false;
                }
                mapping.put(s.charAt(i),t.charAt(i));
                valueSet.add(t.charAt(i));
            }
            if(mapping.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }

        }
        return true;

    }
}
