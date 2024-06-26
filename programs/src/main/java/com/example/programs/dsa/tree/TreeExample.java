package com.example.programs.dsa.tree;

import java.util.*;

public class TreeExample {
    public static void main(String[] arr){
        BinarySearchTree tree= new BinarySearchTree(10);
        tree.add(3);
        tree.add(20);
        tree.add(2);
        tree.add(23);
        tree.add(6);
        tree.add(21);
        BinarySearchTree.TreePrinter(tree);

        tree.deleteNode(tree.rootNode,2);
        System.out.println("");
        BinarySearchTree.TreePrinter(tree);
        tree.inOrderTraversal(tree.rootNode);
        System.out.println("");
        tree.preOrderTraversal(tree.rootNode);
        System.out.println("");
        tree.postOrderTraversal(tree.rootNode);
        System.out.println("");
        tree.levelOrderTraversal(tree.rootNode);

    }
}

class Node {
    public int value;
    public Node left, right;

    Node(int value) {
        this.value = value;
    }
}

class BinarySearchTree {
    public Node rootNode;

    public BinarySearchTree(int rootValue) {
        this.rootNode= new Node(rootValue);
    }


    private int inOrderSuccessor(Node current) {
        int minValue = current.value;
        while (current.left != null) {
            minValue = current.left.value;
            current = current.left;
        }
        return minValue;
    }

    void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(" " + node.value);
        inOrderTraversal(node.right);

    }

    void preOrderTraversal(Node node){
        if(node==null)return;
        System.out.print(" "+node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    void postOrderTraversal(Node node){
        if(node==null)return;
        postOrderTraversal(node.left);

        postOrderTraversal(node.right);
        System.out.print(" "+node.value);
    }

    public Node deleteNode(Node root, int value) {
        if (root == null) return root;
        if (value < root.value) {
            root.left = deleteNode(root.left,value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right,value);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.value = inOrderSuccessor(root.right);
            root.right= deleteNode(root.right,root.value);
        }
        return root;

    }

    void levelOrderTraversal(Node root){
        Queue<Node> queue= new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(" "+node.value);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

        }
    }


    private void printLevelOrder(Node root, StringBuilder sb) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                sb.append(current.value).append(" ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            sb.append("\n");
        }
    }


    public Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else {
            if (value < root.value) {
                root.left = insertNode(root.left, value);
            } else if (value > root.value) {
                root.right = insertNode(root.right, value);
            } else {
                return root;
            }
        }
        return root;

    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public static void printTree(int[][] M, Node root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.value;
        printTree(M, root.left, col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int)Math.pow(2, height - 2), row + 1, height - 1);
    }

    public static void TreePrinter(BinarySearchTree tree) {
        int h = height(tree.rootNode);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, tree.rootNode, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void add(int value){
        rootNode = insertNode(rootNode,value);
    }

    public boolean containsNode(Node root,int value){
        if(root==null){
            return false;
        }
        if(root.value==value){
            return true;
        }
        return value<root.value?containsNode(root.left,value):containsNode(root.right,value);
    }

    public boolean contains(int value){
        return containsNode(rootNode,value);
    }

}
