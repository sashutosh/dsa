package com.sashutosh.arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayCompression {
    //2,3,3,7,3,5
    int compress(List<Integer> array, int k){
        int res =1;
        int size =1;
        int i=0;
        while(i < array.size()-1){
            res =array.get(i);
            for(int j=i+1;j<array.size();j++) {
                res = res * array.get(j);
                if(res > k) {
                    size = size+1;
                    i=j;
                    break;
                }
            }
            if(i==array.size()-1)
            break;
        }
        if(res<size) {
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        ArrayCompression ac = new ArrayCompression();
        List<Integer> result = Arrays.asList(2,3,3,7,3,5);
        int compress = ac.compress(result, 20);
        System.out.println(compress);
    }
}
