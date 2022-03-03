package com.sashutosh;

import java.util.Arrays;

/*
* Given an array of size n containing odd and even numbers. Count of even and odd numbers might not be equal. Arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index. Remaining numbers can go to end of the array in any order.

Input : 3, 6, 12, 1, 5, 8

Output : 6, 3, 12, 1, 8, 5
*/
public class Program1 {

    public static void sort(int[] array) {

        for(int i=0;i<array.length;i++) {
            if(i%2==0 && array[i]%2!=0) {
                swapEven(array,i);
            }
            if(i%2!=0 && array[i]%2==0) {
                swapOdd(array,i);
            }
        }
    }

    private static void swapOdd(int[] array, int i) {

        for(int cur=i+1;cur<array.length;cur=cur+2) {
            if(array[cur]%2!=0) {
                int temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
                break;
            }
        }
    }

    private static void swapEven(int[] array, int i) {
        for(int cur=i+1;cur<array.length;cur=cur+2) {
            if(array[cur]%2==0) {
                int temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] data = {3, 6, 12, 1, 5, 8};
        sort(data);
        //for(int i=0;i<data.length;i)
        System.out.println(Arrays.toString(data));
    }

}
