package com.sashutosh;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int size = distances.length;
        int[] miles = new int[fuel.length];
        int foundIndex=0;
        for(int i=0;i<fuel.length;i++) {
            miles[i] = fuel[i]*mpg;
        }

        int balance = 0;
        for(int start=0;start<distances.length;start++) {
            balance=0;
            foundIndex=start;
            for(int i=start; i<start + size ;i++){
                int cur=i;
                if(cur>=size){
                    cur = i%size;
                }
                int nextDistance = distances[cur];
                balance+= miles[cur];
                //int miles = curfuel*mpg;
                if(balance < nextDistance) {
                    foundIndex=-1;
                    break;
                }
                else {
                    balance = balance - nextDistance;
                }
                if(foundIndex==start){
                    break;
                }
            }

        }
        return foundIndex;
    }
}
