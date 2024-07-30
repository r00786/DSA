package com.example.programs.tree.bst;

import com.example.programs.Utils;
import com.example.programs.tree.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxSumLevel {
    public static void main(String[] args) {
        System.out.println(new MaxSumLevel().maxLevelSum(Utils.arrayToTree(new Integer[]{-100,-200,-300,-20,-5,-10,null})));
    }


    public int maxLevelSum(TreeNode root) {
        if (root == null)return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int level=0;
        int maxSum=Integer.MIN_VALUE;
        int maxSumLevel=0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            level+=1;
            int sum=0;
            List<Integer> ls = new ArrayList();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node != null) {
                    ls.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

            }
            if(sum>maxSum){
                maxSum=sum;
                maxSumLevel=level;
            }

        }
        return maxSumLevel;

    }
}
