package com.example.programs.tree.dfs;

/**
 * url - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *   public int minDepth(TreeNode root) {
 *     if(root==null)return 0;
 *      int depthLeft = minDepth(root.left);
 *      int depthRight = minDepth(root.right);
 *      if(root.left==null&&root.right==null){
 *         return 1;
 *      }
 *      if(root.left==null&&root.right!=null){
 *         return 1+depthRight;
 *      }
 *       if(root.left!=null&&root.right==null){
 *         return 1+depthLeft;
 *      }
 *
 *      return Math.min(depthLeft,depthRight)+1;
 *
 *     }
 */

public class MinDepthBinaryTree {

    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int depthLeft = minDepth(root.left);
        int depthRight = minDepth(root.right);
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left == null){
            return 1+depthRight;
        }
        if(root.right == null){
            return 1+depthLeft;
        }

        return Math.min(depthLeft,depthRight)+1;

    }
}
