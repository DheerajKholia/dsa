package com.dsa.trees;

import java.util.*;

/*
Q4. Top View of Binary tree
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the top view of the binary tree.

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

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation

Explanation 1:

Top view is described.
Explanation 2:

Top view is described.
* */
public class TopView {
    public static void main(String[] args) {
        TopView r = new TopView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> result= r.solve(root);
        for(Integer i : result){
            System.out.println(i);
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int minLevel=0, maxLevel =0;
        Queue<PairWithVerticalLevel> queue = new LinkedList<>();
        queue.add(new PairWithVerticalLevel(A,0));

        while(!queue.isEmpty()){
            PairWithVerticalLevel pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
            if(map.containsKey(level)) {
                map.get(level).add(node.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(level, list);
            }
            if(node.left != null) queue.add(new PairWithVerticalLevel(node.left, level-1));
            if(node.right != null) queue.add(new PairWithVerticalLevel(node.right, level+1));
        }
        for(int i = minLevel; i <= maxLevel; i++){
            result.add(map.get(i).get(0));
        }
        return result;
    }
}
