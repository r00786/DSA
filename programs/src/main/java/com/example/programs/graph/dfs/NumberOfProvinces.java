package com.example.programs.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url - https://leetcode.com/problems/number-of-provinces/description/
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

public class NumberOfProvinces {



        Map<Integer, List<Integer>> graph;
        boolean[] seen;

        public int findCircleNum(int[][] isConnected) {
            graph = new HashMap();
            int ans = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (!graph.containsKey(i)) {
                    graph.put(i, new ArrayList());
                }
                for (int j = 0; j < isConnected.length; j++) {
                    if (!graph.containsKey(j)) {
                        graph.put(j, new ArrayList());
                    }
                    if (isConnected[i][j] == 1) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }

                }
            }
            seen = new boolean[isConnected.length];
            for (int i = 0; i < seen.length; i++) {
                if (!seen[i]) {
                    ans++;
                    seen[i] = true;
                    dfs(i);
                }
            }
            return ans;
        }

        public void dfs(int node) {
            for (Integer neighbour : graph.get(node)) {
                if (!seen[neighbour]) {
                    seen[neighbour] = true;
                    dfs(neighbour);
                }
            }

        }
}
