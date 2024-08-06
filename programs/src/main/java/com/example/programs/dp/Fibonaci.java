package com.example.programs.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * memoization of fibonacci numbers
 *
 */
public class Fibonaci {
    Map<Integer,Integer> memoize=new HashMap<>();
    public static void main(String[] args) {
        System.out.println(new Fibonaci().fibaonaci(10));
    }



    public int fibaonaci(int n){
        if(n==0||n==1)return n;
        if(memoize.containsKey(n)){
            return memoize.get(n);
        }
         memoize.put(n,fibaonaci(n-1)+fibaonaci(n-2));
         return memoize.get(n);
    }

    /**
     * bottom up approach
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        int[] arr = new int[n + 1];
        // base case - the second Fibonacci number is 1
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
