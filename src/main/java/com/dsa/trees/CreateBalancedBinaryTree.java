package com.dsa.trees;

/*
Q2. Sorted Array To Balanced BST

Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints

1 <= length of array <= 100000

Input Format

First argument is an integer array A.

Output Format

Return a root node of the Binary Search Tree.

Example Input

Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output

Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation

Explanation 1:

 You need to return the root node of the Binary Tree.
* */
public class CreateBalancedBinaryTree {
    public static void main(String[] args) {
        CreateBalancedBinaryTree r = new CreateBalancedBinaryTree();

        int[] arr= new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root= r.sortedArrayToBST(arr);
        System.out.println(root);
    }

    public TreeNode sortedArrayToBST(final int[] A) {
        return create(A, 0, A.length-1);
    }
    private TreeNode create(int[] arr, int s, int e){
        if(s>e) return null;
        int mid = (s+e)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = create(arr, s, mid-1);
        node.right = create(arr, mid+1, e);
        return node;
    }
}
