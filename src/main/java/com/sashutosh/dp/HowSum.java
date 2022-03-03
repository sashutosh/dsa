package com.sashutosh.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static List<Integer> howSum(int sum, int[] nums) {

        if(sum==0)
            return new ArrayList<>();
        if(sum < 0)
            return null;

        List<Integer> result =null;
        for (Integer num:nums) {
            result = howSum(sum - num, nums);
            if(result!=null) {
                result.add(num);
                return result;
            }

        }
        return null;
    }

    public static List<Integer> howSumMemoize(int sum, int[] nums, Map<Integer, List<Integer>> memo) {

        if(memo.containsKey(sum))
            return memo.get(sum);
        if(sum==0)
            return new ArrayList<>();
        if(sum < 0)
            return null;

        List<Integer> result =null;
        for (Integer num:nums) {
            result = howSumMemoize(sum - num, nums,memo);
            memo.put(sum,result);
            if(result!=null) {
                result.add(num);
                return result;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,4};
        //int[] nums = {2,4};
        Map<Integer,Boolean> memo = new HashMap<>();
        Map<Integer, List<Integer>> integerListMap = new HashMap<>();
        List<Integer> integers = HowSum.howSumMemoize(7, nums, integerListMap);
        for (Integer integer:integers)
            System.out.println(integer);
    }

}
