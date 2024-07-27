package com.example.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqSort {
    public static void main(String[] args) {
        System.out.println(new FreqSort().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character,Integer> map= new HashMap();
        Map<Integer, List<Character>> map2= new HashMap();

        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            int value= map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),value+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(!map2.containsKey(entry.getValue())){
                map2.put(entry.getValue(),new ArrayList<>());
            }
            map2.get(entry.getValue()).add(entry.getKey());
            maxValue=Math.max(maxValue,entry.getValue());
        }
        StringBuilder str= new StringBuilder();
        if(maxValue!=Integer.MIN_VALUE){
            while(maxValue>=0){
                if(map2.containsKey(maxValue)){
                    for(int i=0;i<map2.get(maxValue).size();i++){
                        for(int j =0;j<maxValue;j++){
                            str.append(map2.get(maxValue).get(i));
                        }
                    }

                }
                maxValue--;

            }
        }
        return str.toString();


    }
}
