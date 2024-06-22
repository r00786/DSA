package com.example.programs;

import java.util.Arrays;

public class GreedyProgrammingExample {
    public static void main(String[] arr){
       System.out.println(new GreedyProgrammingExample().findMinimumDenomination(3,new int[]{1,2,5,10}));
    }

    public int findMinimumDenomination(int amount,int[] denominations){
        Arrays.sort(denominations);
        int totalCoins=0;
        int remainingAmount = amount;

        for(int i=denominations.length-1;i>=0;i--){
            int numCoins = remainingAmount/denominations[i];
            remainingAmount-= numCoins*denominations[i];
            totalCoins+=numCoins;
            if(remainingAmount==0){
                break;
            }

        }
        return  totalCoins;
    }


}
