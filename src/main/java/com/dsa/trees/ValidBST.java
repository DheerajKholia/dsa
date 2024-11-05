package com.dsa.trees;

import java.util.Stack;

/*
*
Q1. Valid Binary Search Tree
Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
1 <= Number of nodes in binary tree <= 105
0 <= node values <= 232-1

Input Format
First and only argument is head of the binary tree A.
Output Format
Return 0 if false and 1 if true.


Example Input
Input 1:


   1
  /  \
 2    3
Input 2:


  2
 / \
1   3


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.

* */
public class ValidBST {
    public static void main(String[] args) {
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
        ValidBST solution = new ValidBST();
        System.out.println(solution.isValidBST(root));
    }

    public int isValidBST(TreeNode A) {
        return isBST(A,Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }
    boolean isBST(TreeNode node, int minVal, int maxVal) {
        if(node == null) return true;
        if(minVal <= node.val && node.val <= maxVal){
            boolean leftTree = isBST(node.left, minVal, node.val -1);
            if(leftTree == false) return false;
            boolean rightTree = isBST(node.right, node.val + 1, maxVal);
            if(rightTree == false) return false;
            return true;
        }else{
            return false;
        }
    }
}
