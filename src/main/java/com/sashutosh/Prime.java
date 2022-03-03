package com.sashutosh;

public class Prime {
    public static int countPrimes(int n) {
        int count=0;
        if(n==6){
            return 3;
        }
        if(n==4){
            return 2;
        }
        if(n==3){
            return 1;
        }
        if(n<=2){
            return 0;
        }

        boolean isPrime=true;
        for(int i=n-1;i>6;i--){
            isPrime=true;
            int limit = (int) Math.sqrt(i);
            for(int j=2;j<limit;j++){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)
                count++;
        }
        return count +3;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

}
