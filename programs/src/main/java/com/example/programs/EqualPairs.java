package com.example.programs;

import java.util.HashMap;
import java.util.Map;

public class EqualPairs {
    public static void main(String[] arr){
        System.out.println(new EqualPairs().equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
    }
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap();
        Map<String, Integer> cols = new HashMap();
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = new int[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                row[j] = grid[i][j];
            }
            String key = convertToKey(row);
            rows.put(key, rows.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                col[j] = grid[j][i];
            }
            String key = convertToKey(col);
            cols.put(key, cols.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : rows.entrySet()) {
            ans += cols.getOrDefault(entry.getKey(), 0) * entry.getValue();
        }
        return ans;
    }

    public String convertToKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
            sb.append(",");
        }
        return sb.toString();
    }
}
