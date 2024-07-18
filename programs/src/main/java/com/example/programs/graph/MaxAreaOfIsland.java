package com.example.programs.graph;

import java.util.Stack;

/**
 * url - https://leetcode.com/problems/max-area-of-island/description/
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */

public class MaxAreaOfIsland {


    int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    boolean[][] seen;
    int m, n = 0;

    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    int shape =1;
                    seen[i][j] = true;
                    Stack<Integer> rowStack = new Stack();
                    Stack<Integer> columnStack = new Stack();
                    rowStack.add(i);
                    columnStack.add(j);
                    while (!rowStack.isEmpty() || !columnStack.isEmpty()) {
                        int row = rowStack.pop();
                        int column = columnStack.pop();
                        for (int[] direction : directions) {
                            int newRow = row + direction[0], newColumn = column + direction[1];
                            if (isValid(newRow, newColumn, grid)) {
                                shape++;
                                seen[newRow][newColumn] = true;
                                rowStack.add(newRow);
                                columnStack.add(newColumn);

                            }
                        }

                    }
                    ans = Math.max(shape, ans);

                }
            }
        }
        return ans;
    }

    public boolean isValid(int row, int column, int[][] c) {
        return row >= 0 && column >= 0 && row < m && column < n && seen[row][column] == false && c[row][column] == 1;
    }

}
