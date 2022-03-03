package com.sashutosh.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
    public static int travelWays(int m, int n){
        if(m==1 && n==1) return 1;
        if(m==0|| n==0) return 0;
        int i = travelWays(m - 1, n) + travelWays(m, n - 1);
        return i;

    }

    private static String getKey(int m, int n) {
        return m + "," + n;
    }

    public static void main(String[] args) {
        Map<String,Integer> memo = new HashMap<>();
        System.out.println(GridTraveler.travelWays(3,2));
    }
}
