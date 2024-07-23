package com.example.programs.graph.implicit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * url - https://leetcode.com/problems/minimum-genetic-mutation/description/
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 *
 *
 * Example 1:
 *
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 * Example 2:
 *
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 0 <= bank.length <= 10
 * startGene.length == endGene.length == bank[i].length == 8
 * startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']
 */

public class MinMutationRequired {


    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList();
        Set<String> seen = new HashSet();
        queue.add(startGene);
        seen.add(startGene);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node.equals(endGene)) {
                    return steps;
                }
                for (char c : new char[] { 'A', 'C', 'G', 'T' }) {
                    for (int j = 0; j < node.length(); j++) {
                        String mutatedString = node.substring(0, j) + c + node.substring(j + 1);
                        if (!seen.contains(mutatedString) && Arrays.asList(bank).contains(mutatedString)) {
                            seen.add(mutatedString);
                            queue.add(mutatedString);

                        }
                    }

                }
            }
            steps++;


        }
        return -1;

    }
}
