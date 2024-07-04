package com.example.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCardPickUp {
    public static void main(String[] arr){
        System.out.println(new MinCardPickUp().minimumCardPickup(new int[]{1, 2, 6, 3,2, 1}));
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer,List<Integer>> dic= new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(!dic.containsKey(cards[i])){
                dic.put(cards[i],new ArrayList<>());
            }
            dic.get(cards[i]).add(i);
        }
        for(Map.Entry<Integer,List<Integer>> entry:dic.entrySet()){
            List<Integer> value = entry.getValue();
            for(int i=0;i<value.size()-1;i++){
                ans=Math.min(ans,value.get(i+1)-value.get(i)+1);
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;

    }
}
