package com.sashutosh.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute2 {

    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        Permute2 permute2 = new Permute2();
        List<List<Integer>> result = permute2.permute(numbers);
        System.out.println(result.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer num:nums) {
            numbers.add(num);
        }
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();
        permuteHelper(numbers,current,permutations);
        return permutations;
    }

    private void permuteHelper(List<Integer> numbers, List<Integer> current, List<List<Integer>> permutations) {
        if(numbers.size()==0) {
            permutations.add(current);
            return;
        }

        for(int i=0;i< numbers.size();i++) {
            List<Integer> cloned = getCopy((numbers));
            int cur = cloned.remove(i);
            List<Integer> newPer = new ArrayList<>(current);
            newPer.add(cur);
            permuteHelper(cloned,newPer,permutations);
        }

    }

    private List<Integer> getCopy(List<Integer> numbers) {
        List<Integer> cloned = new ArrayList<>();
        for (int i:numbers
             ) {
            cloned.add(i);
        }
        return cloned;
    }
}
