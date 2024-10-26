package com.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Q3. Balanced Binary Tree
Problem Description
Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the root of the tree A.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
Input 1:

    1
   / \
  2   3
Input 2:
       1
      /
     2
    /
   3

Example Output

Output 1:

1
Output 2:

0


Example Explanation

Explanation 1:

It is a complete binary tree.
Explanation 2:

Because for the root node, left subtree has depth 2 and right subtree has depth 0.
Difference = 2 > 1.
* */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree r = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int result= r.isBalanced(root);
        System.out.println(result);
    }

    public int isBalanced(TreeNode A) {
        return getHeightPair(A).isBalanced ? 1 :0;
    }

    BinaryTreePair getHeightPair(TreeNode node){
        if(node ==null) return new BinaryTreePair(true, 0);
        BinaryTreePair left = getHeightPair(node.left);
        BinaryTreePair right = getHeightPair(node.right);
        if(left.isBalanced == false || right.isBalanced ==false){
            return new BinaryTreePair(false, -1);
        }
        if(Math.abs(left.height -right.height) > 1){
            return new BinaryTreePair(false, -1);
        }
        return new BinaryTreePair(true, Math.max(left.height,right.height) +1);
    }
}
