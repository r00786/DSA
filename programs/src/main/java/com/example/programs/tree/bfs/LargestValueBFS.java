package com.example.programs.tree.bfs;

import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * url - https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class LargestValueBFS {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();

        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxValue = Math.max(node.val, maxValue);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(maxValue);

        }
        return ans;
    }
}
