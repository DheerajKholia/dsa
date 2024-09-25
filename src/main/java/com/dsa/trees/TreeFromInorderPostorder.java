package com.dsa.trees;

/*
 Binary Tree From Inorder And Postorder

Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Example Input
Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]
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
Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.

 */

public class TreeFromInorderPostorder {

        public static void main(String[] args) {
                TreeFromInorderPostorder solution = new TreeFromInorderPostorder();
                int[] inOrder = {6, 1, 3, 2};
                int[] postOrder = {6, 3, 2, 1};
                TreeNode root = solution.buildTree(inOrder, postOrder);
        }

        public TreeNode buildTree(int[] A, int[] B) {
                int n=A.length;
                return create(0,n-1,0,n-1,A,B);
        }

        private TreeNode create(int ps, int pe, int is, int ie,
                                int[] inOrder, int[] postOrder) {
                if (ps > pe || is > ie) return null;
                int rootValue = postOrder[pe];
                TreeNode root = new TreeNode(rootValue);
                int rootIndex = findRootIndex(inOrder, is, ie, rootValue);
                int noOfLeftTreeElements = rootIndex - is;
                root.left = create(ps, ps + noOfLeftTreeElements -1,
                        is, rootIndex -1, inOrder, postOrder);
                root.right = create(ps + noOfLeftTreeElements, pe-1,
                        rootIndex +1, ie, inOrder, postOrder);
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


