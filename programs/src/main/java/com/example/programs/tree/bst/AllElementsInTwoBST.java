package com.example.programs.tree.bst;

import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBST {
    /**
     *
     * url - https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
     * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root1 = [2,1,4], root2 = [1,0,3]
     * Output: [0,1,1,2,3,4]
     * Example 2:
     *
     *
     * Input: root1 = [1,null,8], root2 = [8,1]
     * Output: [1,1,8,8]
     *
     *
     * Constraints:
     *
     * The number of nodes in each tree is in the range [0, 5000].
     * -105 <= Node.val <= 105
     * @param root1
     * @param root2
     * @return
     */


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ls1= new ArrayList();
        List<Integer> ls2= new ArrayList();
        dfs(root1,ls1);
        dfs(root2,ls2);
        ls1.addAll(ls2);
        Collections.sort(ls1);
        return ls1;
    }
    public void dfs(TreeNode node,List<Integer> ls){
        if(node==null)return;
        dfs(node.left,ls);
        ls.add(node.val);
        dfs(node.right,ls);
    }
}
