package com.example.programs.graph.bfs;

import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * url - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 *
 * Input: root = [1], target = 1, k = 3
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 */

public class AllNodesDistanceKInBinaryTree {


    Map<TreeNode, TreeNode> parents = new HashMap();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> set = new HashSet();
        queue.add(target);
        set.add(target);
        int distance = 0;
        while (!queue.isEmpty() && distance < k) {
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                for (TreeNode neighbour : new TreeNode[] { node.left, node.right, parents.get(node) }) {
                    if (neighbour!=null&&!set.contains(neighbour)) {
                        set.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }

            distance++;
        }
        List<Integer> ans = new ArrayList();
        for (TreeNode node : queue) {
            ans.add(node.val);
        }

        return ans;
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        parents.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
