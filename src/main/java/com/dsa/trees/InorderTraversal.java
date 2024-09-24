package com.dsa.trees;

import java.util.Stack;

/*
* Q1. Inorder Traversal

Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

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
 [1, 3, 2]
Output 2:
 [6, 1, 3, 2]

Example Explanation
Explanation 1:
 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:
 The Inorder Traversal of the given tree is [6, 1, 3, 2].

 You can do this problem easily with recursion, but recursion is not allowed here.

* */
public class InorderTraversal {
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
        Solution solution = new Solution();
        printArray(solution.inorderTraversal(root));
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


}

class Solution {
    public int[] inorderTraversal(TreeNode A) {
        int size=getSize(A);
        int[] result=new int[size];
        int index=0;
        Pair p=new Pair(A);
        Stack<Pair> stack=new Stack<>();
        stack.push(p);
        while(!stack.empty()){
            Pair top=stack.peek();
            int task=top.task;
            if(task==1){
                //add left
                top.task++;
                if(top.node.left!=null){
                    Pair temp=new Pair(top.node.left);
                    stack.push(temp);
                }
            }else if(task==2){
                top.task++;
                result[index++]=top.node.val;
            }else if(task==3){
                top.task++;
                if(top.node.right!=null){
                    Pair temp=new Pair(top.node.right);
                    stack.push(temp);
                }
            }else{
                stack.pop();
            }
        }
        return result;
    }
    public int getSize(TreeNode node){
        if(node==null){
            return 0;
        }
        int size= 1 + getSize(node.left) + getSize(node.right);
        return size;
    }
}

class Pair {
    TreeNode node;
    int task;
    Pair(TreeNode node) {
        this.node = node;
        task = 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}