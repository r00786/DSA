package com.example.programs.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * url - https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
 */

public class NumberOfMinutes {
    public static void main(String[] args) {
        System.out.println(new NumberOfMinutes().numOfMinutes(6,2,new int[]{2,2,-1,2,2,2}
                ,new int[]{0,0,1,0,0,0}));
    }


    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int i = 0; i < n; i++) {
            if (i == headID)
                continue;
            graph.computeIfAbsent(manager[i], k -> new ArrayList<Integer>()).add(i);

        }
        int[] ans = new int[n];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] { headID, 0 });

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int man = node[0];
            int time = node[1];
            ans[man] = time;
            for (Integer next : graph.getOrDefault(man, new ArrayList<>())) {
                queue.add(new int[] { next, time + informTime[man] });

            }

        }
        return Arrays.stream(ans).max().getAsInt();

    }
}
