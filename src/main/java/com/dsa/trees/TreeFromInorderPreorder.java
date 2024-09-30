package com.dsa.trees;

/*
  Binary Tree From Inorder And Preorder
Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105
Input Format
First argument is an integer array A denoting the preorder traversal of the tree.
Second argument is an integer array B denoting the inorder traversal of the tree.
Output Format
Return the root node of the binary tree.

Example Input
Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]
Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1
  / \
 6   2
    /
   3

 */

public class TreeFromInorderPreorder {

        public static void main(String[] args) {
                TreeFromInorderPreorder solution = new TreeFromInorderPreorder();
                int[] inOrder = {6, 1, 3, 2};
                int[] postOrder = {6, 3, 2, 1};
                TreeNode root = solution.buildTree(inOrder, postOrder);
        }

        public TreeNode buildTree(int[] A, int[] B) {
                int n = A.length;
                return getTreeFromPreInOrder(0, n-1, 0, n-1, A, B);
        }
        TreeNode getTreeFromPreInOrder(int ps, int pe, int is, int ie,int[] preOrder, int[] inOrder) {
                if (ps > pe || is > ie) return null;
                TreeNode root = new TreeNode(preOrder[ps]);
                int rootIndexInorder = findRootIndex(inOrder,is, ie, root.val);
                int elementsInLeftSubtree = rootIndexInorder - is;
                root.left = getTreeFromPreInOrder(ps+1, ps+elementsInLeftSubtree, is,rootIndexInorder-1, preOrder,inOrder);
                root.right = getTreeFromPreInOrder(ps+elementsInLeftSubtree+1, pe, rootIndexInorder+1,ie, preOrder, inOrder);
                return root;
        }

        private int findRootIndex(int[] inOrder, int start, int end, int value) {
                for(int i=start;i<=end;i++){
                        if(inOrder[i]==value){
                                return i;
                        }
                }
                return -1;
        }
}


