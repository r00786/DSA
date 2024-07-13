package com.example.programs.tree.bfs;

import com.example.programs.Utils;
import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * url - https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
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

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

        System.out.println(new BinaryTreeRightSideView().rightSideViewDfs(Utils.arrayToTree(new Integer[]{1,2,3,null,5,null,4})));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue= new LinkedList<>();
        List<Integer> ans= new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currentSize=queue.size();
            Integer prevVal=0;
            for(int i=0;i<currentSize;i++){
                TreeNode node= queue.poll();
                prevVal = node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(prevVal);
        }
        return ans;
    }

    List<Integer> ans = new ArrayList<>();
    public void dfsRecursive(TreeNode node, int level){
        if(ans.size() == level) {
            ans.add(node.val);
        }
        if(node.right!=null) dfsRecursive(node.right, level+1);
        if(node.left!=null) dfsRecursive(node.left, level+1);


    }
    public List<Integer> rightSideViewDfs(TreeNode root) {
        if(root == null){
            return ans;
        }

        dfsRecursive(root, 0);
        return ans;
    }
}
