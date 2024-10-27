package com.dsa.trees;

import java.util.*;

/*
Q1. ZigZag Level Order Traversal BT

Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:
   1
  / \
 6   2
    /
   3


Example Output
Output 1:
 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:
 [
   [1]
   [2, 6]
   [3]
 ]


Example Explanation

Explanation 1:

 Return the 2D array. Each row denotes the zigzag traversal of each level.
* */
public class ZigzagTraversal {
    public static void main(String[] args) {
        ZigzagTraversal r = new ZigzagTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> result= r.zigzagLevelOrder(root);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        q.add(A);
        boolean reverseList = false;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList levelItems = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                levelItems.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(reverseList){
                Collections.reverse(levelItems);
            }
            reverseList = !reverseList;
            result.add(levelItems);
        }
        return result;
    }
}
