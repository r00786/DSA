package com.example.programs.dp;

import java.util.Arrays;
import java.util.Stack;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(2,new int[]{3,2,6,5,0,3}));

//        System.out.println(new BestTimeToBuyAndSellStock().maxProfit2(2,new int[]{3,2,6,5,0,3}));
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

    int n;
    int[][][] memo;
    int[] prices;

    public int maxProfit2(int k, int[] prices) {
        n = prices.length;
        memo = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        this.prices = prices;
        return dp(0, 0, k);
    }

    public int dp(int i, int holding, int remain) {
        if (i == n || remain == 0) {
            return 0;
        }

        if (memo[i][holding][remain] != -1) {
            return memo[i][holding][remain];
        }

        int ans = dp(i + 1, holding, remain);
        if (holding == 1) {
            ans = Math.max(ans, prices[i] + dp(i + 1, 0, remain - 1));

        } else {
            ans = Math.max(ans, -prices[i] + dp(i + 1, 1, remain));
        }

        memo[i][holding][remain] = ans;
        return ans;
    }
}
