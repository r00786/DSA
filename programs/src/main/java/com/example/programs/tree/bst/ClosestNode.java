package com.example.programs.tree.bst;

import com.example.programs.Utils;
import com.example.programs.tree.dfs.TreeNode;

/**
 * url - https://leetcode.com/problems/closest-binary-search-tree-value/description/
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 * Example 2:
 *
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 109
 * -109 <= target <= 109
 *
 * Seen this question in a real interview before?
 * 1/5
 * Yes
 * No
 */
public class ClosestNode {
    public static void main(String[] args) {
        System.out.println(new ClosestNode().closestValue(Utils.arrayToTree(new Integer[]{4,2,5,1,3}),4.5));
    }
    double ans=Integer.MAX_VALUE;
    int rootVal=0;
    public int closestValue(TreeNode root, double target) {
        if(root==null)return 0;
        if(target>root.val){
            closestValue(root.right,target);
        }else{
            closestValue(root.left,target);
        }
        double diff= Math.abs((root.val-target));
        if(diff<ans){
            ans=Math.abs(root.val-target);
            rootVal=root.val;
        }else if(diff==ans&&root.val<rootVal){
            rootVal=root.val;
        }
        return rootVal;
    }
}
