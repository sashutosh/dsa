package com.sashutosh.tree;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(11);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(2);
        tree.right.right = new Tree(1);
        /*int result = maxPathSum(tree);
        System.out.println(result);*/
        List<Integer> leaves = leafs(tree);
        System.out.println(leaves);

    }
    private static int maxPathSum(Tree tree) {
        if(tree==null) {
            return Integer.MIN_VALUE;
        }
        if(tree.left==null && tree.right== null)
            return tree.value;

        int left = maxPathSum(tree.left);
        int right = maxPathSum(tree.right);
        int max  = Math.max(left, right);
        return max + tree.value;
    }

    private static List<Integer> leafs(Tree tree) {
        List<Integer> leafNodes = new ArrayList<>();
        getLeafs(tree,leafNodes);
        return leafNodes;

    }

    private static void getLeafs(Tree tree, List<Integer> leafs) {
        if(tree==null)
            return;
        if(tree.left==null && tree.right==null) {
            leafs.add(tree.value);
            return;
        }
        getLeafs(tree.left,leafs);
        getLeafs(tree.right,leafs);
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
        }
    }

}
