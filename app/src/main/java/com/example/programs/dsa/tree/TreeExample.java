package com.example.programs.dsa.tree;

public class TreeExample {
    public static void main(String[] arr){
        BinaryTree tree= new Binary(1);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        System.out.println(tree);

    }
}

class Node {
    public int value;
    public Node left, right;

    Node(int value) {
        this.value = value;
    }
}

class BinaryTree {
    public Node rootNode;

    public BinaryTree(int rootValue) {
        this.rootNode= new Node(rootValue);
    }

    @Override
    public String toString() {
        if (rootNode == null) {
            return "Tree is empty";
        }

        StringBuilder sb = new StringBuilder();
        printTree(rootNode, "", true, sb);
        return sb.toString();
    }

    private void printTree(Node node, String prefix, boolean isTail, StringBuilder sb) {
        if (node.right != null) {
            printTree(node.right, prefix + (isTail ? "│   " : "    "), false, sb);
        }

        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.value).append("\n");

        if (node.left != null) {
            printTree(node.left, prefix + (isTail ? "    " : "│   "), true, sb);
        }
    }

    public void add(int value){
       root= insertNode(rootNode,value);
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
        return current;

    }

}
