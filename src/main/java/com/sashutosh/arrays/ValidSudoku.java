package com.sashutosh.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> rows = new ArrayList<>();
        //List<Set<Character>> squares = new ArrayList<>();
        Set<Character>[][] squares = new Set[3][3];

        for(int i=0;i<9;i++) {
            cols.add(new HashSet<>());
            rows.add(new HashSet<>());
        }

        for (int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                squares[i][j]= new HashSet<>();
            }
        }

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
               if(board[i][j] =='.')
                   continue;
               if(rows.get(i).contains(board[i][j]) ||
               cols.get(j).contains(board[i][j]) ||
               squares[i/3][j/3].contains(board[i][j])){
                    return false;
               }
               else{
                   rows.get(i).add(board[i][j]);
                   cols.get(j).add(board[i][j]);
                   squares[i/3][j/3].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
