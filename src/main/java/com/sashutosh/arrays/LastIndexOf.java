package com.sashutosh.arrays;

public class LastIndexOf {

    public static void main(String[] args) {
        int[] array = {1,1,1,3,3,4,5,5,5};
        int result = lastIndexOf(array, 1);
        System.out.println(result);
    }

    private static int lastIndexOf(int[] array, int item) {
        int start = 0; int end = array.length-1;
        boolean found=false;
        int index=-1;
        while(start <=end) {
            int mid = (start + end) / 2;
            if(array[mid]==item){
                found=true;
                index=mid;
                break;
            }
            if(array[mid] > item) {
                end =mid-1;
            }
            else {
                start =mid+1;
            }

        }
        if(found) {
            int cur =index++;
            while(array[cur]==item) {
                cur++;
            }
            return --cur;
        }
        return index;
    }
}
