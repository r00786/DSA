package com.example.programs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * url - https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 2:
 *
 *
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 3:
 *
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 2 <= n <= 5 * 104
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */

public class ReorderPathsToPointZero {

        Set<String> roads = new HashSet();
        Set<Integer> seen = new HashSet();
        Map<Integer, List<Integer>> graph = new HashMap();

        public int minReorder(int n, int[][] connections) {
            int ans=0;
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] connection : connections) {
                int x = connection[0], y = connection[1];
                graph.get(x).add(y);
                graph.get(y).add(x);
                roads.add(convertToHash(x, y));
            }
            seen.add(0);
            Stack<Integer> stack = new Stack();
            stack.add(0);
            while (!stack.isEmpty()) {
                int node = stack.pop();
                for (int neighbour : graph.get(node)) {
                    if (!seen.contains(neighbour)) {
                        if(roads.contains(convertToHash(node, neighbour))){
                            ans++;
                        }
                        seen.add(neighbour);
                        stack.add(neighbour);
                    }

                }
            }
            return ans;

        }

        public String convertToHash(int x, int y) {
            return x + "," + y;
        }

}
