package com.example.programs.tree.bst;

import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *
 * url - https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 *
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */

public class AverageOfLevels {


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans= new ArrayList();
        if (root == null)return ans;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum=0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

            }
            ans.add(sum/n);

        }
        return ans;

    }
}
