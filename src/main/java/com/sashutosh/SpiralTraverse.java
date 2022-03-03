package com.sashutosh;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int srow = 0;
        int scol = 0;
        int erow = array.length-1;
        int ecol = array[0].length-1;
        spiralTraverse(array, srow, scol, erow,ecol,result);
        return result;
    }

    public static void spiralTraverse(int[][] array, int srow, int scol, int erow, int ecol, List<Integer> result) {
        System.out.println(srow);
        System.out.println(scol);
        if(scol<=ecol && srow<=erow) {
            for(int col = scol;col<=ecol;col++) {
                result.add(array[srow][col]);
            }
            for(int row = srow+1;row<=erow; row++) {
                result.add(array[row][ecol]);
            }
            for(int col = ecol-1;col>=scol; col--) {
                result.add(array[erow][col]);
            }
            for(int row = erow-1;row>=srow+1; row--) {
                result.add(array[row][scol]);
            }
            spiralTraverse(array, srow+1, scol+1, erow-1,ecol-1,result);
        }



    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{10,11,12,5},{9,8,7,6}};
        List<Integer> integers = spiralTraverse(matrix);
        System.out.println(integers);
    }
}
