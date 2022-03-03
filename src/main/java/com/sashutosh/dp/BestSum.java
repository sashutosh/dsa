package com.sashutosh.dp;

import java.util.ArrayList;
import java.util.List;

public class BestSum {
    public static List<Integer> bestSum(int sum, int[] nums) {
        if(sum==0) return new ArrayList<>();
        if(sum < 0) return null;

        List<Integer> result = null;
        for (int num:nums) {
            List<Integer> current = bestSum(sum-num,nums);
            if(current!=null) {
                current.add(num);
                if(result ==null || current.size() < result.size())
                    result = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,4,7};
        List<Integer> integers = BestSum.bestSum(7, nums);
        integers.forEach(System.out::println);
    }
}
