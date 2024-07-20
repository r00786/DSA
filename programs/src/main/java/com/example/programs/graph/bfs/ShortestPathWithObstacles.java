package com.example.programs.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * url - https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/
 *
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * Example 2:
 *
 *
 * Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
 * Output: -1
 * Explanation: We need to eliminate at least two obstacles to find such a walk.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 40
 * 1 <= k <= m * n
 * grid[i][j] is either 0 or 1.
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */

public class ShortestPathWithObstacles {
    public static void main(String[] args) {
        System.out.println(new ShortestPathWithObstacles().shortestPath(new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}},1));
    }


    class State {
        int row;
        int col;
        int remain;
        int steps;
        State(int row, int col, int remain, int steps) {
            this.row = row;
            this.col = col;
            this.remain = remain;
            this.steps = steps;
        }
    }


        int m;
        int n;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int shortestPath(int[][] grid, int k) {
            m = grid.length;
            n = grid[0].length;
            Queue<State> queue = new LinkedList<>();
            boolean[][][] seen = new boolean[m][n][k + 1];
            queue.add(new State(0, 0, k, 0));
            seen[0][0][k] = true;

            while (!queue.isEmpty()) {
                State state = queue.remove();
                int row = state.row, col = state.col, remain = state.remain, steps = state.steps;
                if (row == m - 1 && col == n - 1) {
                    return steps;
                }

                for (int[] direction: directions) {
                    int nextRow = row + direction[0], nextCol = col + direction[1];
                    if (valid(nextRow, nextCol)) {
                        if (grid[nextRow][nextCol] == 0) {
                            if (!seen[nextRow][nextCol][remain]) {
                                seen[nextRow][nextCol][remain] = true;
                                queue.add(new State(nextRow, nextCol, remain, steps + 1));
                            }
                            // otherwise, it is an obstacle and we can only pass if we have remaining removals
                        } else if (remain > 0 && !seen[nextRow][nextCol][remain - 1]) {
                            seen[nextRow][nextCol][remain - 1] = true;
                            queue.add(new State(nextRow, nextCol, remain - 1, steps + 1));
                        }
                    }
                }
            }

            return -1;
        }

        public boolean valid(int row, int col) {
            return 0 <= row && row < m && 0 <= col && col < n;
        }
}
