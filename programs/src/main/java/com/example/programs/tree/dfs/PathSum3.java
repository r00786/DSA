package com.example.programs.tree.dfs;

import com.example.programs.Utils;

public class PathSum3 {
    public static void main(String[] args) {
        System.out.println(new PathSum3().pathSum(Utils.arrayToTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}),8));
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
