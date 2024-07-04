package com.example.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example 1: 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 *
 * For example, given strs = ["eat","tea","tan","ate","nat","bat"], return [["bat"],["nat","tan"],["ate","eat","tea"]].
 */

public class GroupAnagrams {
    public static void main(String[] arr){
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramsMap= new HashMap<>();
        for(String str:strs){
            char[] arr= str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!anagramsMap.containsKey(key)){
                anagramsMap.put(key,new ArrayList<>());
            }
            anagramsMap.get(key).add(str);
        }
        return  new ArrayList<>(anagramsMap.values());

    }
    }
