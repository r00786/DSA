package com.example.programs.tree.dfs;

/**
 * url - https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 *
 *
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 */

public class MaxAncestorValueDfs {


    public int maxAncestorDiff(TreeNode root) {
        return maxValueWithDfs(root,root.val,root.val);

    }
    public int maxValueWithDfs(TreeNode root,int max,int min){
        if(root==null){
            return Math.abs(max-min);
        }
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);
        int leftDiff=maxValueWithDfs(root.left,max,min);
        int rightDiff=maxValueWithDfs(root.right,max,min);
        return Math.max(Math.max(leftDiff,rightDiff),Math.abs(max-root.val));

    }
}
