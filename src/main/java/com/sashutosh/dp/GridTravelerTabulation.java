package com.sashutosh.dp;

public class GridTravelerTabulation {
    public int gridTraveler(int m,int n){
        int[][] grid = new int[m+1][n+1];
        grid[0][0]=0;
        grid[1][1]=1;
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                int current = grid[i][j];
                if(j+1<=n ) grid[i][j+1]+=current;
                if(i+1<=n)  grid[i+1][j]+=current;
            }
        }

        return grid[m][n];
    }

    public static void main(String[] args) {
        GridTravelerTabulation gtt = new GridTravelerTabulation();
        int res = gtt.gridTraveler(3, 3);
        System.out.println(res);
    }
}
