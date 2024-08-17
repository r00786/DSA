package com.example.programs.dp;

import java.util.Arrays;
import java.util.Stack;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(2,new int[]{6,1,3,2,4,7}));
    }


    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=Math.max(dp[i][j-1],helper(i,j,prices,dp));

            }
        }
        return dp[k][n-1];

    }
    public int helper(int k,int x,int[] prices,int[][] dp){
        int max=0;
        for(int i=0;i<x;i++){
            max=Math.max(max,prices[x]-prices[i] + dp[k-1][i]);
        }

        return max;
    }
}
