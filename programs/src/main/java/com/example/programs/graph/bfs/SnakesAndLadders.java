package com.example.programs.graph.bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {


    public int snakesAndLadders(int[][] board) {
        int n =board.length;
        int label=1;
        Pair<Integer,Integer>[] pairs = new Pair[n*n+1];
        Integer[] columns = new Integer[n];
        for(Integer i=0;i<n;i++){
            columns[i]=i;
        }
        for(int row=n-1;row>=0;row--){
            for(Integer col:columns){
                pairs[label++]=new Pair<Integer,Integer>(row,col);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist= new int[n*n+1];
        Arrays.fill(dist,-1);
        dist[1]=0;
        Queue<Integer> queue= new LinkedList();
        queue.add(1);
        while(!queue.isEmpty()){
            int curr= queue.poll();
            for(int next=curr+1;next<=Math.min(curr+6,n*n);next++){
                int row_=pairs[next].getKey(),col_=pairs[next].getValue();
                int destination= board[row_][col_]!=-1?board[row_][col_]:next;
                if(dist[destination]==-1){
                    dist[destination]=dist[curr]+1;
                    queue.add(destination);
                }
            }
        }

        return dist[n*n];
    }

}
