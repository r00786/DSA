package com.example.programs.tree.bfs;

import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * url - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */

public class ZigZagTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.val);

                    if (currentNode.left != null)
                        queue.addLast(currentNode.left);
                    if (currentNode.right != null)
                        queue.addLast(currentNode.right);

                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevel.add(currentNode.val);

                    if (currentNode.right != null)
                        queue.addFirst(currentNode.right);
                    if (currentNode.left != null)
                        queue.addFirst(currentNode.left);
                }

            }
            reverse = !reverse;
            result.add(currentLevel);

        }
        return result;
    }
}
