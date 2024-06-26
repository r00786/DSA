package com.example.programs.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private static int[] ROW_DIRECTION = {-1, 1, 0, 0};
    private static int[] COLUMN_DIRECTION = {0, 0, -1, 1};

    public static void main(String[] arr){
        int[][] image = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1}
        };
        int X = 4;
        int Y = 4;
        int newColor = 3;

        System.out.println("Original Image:");
        printImage(image);

       new FloodFill().floodFill(image, X, Y, newColor);

        System.out.println("Image after Flood Fill:");
        printImage(image);
    }


    public void floodFill(int[][] image, int row, int column, int newColor) {
        int oldColor = image[row][column];
        if (oldColor == newColor) {
            return;
        }
        int rows = image.length;
        int columns = image[0].length;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{row, column});
        image[row][column] = newColor;
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int currentRow = currentPosition[0];
            int currentColumn = currentPosition[1];
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + ROW_DIRECTION[i];
                int newColumn = currentColumn + COLUMN_DIRECTION[i];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && image[newRow][newColumn] == oldColor) {
                    image[newRow][newColumn] = newColor;
                    queue.add(new int[]{newRow, newColumn});
                }
            }

        }


    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }


}
