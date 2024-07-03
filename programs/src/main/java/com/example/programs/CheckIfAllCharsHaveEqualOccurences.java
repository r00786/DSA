package com.example.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfAllCharsHaveEqualOccurences {
    public static void main(String[] arr){
        System.out.println(new CheckIfAllCharsHaveEqualOccurences().areOccurrencesEqual("abacbcc"));
    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Set<Integer> set= new HashSet<>(map.values());
        return  set.size()==1;
    }
    }
