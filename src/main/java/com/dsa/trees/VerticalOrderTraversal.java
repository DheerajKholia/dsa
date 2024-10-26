package com.dsa.trees;

import java.util.*;

/*
Q2. Vertical Order traversal
Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it.
Go through the example and image for more details.
NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser
depth will come first.

Problem Constraints
0 <= number of nodes <= 105

Input Format
First and only arument is a pointer to the root node of binary tree, A.
Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.

Example Input
Input 1:
      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:
      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:
 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation

Explanation 1:

 First row represent the verical line 1 and so on.
* */
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        VerticalOrderTraversal r = new VerticalOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> result= r.verticalOrderTraversal(root);
        for(List<Integer> i : result){
//            System.out.println(i);
            i.forEach(System.out::print);
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
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
            result.add(map.get(i));
        }
        return result;
    }
}
