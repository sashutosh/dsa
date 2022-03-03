package com.sashutosh.arrays;

public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] data = {20,100,10,12,5,13};
        increasingTriplet(data);
    }

    public static boolean increasingTriplet(int[] nums) {

        int minFirst=nums[0];
        int minMiddle = Integer.MAX_VALUE;

        for(int i=1;i<nums.length;i++){
            if(nums[i] <minFirst){
                nums[i] = minFirst;
                continue;
            }

            if (nums[i]==minFirst) {
                continue;
            }

            if(nums[i] > minMiddle){
                return true;
            }

            if(nums[i]<minMiddle){
                minMiddle=nums[i];
                //continue;
            }


        }

        return false;
    }
}
