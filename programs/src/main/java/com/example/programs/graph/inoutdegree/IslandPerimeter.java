package com.example.programs.graph.inoutdegree;

/**
 * https://leetcode.com/problems/island-perimeter/description/
 */

public class IslandPerimeter {


    public int islandPerimeter(int[][] grid) {
        int totalPerimeter=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    int x=4;
                    if(col-1>=0&&grid[row][col-1]==1){
                        x--;
                    }
                    if(col+1<grid[0].length&&grid[row][col+1]==1){
                        x--;
                    }
                    if(row-1>=0&&grid[row-1][col]==1){
                        x--;
                    }
                    if(row+1<grid.length&&grid[row+1][col]==1){
                        x--;
                    }
                    totalPerimeter+=x;
                }

            }
        }
        return totalPerimeter;


    }
}
