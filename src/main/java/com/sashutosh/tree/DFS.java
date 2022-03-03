package com.sashutosh.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DFS {

    static class BinaryTree{
        BinaryTree left;
        BinaryTree right;
        int val;
        public BinaryTree(int val) {
            this.val=val;
        }
    }
    public static void dfs(BinaryTree tree, List<Integer> res) {
        if(tree==null)
            return;;

        res.add(tree.val);
        if(tree.left!=null) dfs(tree.left,res);
        if(tree.right!=null) dfs(tree.right,res);


    }

    public static List<Integer> dfs_rec(BinaryTree tree) {
        List<Integer> result = new ArrayList<>();
        if(tree==null)
            return null;

        result.add(tree.val);
        List<Integer> left = dfs_rec(tree.left);
        List<Integer> right = dfs_rec(tree.right);


        if(result!=null) {
            if(left!=null) result.addAll(left);
            if(right!=null) result.addAll(right);
        }
        return result;
    }

    //Time complexity # O(n) space complexity O(n)
    public static List<Integer> bfs(BinaryTree tree) {
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTree> queue = new ArrayDeque<>();
        queue.add(tree);

        while(!queue.isEmpty()) {
            BinaryTree cur = queue.remove();
            result.add(cur.val);
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
        }
        return result;
    }
    static int max = Integer.MIN_VALUE;
    public static void maxPathSum(BinaryTree tree, int cursum) {
        if(tree==null)
            return;
        if(tree.left==null && tree.right==null){
            cursum= cursum + tree.val;
            if(cursum>max) {
                max = cursum;
            }
            return;
        }
        maxPathSum(tree.left,cursum+ tree.val);
        maxPathSum(tree.right,cursum+ tree.val);
    }

    public static void main(String[] args) {
        BinaryTree n1 = new BinaryTree(10);
        BinaryTree n2 = new BinaryTree(5);
        BinaryTree n3 = new BinaryTree(7);
        n1.left = n2;
        n1.right = n3;
        BinaryTree n4 = new BinaryTree(8);
        BinaryTree n5 = new BinaryTree(9);
        n2.left=n4;
        n2.right=n5;
        BinaryTree n6 = new BinaryTree(6);
        n3.right=n6;

        List<Integer> res = new ArrayList<>();
        //dfs(n1,res);
        //res =dfs_rec(n1);
        //res = bfs(n1);
        //System.out.println(res);

        maxPathSum(n1,0);
        System.out.println(max);

    }

}
