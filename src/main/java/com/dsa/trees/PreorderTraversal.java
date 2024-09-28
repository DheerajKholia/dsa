package com.dsa.trees;

import java.util.Stack;

/*
Preorder Traversal

Problem Description
Given a binary tree, return the preorder traversal of its nodes values.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the preorder traversal of the given binary tree.

Example Input

Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3
Example Output
Output 1:
 [1, 2, 3]
Output 2:
 [1, 6, 2, 3]

*/
public class PreorderTraversal {
    public static void main(String[] args) {
        PreorderTraversal solution = new PreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(11);

        root.left.left.left.left = new TreeNode(12);
        root.left.left.left.right = new TreeNode(13);
        root.right.right.right.left = new TreeNode(14);
        root.right.right.right.right = new TreeNode(15);

        root.left.left.left.left.left = new TreeNode(16);
        root.left.left.left.left.right = new TreeNode(17);
        root.right.right.right.right.left = new TreeNode(18);
        root.right.right.right.right.right = new TreeNode(19);
        root.right.right.right.right.right = new TreeNode(20);

        printArray(solution.preOrderTraversal(root));
    }

    public int[] preOrderTraversal(TreeNode root) {
        int size = getSize(root);
        int[] result = new int[size];
        int index = 0;
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(root);
        stack.push(pair);
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.task == 1) {
                top.task++;
                result[index++] = top.node.val;
            } else if (top.task == 2) {
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left));
                }
                top.task++;
            } else if (top.task == 3) {
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right));
                }
                top.task++;
            } else {
                stack.pop();
            }
        }
        return result;
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    int getSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + getSize(root.left) + getSize(root.right);
    }
}
