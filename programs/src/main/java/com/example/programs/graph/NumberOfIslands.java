package com.example.programs.graph;

import java.util.Stack;

/**
 * url - https://leetcode.com/problems/number-of-islands/description/
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * Seen this question in a real interview before?
 * 1/5
 */
public class NumberOfIslands {


        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] seen;
        int m, n = 0;

        public int numIslands(char[][] grid) {

            int ans = 0;
            m = grid.length;
            n = grid[0].length;
            seen = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1'&&!seen[i][j]) {
                        ans++;
                        seen[i][j] = true;
                        dfs(i, j, grid);

                    }
                }
            }
            return ans;
        }

        public boolean isValid(int row, int column, char[][] c) {
            return row >= 0 && column >= 0 && row < m && column < n && seen[row][column] == false && c[row][column] == '1';
        }

        public void dfs(int startRow, int startColumn, char[][] c) {
            Stack<Integer> rowStack = new Stack();
            Stack<Integer> columnStack = new Stack();
            rowStack.add(startRow);
            columnStack.add(startColumn);
            while (!rowStack.isEmpty() || !columnStack.isEmpty()) {
                int row = rowStack.pop();
                int column = columnStack.pop();
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newColumn = column + direction[1];
                    if (isValid(newRow, newColumn, c)) {
                        seen[newRow][newColumn] = true;
                        rowStack.add(newRow);
                        columnStack.add(newColumn);

                    }
                }

            }
        }

}
