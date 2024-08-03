package com.example.programs.graph.inoutdegree;

/**
 * https://leetcode.com/problems/maximal-network-rank/description/
 */
public class MaximalNetwork {


    public int maximalNetworkRank(int n, int[][] roads) {
        int[] roadConnectivity = new int[n];
        boolean[][] connections = new boolean[n][n];
        for (int[] road : roads) {
            roadConnectivity[road[0]]++;
            roadConnectivity[road[1]]++;
            connections[road[0]][road[1]] = true;
            connections[road[1]][road[0]] = true;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = roadConnectivity[i] + roadConnectivity[j];
                if (connections[i][j] || connections[j][i]) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);

            }
        }
        return maxRank;
    }
}
