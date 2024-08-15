package com.example.programs.dp;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
public class SolvingQuestionsWithBrainPower {


    public long mostPoints(int[][] questions) {
        int n= questions.length;
        long[] dp = new long[n+1];
        for (int i =n-1 ; i>=0; i--) {
            int points= questions[i][0];
            int skips = questions[i][1]+1;
            long currentPoints=points;
            if(skips+i<n){
                currentPoints+= dp[skips+i];
            }
            long currentMx=  dp[i+1];
            dp[i]=Math.max(currentMx,currentPoints);
        }
        return  dp[0];
    }
}
