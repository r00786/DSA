package com.example.programs.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/submissions/1346654464/
 */
public class MinClimnStairValue {


    Map<Integer, Integer> memo = new HashMap();

    /**
     * top down approach
     * @param cost
     * @return
     */
    public int minCostClimbingStairsTopDown(int[] cost) {
        return dp(cost.length, cost);

    }

    public int dp(int i, int[] cost) {
        if (i <= 1) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        memo.put(i, Math.min(dp(i - 2,cost) + cost[i-2], cost[i-1] + dp(i - 1,cost)));
        return memo.get(i);
    }


    /**
     * bottom up approach
     * @param cost
     * @return
     */
    public int minCostClimbingStairsBottomUp(int[] cost) {
        if(cost.length<=1){
            return 0;
        }
        int n =cost.length;
        int[] dp= new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];

    }
}
