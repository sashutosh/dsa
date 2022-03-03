package com.sashutosh;

public class MedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double median =0.0;
        //mid = (len1+len2-1)/2;
        int i = len1/2;
        int j = (len1+len2)/2 -i;
        if(len1 ==1) {
            return merge(nums2,nums1);
        }
        if(len2==1) {
            return merge(nums1,nums2);
        }
        while((nums1[i-1] > nums2[j+1]) || (nums2[j-1] > nums1[i+1])) {

            if(nums1[i-1] > nums2[j+1]){
                i = i-1;
                j = (len1+len2+1)/2 -i;
            }
            else {
                i = i+1;
                j=(len1+len2)/2 -i;
            }

        }
        if((len1+len2)%2==0){
            median = (Math.max(nums1[i-1] , nums2[j-1]) + Math.min(nums1[i+1], nums2[j+1]))/2;

        }
        else {
            median = Math.max(nums1[i], nums2[j-1]);
        }
        return median;
    }

    private double merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+1];
        int len = nums.length;
        int i=0;
        //
        if(nums2[0] <= nums1[0]){
            nums[0] = nums2[0];
            for( i=1;i< nums.length;i++) {
                nums[i] = nums1[i];
            }
        }
        else {
            while( i< nums1.length && nums1[i] < nums2[0] ) {
                nums[i] = nums1[i];
                i++;
            }
            nums[i] = nums2[0];
            int k= i;
            for(int j=k; j< nums1.length;j++) {
                nums[j+1] = nums1[k++];
            }
        }
        if(len%2== 0) {
            return (nums[(len/2)-1] + nums[(len/2)])/2;

        }
        else {
            return nums[(len/2)];
        }
    }

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        x= Integer.MAX_VALUE;
        System.out.println(x);
        MedianSortedArray ms = new MedianSortedArray();
       /* int[] a1 = {1,3,8,9,15};
        int[] a2 = {7,11,18,19,21,25}; //1,3,7,8,9,11,15,19,21,25*/
        int[] a1 = {1,2};
        int[] a2 = {3};
        double val = ms.findMedianSortedArrays(a1,a2);
        System.out.println(val);
    }
}
