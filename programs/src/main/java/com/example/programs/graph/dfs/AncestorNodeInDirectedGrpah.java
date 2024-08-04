package com.example.programs.graph.dfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 */

public class AncestorNodeInDirectedGrpah {
    public static void main(String[] args) {
        System.out.println(new AncestorNodeInDirectedGrpah().getAncestors(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}}));
    }


    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> anscestors = new ArrayList<>();
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            anscestors.add(new ArrayList<>());
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, anscestors, adjacencyList);
        }
        return anscestors;
    }

    public void dfs(int root, List<List<Integer>> anscestors, List<Integer>[] adjacencyList) {
        Stack<Integer> stack = new Stack<>();
        stack.add(root);
        boolean[] visited = new boolean[adjacencyList.length];
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (!visited[node]) {
                for (Integer next : adjacencyList[node]) {
                    if (anscestors.get(next).isEmpty() || anscestors.get(next).get(anscestors.get(next).size() - 1) != root) {
                        anscestors.get(next).add(root);
                        stack.add(next);
                    }
                }
            }

            visited[node] = true;
        }
    }
}
