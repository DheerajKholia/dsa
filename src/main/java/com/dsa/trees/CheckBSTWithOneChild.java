package com.dsa.trees;

import java.util.ArrayList;

/*
Q1. Check for BST with One Child

Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

Problem Constraints

1 <= number of nodes <= 100000

Input Format

First and only argument is an integer array denoting the preorder traversal of binary tree.

Output Format

Return a string "YES" if true else "NO".

Example Input

Input 1:

 A : [4, 10, 5, 8]
Input 2:

 A : [1, 5, 6, 4]


Example Output

Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation

Explanation 1:

 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:

 There is no possible BST which have the above preorder traversal.

* */
public class CheckBSTWithOneChild {
    public static void main(String[] args) {
        CheckBSTWithOneChild r = new CheckBSTWithOneChild();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(5);
        list.add(8);
        String result= r.solve(list);
        System.out.println(result);
    }

    public String solve(ArrayList<Integer> A) {
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
        int root = A.get(0);
        for(int i=1;i<A.size();i++){
            if(A.get(i) < root){
                r = root;
            }else{
                l = root;
            }
            if(A.get(i) < l || A.get(i) > r ){
                return "NO";
            }
            root = A.get(i);
        }
        return "YES";
    }
}
