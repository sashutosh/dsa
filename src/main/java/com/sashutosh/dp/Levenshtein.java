package com.sashutosh.dp;

public class Levenshtein {

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] edits = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i< str2.length()+1;i++) {
            edits[0][i] = i;
        }
        for(int j=0;j< str1.length()+1;j++) {
            edits[j][0] = j;
        }

        for(int i=1;i< str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    edits[i][j] = edits[i-1][j-1];
                }
                else {
                    edits[i][j] = minimum(edits[i-1][j-1],edits[i-1][j], edits[i][j-1]);
                }
            }
        }


        return edits[str1.length()][str2.length()];
    }

    static int minimum(int i, int j, int k) {
        return Math.min(i, Math.min(j,k));
    }

    public static void main(String[] args) {
        int res = levenshteinDistance("abc","yabd");
        System.out.println(res);
    }
}
