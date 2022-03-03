package com.sashutosh.dp;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        waterArea(heights);
    }
    public static int waterArea(int[] heights) {
        // Write your code here.
        if(heights.length==0)
            return 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int[] water = new int[heights.length];
        populateLeft(left,heights);
        populateRight(right,heights);
        populateWater(left,right,heights, water);
        int area = calculateArea(water);
        return area;
    }

    private static int calculateArea(int[] water) {
        int sum =0;
        for(int i=0;i<water.length;i++) {
            sum+=water[i];
        }
        return sum;

    }
    private static void populateWater(int[] left, int[] right, int[] height, int[] water) {

        for(int i=0;i<height.length;i++) {
            int minH = Math.min(left[i],right[i]);
            if(height[i] < minH ) {
                water[i] = minH-height[i];
            }
            else{
                water[i] =0;
            }
        }
    }

    private static void populateLeft(int[] left, int[] height) {
        int max=height[0];
        left[0] =0;
        for(int i=1;i<left.length;i++) {
            left[i] = max;
            if(height[i] > max) {
                max =height[i];
            }
        }
        //System.out.println(left);
    }

    private static void populateRight(int[] right, int[] height) {
        int max=height[height.length-1];
        right[height.length-1] =0;
        for(int i=height.length-2;i>=0;i--) {
            right[i] = max;
            if(right[i] > max) {
                max =right[i];
            }

        }
    }
}
