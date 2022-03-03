package com.sashutosh.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        tree.left = new Tree("B");
        tree.right = new Tree("C");
        tree.left.left = new Tree("D");
        tree.left.right = new Tree("E");
        tree.right.right = new Tree("F");
        List<List<String>> lists = allPaths(tree);
        System.out.println(lists);

    }

    static class Tree {
        String value;
        Tree left;
        Tree right;

        public Tree(String value) {
            this.value = value;
        }
    }

    public static List<List<String>> allPaths1(Tree root) {
        List<List<String>> result = new ArrayList<>();
        allPaths(root,result);
        return result;
    }

    private static void allPaths(Tree root, List<List<String>> result) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            for (List<String> list:result
                 ) {
                 list.add(0,root.value);
            }
        }
        allPaths(root.left,result);
        allPaths(root.right,result);
    }

    public static List<List<String>> allPaths(Tree root) {
        if(root==null) {
            /*ArrayList<String> list1= new ArrayList();
            ArrayList<List<String>> outer = new ArrayList<>();
            outer.add(list1);
            return outer;*/
            return null;
        }

        if(root.left == null && root.right==null) {
            ArrayList<String> list1= new ArrayList();
            list1.add(root.value);
            ArrayList<List<String>> outer = new ArrayList<>();
            outer.add(list1);
            return outer;
        }
        List<List<String>> result = new ArrayList<>();
        List<List<String>> left = allPaths(root.left);
        List<List<String>> right = allPaths(root.right);
        if(left!=null) {
            for (List<String> lp : left) {
                lp.add(0, root.value);
                result.add(lp);
            }
        }
        if(right!=null) {
            for (List<String> rp : right) {
                rp.add(0, root.value);
                result.add(rp);
            }
        }
        return result;
    }

}
