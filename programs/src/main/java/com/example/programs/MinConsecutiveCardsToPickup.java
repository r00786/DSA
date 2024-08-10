package com.example.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
 *
 *
 */

public class MinConsecutiveCardsToPickup {


    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> cardPositions= new HashMap();
        int j=0;
        for(int card:cards){
            cardPositions.computeIfAbsent(card,k->new ArrayList<>()).add(j);
            j++;

        }
        int ans=Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry:cardPositions.entrySet()){
            List<Integer> list= entry.getValue();
            for(int i=0;i<list.size()-1;i++){
                ans=Math.min(ans,list.get(i+1)-list.get(i)+1);
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;

    }
}
