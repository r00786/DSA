package com.example.programs.tree.dfs;

import com.example.programs.Utils;

public class DeleteNodeFromTree {
    public static void main(String[] args) {
        System.out.println(new DeleteNodeFromTree().deleteNode(Utils.arrayToTree(new Integer[]{5,3,6,2,4,null,7}),3));
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        TreeNode current=root;
        if(key<current.val){
            current.left = deleteNode(current.left,key);
        }else if(key>current.val){
            current.right = deleteNode(current.right,key);
        }else{
            if(current.left==null&&current.right==null){
                return null;
            } else if(current.left==null){
                return current.right;
            }else if(current.right==null){
                return current.left;
            }else{
                current.val = findMinValueInRight(current.right).val;
                current.right=deleteNode(current.right, current.val);
                return current;
            }
        }
        return root;
    }

    public TreeNode findMinValueInRight(TreeNode node){
        if(node.left==null){
            return node;
        }
        node = findMinValueInRight(node.left);
        return node;

    }
}
