package com.sashutosh;

public class ShifterBinarySearch {
    public static void main(String[] args) {
        int[] array = {5, 23, 111, 1};
        int result = ShifterBinarySearch.shiftedBinarySearch(array, 111);
        System.out.println("Found result "+ result );
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.
        int index = findIndex(array);
        if(index == -1)
            index = array.length-1;
        System.out.println("Found index " + index);
        int result1 = binarySearch(0, index-1, array,target);
        if(result1!=-1)
            return result1;
        return binarySearch(index,array.length-1, array,target);

    }

    private static int findIndex(int[] array) {
        int prev = array[0];
        for(int i=1;i< array.length;i++) {
            int current = array[i];
            if(current < prev) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int start, int end, int[] array, int target) {


        int mid  = (start+end)/2;
        if(array[mid]== target)
            return mid;

        if(start > end)
            return -1;

        if(array[mid] < target)
            return binarySearch(mid+1, end, array, target);
        else
            return binarySearch(start, mid-1, array, target);

    }
}
