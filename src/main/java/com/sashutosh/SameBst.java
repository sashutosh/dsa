package com.sashutosh;

import java.util.*;

class SameBst {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        return checkSubTree(arrayOne, arrayTwo, 0);
        //return false;
    }

    private static boolean checkSubTree(List<Integer> arrayOne, List<Integer> arrayTwo, int index) {
        if(arrayOne.size()==0 && arrayTwo.size()==0)
            return true;

        if(arrayOne.size()!=arrayTwo.size() || arrayOne.get(index)!=arrayTwo.get(index))
            return false;

        else {
            List<Integer> left1 = getLeftChild(arrayOne,index);
            List<Integer> right1 = getRightChild(arrayOne,index);
            List<Integer> left2 = getLeftChild(arrayTwo,index);
            List<Integer> right2 = getRightChild(arrayTwo,index);
            return checkSubTree(left1,left2,0) && checkSubTree(right1,right2,0);
        }
    }

    private  static List<Integer> getLeftChild(List<Integer> arrayOne,int index){
        int count=0;
        List<Integer> result = new ArrayList<>();
        for(Integer val : arrayOne) {
            if(count==0) {
                count++;
                continue;
            }
            count++;
            if(val < arrayOne.get(index)){
                result.add(val);
            }
        }
        return result;
    }

    private  static List<Integer> getRightChild(List<Integer> arrayOne,int index){
        int count=0;
        List<Integer> result = new ArrayList<>();
        for(Integer val : arrayOne) {
            if(count==0) {
                count++;
                continue;

            }
            count++;
            if(val >= arrayOne.get(index)){
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 10);
        List<Integer> arrayTwo = Arrays.asList(10, 8, 5, 15, 2, 10, 12, 94, 81);
        boolean result = SameBst.sameBsts(arrayOne, arrayTwo);
        System.out.printf("Result is " + result);
    }

}

