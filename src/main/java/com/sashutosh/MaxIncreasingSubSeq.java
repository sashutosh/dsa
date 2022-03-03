package com.sashutosh;

import java.util.*;
import java.util.stream.*;

class MaxIncreasingSubSeq {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        List<List<Integer>> finalres = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        for(int i =0; i< array.length;i++ ){

            int prev=array[i];

            for(int j=i+1;j< array.length;j++) {
                prev= array[i];
                List<Integer> values = new ArrayList<>();
                values.add(prev);
                int index =j;
                int current = array[index];
                while(index < array.length) {
                    if(current > prev) {
                        values.add(current);
                        prev = current;
                    }
                    index++;
                    if(index < array.length)
                        current = array[index];
                }
                System.out.println(values);
                results.add(values);
            }
        }
        int max = Integer.MIN_VALUE;
        int index =0;
        int cur=0;
        for(List<Integer> array1: results) {
            int cursum = array1.stream().collect(Collectors.summingInt(Integer::intValue));
            if ( cursum> max) {
                index =cur;
                max = cursum;
            }
            cur++;
        }

        finalres.add(List.of(max));
        finalres.add(results.get(index));
        return finalres;
    }

    public static void main(String[] args) {
        //int[] array = {10, 70, 20, 30, 50, 11, 30};
        int[] array = {10, 15, 4, 5, 11, 14, 31, 25, 31, 23, 25, 31, 50};
        List<List<Integer>> lists = MaxIncreasingSubSeq.maxSumIncreasingSubsequence(array);
        System.out.println(lists);

    }
}
