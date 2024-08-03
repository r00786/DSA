package com.example.programs.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        System.out.println(new NumberOfEnclaves().numEnclaves(new int[][]{{0},{1},{1},{0},{0}}));
    }


    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[0][i]==1)dfs(0,i,m,n,grid);
            if(grid[m-1][i]==1)dfs(m-1,i,m,n,grid);
        }
        for(int i=0;i<m;i++){
            if(grid[i][0]==1)dfs(i,0,m,n,grid);
            if(grid[i][n-1]==1)dfs(i,n-1,m,n,grid);
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;

    }

    public boolean isValid(int row, int col, int m, int n, int[][] grid) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1;
    }


    public void dfs(int row, int column,int m,int n, int[][] grid) {
        Stack<Integer[]> stack = new Stack();
        stack.push(new Integer[] { row, column });
        while (!stack.isEmpty()) {
            Integer[] node =  stack.pop();
            int row_=node[0],col_=node[1];
            grid[row_][col_] = 0;
            for(int[] direction:directions){
                int newRow=row_+direction[0],newCol=col_+direction[1];
                if(isValid(newRow,newCol,m,n,grid)) {
                        stack.add(new Integer[]{newRow, newCol});
                }
            }
        }
    }
}
