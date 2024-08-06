package com.example.programs.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/rotting-oranges/
 */

public class RottenTomatos {

    public int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] graph) {
        Queue<int[]> queue = new LinkedList();
        int ans = 0;
        int m = graph.length;
        int n = graph[0].length;
        int freshTomatos = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (graph[i][j] == 1) {
                    freshTomatos++;
                }

            }
        }
        int rottenTomatos = 0;
        while (!queue.isEmpty() && freshTomatos > 0) {
            rottenTomatos++;
            int queueSize=queue.size();
            for(int i=0;i<queueSize;i++){
                int[] state = queue.remove();
                int row_ = state[0], col_ = state[1];

                for (int[] direction : directions) {
                    int nextRow = row_ + direction[0], nextColumn = col_ + direction[1];
                    if (nextRow >= 0 && nextColumn >= 0 && nextRow < m && nextColumn < n && graph[nextRow][nextColumn] == 1) {
                        graph[nextRow][nextColumn] = 2;
                        freshTomatos--;
                        queue.add(new int[] { nextRow, nextColumn });
                    }
                }
            }

        }

        return freshTomatos > 0 ? -1 : rottenTomatos;
    }
}
