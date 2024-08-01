package com.example.programs.tree.bst;

import com.example.programs.Utils;
import com.example.programs.tree.dfs.TreeNode;

public class SearchBST {
    public static void main(String[] args) {
        System.out.println(new SearchBST().searchBST(Utils.arrayToTree(new Integer[]{4,2,7,1,3}),2));
    }


    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root,val);
    }
    public TreeNode dfs(TreeNode root,int val){
        if(root==null)return null;
        if(val<root.val){
            root= dfs(root.left,val);
        }else if(val>root.val){
            root = dfs(root.right,val);
        } else {
            return root;
        }
        return root;
    }
}
