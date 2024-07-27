package com.example.programs.tree.dfs;

import com.example.programs.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * url - https://leetcode.com/problems/path-sum-ii/description/
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */

public class PathSum2 {
    public static void main(String[] args) {
        System.out.println(new PathSum2().pathSum(Utils.arrayToTree(new Integer[]{1,2}),1));
    }


    class State{
        List<Integer> list;
        int sum;
        TreeNode node;

        public State(TreeNode treeNode,List<Integer> list, int sum){
            this.node= treeNode;
            this.list=list;
            this.sum=sum;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list= new ArrayList();
        if(root==null){
            return list;
        }
        Stack<State> stack = new Stack();
        stack.add(new State(root,new ArrayList<Integer>(),0));
        while(!stack.isEmpty()){
            State state=stack.pop();
            TreeNode node= state.node;
            List<Integer> ls= new ArrayList(state.list);
            int sum = state.sum + node.val;
            ls.add(node.val);
            if(node.left==null&&node.right==null&&sum==targetSum){
                list.add(ls);
            }
            if(node.right!=null){
                stack.add(new State(node.right,new ArrayList(ls),sum));
            }

            if(node.left!=null){
                stack.add(new State(node.left,new ArrayList(ls),sum));
            }

        }
        return list;

    }
}
