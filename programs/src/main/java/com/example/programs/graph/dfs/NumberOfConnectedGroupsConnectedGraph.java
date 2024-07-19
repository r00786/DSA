package com.example.programs.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * url - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 *
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 1 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai <= bi < n
 * ai != bi
 * There are no repeated edges.
 */

public class NumberOfConnectedGroupsConnectedGraph {


        Map<Integer, List<Integer>> graph= new HashMap();
        boolean[] seen;
        public int countComponents(int n, int[][] edges) {
            seen= new boolean[n];
            int count=0;
            for(int i=0;i<n;i++){
                graph.put(i, new ArrayList());
            }
            for(int[] edge:edges){
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            for(int i=0;i<n;i++){
                if(!seen[i]){
                    seen[i]=true;
                    count++;
                    dfs(i);
                }

            }
            return count++;

        }

        public void dfs(int node){
            Stack<Integer> stack= new Stack();
            stack.add(node);
            while(!stack.isEmpty()){
                Integer node2 = stack.pop();
                for(Integer neighbour:graph.get(node2)){
                    if(!seen[neighbour]){
                        seen[neighbour]=true;
                        stack.push(neighbour);
                    }
                }
            }
        }

}
