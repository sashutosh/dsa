package com.sashutosh.recusrion;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        int[] array = {1,2,3};
        Permute permute = new Permute();
        List<List<Integer>> result = permute.permute(array);
        System.out.println(result);
    }
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result) {
        if(start==nums.length-1){
            List<Integer> current = new ArrayList<>();
            for(int num:nums){
                current.add(num);
            }
            result.add(current);
        }

        for(int cur=start;cur<nums.length;cur++) {
            swapNum(cur,start,nums);
            helper(start+1,nums,result);
            swapNum(cur,start,nums);
        }
    }

    private void swapNum(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
