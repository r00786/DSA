package com.example.programs.tree.dfs;

import com.example.programs.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeIterativeTraversal {
    public static void main(String[] args) {
        System.out.println(new TreeIterativeTraversal().preOrderTraversal(Utils.arrayToTree(new Integer[]{3, 7, 2, 6, 1, 9})));
        System.out.println(new TreeIterativeTraversal().postOrderTraversal(Utils.arrayToTree(new Integer[]{3, 7, 2, 6, 1, 9})));
        System.out.println(new TreeIterativeTraversal().inOrderTraversal(Utils.arrayToTree(new Integer[]{3, 7, 2, 6, 1, 9})));

    }


    public List<Integer> preOrderTraversal(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        stack.add(treeNode);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }

        }
        return list;

    }

    public List<Integer> postOrderTraversal(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        Stack<TreeNode> stack2= new Stack<>();

        stack.add(treeNode);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            stack2.add(node);

            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }

        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;

    }


    public List<Integer> inOrderTraversal(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode current=treeNode;
        while(!stack.isEmpty()||current!=null){
            while (current!=null){
                stack.add(current);
                current=current.left;
            }
            current=stack.pop();
            list.add(current.val);
            current=current.right;
        }
        return list;

    }


}
