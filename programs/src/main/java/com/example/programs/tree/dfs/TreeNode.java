package com.example.programs.tree.dfs;


  //Definition for a binary tree node.
  public class TreeNode {
      public  int val;
     public TreeNode left;
      public  TreeNode right;
      TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public static void printPreorder(TreeNode node) {
          if (node == null) {
              return;
          }
          System.out.print(node.val + " ");
          printPreorder(node.left);
          printPreorder(node.right);
      }
  }
