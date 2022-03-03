package com.sashutosh.arrays;

public class LongestSequence {
    public static void main(String[] args) {
        int[] seq = {0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(seq);
        System.out.println(i);
    }
    public static int longestConsecutive(int[] nums) {
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] < min) {
                min=nums[i];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }
        //int sz = max-min;
        int[] data1 = new int[max+1];
        for(int i=0;i<nums.length;i++) {
            data1[nums[i]] = 1;
        }
        boolean started=false;
        int curCount=0;
        int maxCount =0;
        for(int i=0;i< data1.length;i++){

            if(data1[i]==1) {
                if(started==true) {
                    curCount++;

                }
                else{
                    started=true;
                    curCount=1;
                }
            }
            else {
                if (curCount > maxCount) {
                    maxCount = curCount;
                }
                started = false;
                curCount = 0;
            }
        }
        return maxCount;
    }
}
