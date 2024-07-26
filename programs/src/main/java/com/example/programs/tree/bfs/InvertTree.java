package com.example.programs.tree.bfs;

import com.example.programs.tree.dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * url - https://leetcode.com/problems/invert-binary-tree/description/
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class InvertTree {


    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        Queue<TreeNode> queue= new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            if(current.left!=null||current.right!=null){
                TreeNode temp=current.left;
                current.left=current.right;
                current.right=temp;
            }
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
        return root;

    }
}
