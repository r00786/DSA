package com.example.programs;

public class AnswerQueries {
    public static void main(String[] arr){
      boolean[] answerArr=  new AnswerQueries().answerQueries(new int[]{1, 6, 3, 2, 7, 2},new int[][]{{0, 3},
                {2, 5},
                {2, 4}},13);
     for(int i=0;i<answerArr.length;i++){
         System.out.print(answerArr[i]+",");
     }

    }

    public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix= new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        boolean[] ans = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            int current= prefix[y] - prefix[x] + nums[x];
            ans[i]=current<limit;
        }
        return ans;
    }
}
