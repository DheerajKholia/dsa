package com.dsa.trees;

import java.util.*;

/*
Q1. Right View of Binary tree
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.


Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the right view of the binary tree.

Example Input

Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5


Example Output

Output 1:

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]
* */
public class RightView {
    public static void main(String[] args) {
        RightView r = new RightView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] result= r.solve(root);
        for(int i : result){
            System.out.println(i);
        }
    }

    public int[] solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == size - 1){
                    resultList.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
