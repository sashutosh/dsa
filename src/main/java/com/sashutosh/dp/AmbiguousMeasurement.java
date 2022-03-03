package com.sashutosh.dp;

public class AmbiguousMeasurement {
    public static void main(String[] args) {
        int[][] cups  = {{1,3},{2,4},{5,6}};
        AmbiguousMeasurement a = new AmbiguousMeasurement();
        boolean result = a.ambiguousMeasurements(cups,6,9);
        System.out.println(result);
    }
    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        // Write your code here.
        int[][] cup = new int[1][2];
        int[][] cur = new int[1][2];
        cur[0][0] = 0;
        cur[0][1] = 0;

        cup[0][0] = low;
        cup[0][1] = high;
        return measure(measuringCups,cur, cup);

    }

    private boolean measure(int[][] cups, int[][] cur, int[][]cup)
    {
        if(cur[0][1] > cup[0][1])
            return false;
        if(cur[0][0] >= cup[0][0] && cur[0][1] <= cup[0][1])
            return true;

        System.out.println(cur[0][0] +"," +cur[0][1]);
        for(int i=0; i< cups.length; i++) {
            cur[0][0] = cur[0][0] + cups[i][0];
            cur[0][1] = cur[0][1] + cups[i][1];
            if(measure(cups,cur,cup)==true) {
                return true;
            }
        }
        return false;
    }
}
