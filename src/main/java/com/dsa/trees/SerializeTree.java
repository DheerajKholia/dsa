package com.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Q2. Serialize Binary Tree

Problem Description
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints

1 <= number of nodes <= 105

Input Format
Only argument is a A denoting the root node of a Binary Tree.

Output Format
Return an integer array denoting the Level Order Traversal of the given Binary Tree.

Example Input

Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output

Output 1:

 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2:

 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Explanation

Explanation 1:

 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
* */
public class SerializeTree {
    public static void main(String[] args) {
        SerializeTree r = new SerializeTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> result = r.solve(root);
        System.out.println(result);
    }

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(A);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result.add(-1);
            } else {
                result.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
        return result;
    }
}
