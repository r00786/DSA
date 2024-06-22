package com.example.programs;

public class DynamicProgrammingExample {
    public static void main(String[] arr){
        System.out.println(new DynamicProgrammingExample().minCoinsRequired(23,new int[]{1,2,5,10}));

    }

    public int minCoinsRequired(int amount,int[] coins){
        int[] dpArray= new int[amount+1];
        for(int i =0 ;i<=amount;i++){
            dpArray[i]= amount+1;
        }
        dpArray[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i>=coin&&dpArray[i-coin]!=amount+1){
                    dpArray[i]=Math.min(dpArray[i],dpArray[i-coin]+1);
                }

            }
        }


        return dpArray[amount];

    }
}
