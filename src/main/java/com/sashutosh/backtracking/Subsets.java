package com.sashutosh.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /*public static void findSubsets(List<List<Integer>> subset, List<Integer> nums, List<Integer> output, int index)
    {
        // Base Condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }*/
    public static List<List<String>> subsets(ArrayList<String> inputs){
        List<List<String>> results = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        subsetHelper(inputs,current,results);
        return results;
    }

    private static void subsetHelper(ArrayList<String> inputs,ArrayList<String> current,List<List<String>> results) {
        if(inputs.isEmpty()) {
            results.add((List<String>) current.clone());
            return;
        }

        String val = inputs.remove(0);
        current.add(val);
        subsetHelper(inputs,current,results);

        current.remove(current.size()-1);
        subsetHelper(inputs,current,results);
        inputs.add(0,val);
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> nums = Arrays.asList(1,2);
        ArrayList<String> inputs = new ArrayList<>();//(ArrayList<String>) Arrays.asList("S","R","P");
        inputs.add("S");
        inputs.add("R");
        inputs.add("P");
        List<Integer> outputs = new ArrayList<>();
        //findSubsets(subsets,nums,outputs,0);
        List<List<String>> subsets1 = subsets(inputs);
        System.out.println(subsets1);
    }
}
