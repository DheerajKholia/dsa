package com.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Q4. Level Order
Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format

Return a 2D integer array denoting the level order traversal of the given binary tree.

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
   [9, 20],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]

Example Explanation
Explanation 1:
Return the 2D array. Each row denotes the traversal of each level.
* */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal r = new LevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> result= r.solve(root);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> result =new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> levelItems = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                levelItems.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            result.add(levelItems);
        }
        return result;
    }
}
