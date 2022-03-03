package com.sashutosh;

import java.util.HashSet;
import java.util.*;

public class LargestRange {

    public static void main(String[] args) {
        int[] input = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] ints = largestRange(input);
        System.out.println(ints);
    }
    public static int[] largestRange(int[] array) {
        // Write your code here.
        int max=Integer.MIN_VALUE;int min=Integer.MAX_VALUE;
        Set<Integer> integers = new HashSet<>();
        if(array.length==1) {
            int[] res = {array[0],array[0]};
            return res;
        }
        for(int i=0;i<array.length;i++){
            if(array[i] > max ) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
            integers.add(array[i]);

        }
        int max_length=0;
        int curMax=1;
        int[] res = new int[2];
        for(int num =0;num < array.length;num++) {

            int cur = array[num];
            List<Integer> temp = new ArrayList<>();
            temp.add(cur);
            for(int i=cur+1;i<=max;i++) {
                if(integers.contains(i)) {
                    temp.add(i);
                }
                else{
                    if(temp.size()> curMax) {
                        res[0] = cur;
                        res[1] = temp.get(temp.size()-1);
                        curMax= temp.size();

                    }
                    break;
                }
            }
        }


        return res;
    }
}
