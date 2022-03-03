package com.sashutosh.tree;

public class ValidateBST {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left =new BST(5);
        bst.left.left =new BST(2);
        bst.left.right =new BST(5);
        bst.left.right.right =new BST(11);

        bst.left.left.left =new BST(1);

        bst.right =new BST(15);
        bst.right.left=new BST(22);

        boolean b = validateBst(bst);
        System.out.println(b);
    }

    public static boolean validateBst(BST tree) {
        // Write your code here.
        if(tree==null)
            return true;
        if(tree.left==null && tree.right==null)
            return true;

        boolean lvalid=true;
        boolean rvalid=true;
        if(tree.left!=null && tree.value > tree.left.value)
            lvalid = validateBst(tree.left);
        else if(tree.left==null)
            return true;
        else return false;

        if(tree.right!=null && tree.value <= tree.right.value)
            rvalid = validateBst(tree.right);
        else if(tree.right==null)
            return true;
        else{
            return false;
        }



        return lvalid&&rvalid;

    }




    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
