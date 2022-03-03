package com.sashutosh.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] data = {1,1,1,2,2,3};
        int[] res = topKFrequent(data,2);
        System.out.println(res);
    }
    public static  int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            }
            else{
                int cur = map.get(nums[i]);
                map.put(nums[i],cur+1);
            }
        }
        int sz = map.size();
        int[][] data= new int[sz][2];
        int cur=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            data[cur][0] = entry.getKey();
            data[cur][1] = entry.getValue();
            cur++;
        }

        Arrays.sort(data, Comparator.comparingInt(o -> o[1]));

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = data[i][0];
            //res[i][1] = data[i][1];
        }
        return res;
    }

}
