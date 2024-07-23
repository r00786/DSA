package com.example.programs.graph.implicit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * url - https://leetcode.com/problems/evaluate-division/description/
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        /**
         * a/b=2  b/c=3  a/c= ?
         * a=2*b
         * b=c*3
         * c=b/3
         *
         *
         * a/b=2;
         * b/a=0.5
         * a/c = 2*3
         */
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));
    }


    class Pair {
        String node;
        double ratio;
        Pair(String node, double ratio) {
            this.node = node;
            this.ratio = ratio;
        }
    }

    Map<String,Map<String,Double>> graph = new HashMap();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0;i<equations.size();i++){
            double val= values[i];
            List<String> equation = equations.get(i);
            String numerator = equation.get(0),denominator=equation.get(1);
            if(!graph.containsKey(numerator)){
                graph.put(numerator,new HashMap());
            }
            if(!graph.containsKey(denominator)){
                graph.put(denominator,new HashMap());
            }
            graph.get(numerator).put(denominator,val);
            graph.get(denominator).put(numerator,1/val);

        }
        double[] ans = new double[queries.size()];
        for(int i=0;i<ans.length;i++){
            String start= queries.get(i).get(0);
            String end= queries.get(i).get(1);
            ans[i]=getAnswer(start,end);
        }
        return ans;
    }
    public double getAnswer(String start,String end){
        if (!graph.containsKey(start)) {
            return -1;
        }
        Stack<Pair> stack = new Stack();
        Set<String> seen= new HashSet();
        stack.add(new Pair(start,1.0));
        seen.add(start);
        while(!stack.isEmpty()){
            Pair node = stack.pop();
            String key=node.node;
            double ratio = node.ratio;
            if(key.equals(end)){
                return ratio;
            }
            if(graph.containsKey(key)){
                for(String neighbour:graph.get(key).keySet()){
                    if(!seen.contains(neighbour)){
                        seen.add(neighbour);
                        stack.add(new Pair(neighbour,ratio*graph.get(key).get(neighbour)));
                    }
                }
            }
        }
        return -1.0;
    }
}
