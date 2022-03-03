package com.sashutosh.tree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
    static class BST {
        BST left;
        BST right;
        int val;

        public BST(int val) {
            this.val = val;
        }
    }
    public static List<Integer> postOrderTraversal(BST tree,List<Integer> input) {
        if(tree==null)
            return input;
        postOrderTraversal(tree.left,input);
        postOrderTraversal(tree.right,input);
        input.add(tree.val);

        return input;
    }

    public static void main(String[] args) {
        BST tree= new BST(8);
        BST left= new BST(4);
        BST left1= new BST(3);
        BST left2= new BST(5);
        BST right= new BST(10);
        BST right1= new BST(9);
        BST right2= new BST(15);

        tree.left = left;
        tree.right = right;
        left.left = left1;
        left.right= left2;
        right.left= right1;
        right.right= right2;
        List<Integer> input = new ArrayList<>();
        postOrderTraversal(tree,input);
        System.out.println(input);

    }

}
