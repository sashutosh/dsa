package com.sashutosh.tree;

import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.left = new Tree(-10);

        tree.left.right = new Tree(8);
        tree.left.right.left = new Tree(6);
        tree.left.right.right = new Tree(9);

        tree.right = new Tree(30);
        tree.right.left = new Tree(25);
        tree.right.left.right = new Tree(28);
        tree.right.right = new Tree(60);
        tree.right.right.right = new Tree(60);

        int res = findLCA(tree,28,78);
        System.out.println(res);

        res = findLCA(tree,6,9);
        System.out.println(res);

        res = findLCA(tree,30,78);
        System.out.println(res);

    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
        }
    }
    
    public static int findLCA(Tree tree, int num1,int num2) {
        if(tree.value > num1 && tree.value <num2 ){
            return tree.value;
        }
        else if(tree.value < num1 && tree.value <num2 )
            return findLCA(tree.right,num1,num2);
        else if(tree.value > num1 && tree.value> num2 ) {
            return findLCA(tree.left,num1,num2);
        }
        if(tree.value==num1)
            return num1;
        if(tree.value==num2)
            return num2;

        return Integer.MIN_VALUE;
    }
    
}
