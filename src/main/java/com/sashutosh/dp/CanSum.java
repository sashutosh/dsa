package com.sashutosh.dp;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static boolean canSum(int sum, int[] nums) {
        if(sum== 0)
            return true;
        if(sum <0)
            return false;

        for(int num:nums){
            if(canSum(sum-num,nums))
                return true;
        }
        return false;
    }

    public static boolean canSumMemoize(int sum, int[] nums, Map<Integer, Boolean> memo) {
        if(memo.containsKey(sum))
            return memo.get(sum);
        if(sum== 0)
            return true;
        if(sum <0)
            return false;

        for(int num:nums){
            boolean result = canSumMemoize(sum - num, nums,memo);
            memo.put(sum,result);
            if(result)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,4,7};
        //int[] nums = {2,4};
        Map<Integer,Boolean> memo = new HashMap<>();
        System.out.println(CanSum.canSumMemoize(7,nums,memo));
    }
}
