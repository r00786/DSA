package com.example.programs.tree.bst;

import com.example.programs.Utils;
import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(new MinAbsoluteDifference().getMinimumDifference(Utils.arrayToTree(new Integer[]{236,104,701,null,227,null,911})));
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list= new ArrayList();
        int min=Integer.MAX_VALUE;
        dfs(root,list);
        for(int i=1;i<list.size();i++){
            min=Math.min(min,list.get(i)-list.get(i-1));
        }
        return min;
    }

    public void dfs(TreeNode root,List<Integer> values){
        if(root==null)return;
        dfs(root.left,values);
        values.add(root.val);
        dfs(root.right,values);

    }
}


