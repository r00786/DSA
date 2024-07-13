package com.example.programs.tree.dfs;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return dfs(root,0);

    }
    int dfs(TreeNode node,int level){
        if(node==null)return level;
        int levelLeft= dfs(node.left,level+1);
        int levelRight=dfs(node.right,level+1);
        return Math.max(levelLeft,levelRight);
    }
}
