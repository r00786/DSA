package com.example.programs.dsa.backtracking;

public class NQueensProblem {
    public int N = 8;

    public boolean isSafeToInsertQueen(int row, int col,boolean[] colCount, boolean[] normalDiag, boolean[] reverseDiag)

    {
        return !colCount[col] && !normalDiag[row + col] && !reverseDiag[row - col + N - 1];
    }

    public boolean solveNQueens(int board[][], int row, boolean[] colCount, boolean[] normalDiag, boolean[] reverseDiag) {
        if (row >= N) {
            return true;
        }
        for (int col = 0; col < N; col++) {
            if (isSafeToInsertQueen(row, col, colCount, normalDiag, reverseDiag)) {
                board[row][col] = 1;
                colCount[col]=true;
                normalDiag[row + col] = true;
                reverseDiag[row - col + N - 1] = true;
                if (solveNQueens(board, row+1, colCount, normalDiag, reverseDiag)) {
                    return true;
                }
                board[row][col] = 0;
                colCount[col]=false;
                normalDiag[row + col] = false;
                reverseDiag[row - col + N - 1] = false;

            }


        }
        return false;


    }

    /* A utility function to print the solution */
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    public void solveNQueensProblem(){
        int[][] board = new int[N][N];
        boolean[] colCount = new boolean[N];
        boolean[] normalDiag= new boolean[2*N-1];
        boolean[] reverseDiag= new boolean[2*N-1];
        if(!solveNQueens(board,0,colCount,normalDiag,reverseDiag)){
            System.out.println("not possible");

        }else{
            printSolution(board);
        }



    }

    public static void main(String[] arr){
        NQueensProblem nQProblem= new NQueensProblem();
        nQProblem.solveNQueensProblem();

    }


}
