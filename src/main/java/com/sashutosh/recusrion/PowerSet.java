package com.sashutosh.recusrion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                List<Integer> list = new ArrayList<>(curr);
                list.add(num);
                newSubsets.add(list);

            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arrays = {1,2,3};
        List<List<Integer>> subsets = subsets(arrays);
        subsets.forEach(x -> {
            System.out.println("------");
            x.forEach(System.out::println);

        });
    }
}
