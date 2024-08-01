package com.example.programs.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class FindTownJudge {
    public static void main(String[] args) {
        System.out.println(new FindTownJudge().findJudge(2,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }


    public int findJudge(int n, int[][] trust) {
        int[] indegree= new int[n+1];
        int[] outdegree= new int[n+1];
        for(int[] trustie:trust){
            outdegree[trustie[0]]++;
            indegree[trustie[1]]++;
        }

        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1&&outdegree[i]==0){
                return i;
            }

        }
        return -1;
    }
}
