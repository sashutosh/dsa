package com.sashutosh.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBst {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> getLeftTree(int root, List<Integer> values) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<values.size();i++) {
            if(values.get(i) < root) {
                result.add(values.get(i));
            }
            else {
                break;
            }
        }
        return result;
    }

    public ArrayList<Integer> getRightTree(int root, List<Integer> values) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1;i<values.size();i++) {
            if(values.get(i) > root) {
                result.add(values.get(i));
            }

        }
        return result;
    }
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        if(preOrderTraversalValues.size()>0)
            return null;

        int root = preOrderTraversalValues.get(0);
        ArrayList<Integer> left = getLeftTree(root,preOrderTraversalValues);
        ArrayList<Integer> right = getRightTree(root,preOrderTraversalValues);

        BST tree = new BST(root);
        tree.left = reconstructBst(left);
        tree.right = reconstructBst(right);

        return tree;
    }

    public void reconstructBst(BST root, List<Integer> preOrderTraversalValues) {

        if(preOrderTraversalValues==null || preOrderTraversalValues.size()==0) {
            return;
        }

        int rootVal = preOrderTraversalValues.get(0);
        List<Integer> left = getLeftTree(rootVal,preOrderTraversalValues);
        List<Integer> right = getRightTree(rootVal,preOrderTraversalValues);

        //BST root = new BST(rootVal);
        if(left.size() > 0){
            root.left = new BST(left.remove(0));
            reconstructBst(root.left,left);
        }
        if(right.size() > 0) {
            root.right = new BST(right.remove(0));
            reconstructBst(root.right, right);
        }
    }

    public static void main(String[] args) {
        ReconstructBst rb = new ReconstructBst();
        List<Integer> values  = Arrays.asList(2, 0, 1, 4, 3, 3);
        ArrayList<Integer> data = new ArrayList<>(values);
        rb = new ReconstructBst();
        BST bst = rb.reconstructBst(data);
        System.out.println(bst);
    }

}
