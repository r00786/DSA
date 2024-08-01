package com.example.programs.tree.bfs;

import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * url - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */

public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> ls = new ArrayList();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    ls.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

            }
            ans.add(ls);

        }
        return ans;

    }
}
