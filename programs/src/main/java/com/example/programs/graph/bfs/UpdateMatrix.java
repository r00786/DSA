package com.example.programs.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * url - https://leetcode.com/problems/01-matrix/description/
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class UpdateMatrix {




        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            Queue<State> queue = new LinkedList();
            boolean[][] seen = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0 && !seen[i][j]) {
                        seen[i][j] = true;
                        queue.add(new State(i, j, 1));
                    }
                }
            }
            while (!queue.isEmpty()) {
                State state = queue.poll();
                int row = state.row, col = state.column, steps = state.steps;
                for (int[] direction : directions) {
                    int newRow = row + direction[0], newColumn = col + direction[1];
                    if(isValid(newRow,newColumn,m,n,mat)&&!seen[newRow][newColumn]){
                        seen[newRow][newColumn]=true;
                        queue.add(new State(newRow, newColumn, steps+1));
                        mat[newRow][newColumn]=steps;
                    }
                }
            }
            return mat;

        }

        public boolean isValid(int row, int column, int m, int n, int[][] mat) {
            return row >= 0 && column >= 0 && row < m && column < n && mat[row][column] == 1;
        }


}
