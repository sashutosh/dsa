package com.sashutosh.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordSearch {

    public static void main(String[] args) {
        char[][] matrix =  {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        WordSearch ws = new WordSearch();
        boolean exist = ws.exist(matrix, word);
        System.out.println(exist);
    }

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x =x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean exist(char[][] board, String word) {
        Set<Pos> visited = new HashSet<>();

        int maxX = board.length;
        int maxY = board[0].length;

        String current ="";
        int curPos =0;
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(0,0));
        while(queue.size()!=0){
            Pos cur = queue.remove();
            if(!isVisited(cur, visited) && board[cur.x][cur.y] ==word.charAt(curPos)){
                curPos++;
                current = current + board[cur.x][cur.y];
                if(current.equals(word)) {
                    return true;
                }
            }
            visited.add(cur);
            for(Pos neighbor: getNeighbors(cur,maxX,maxY)) {
                if(!isVisited(neighbor,visited))
                    queue.add(neighbor);
            }

        }
        return false;
    }

    private boolean isVisited(Pos cur, Set<Pos> visited) {
        return visited.contains(cur);
    }

    private List<Pos> getNeighbors(Pos cur, int maxX, int maxY) {
        List<Pos> neighbors = new ArrayList<>();
        if(cur.y-1 > -1) {
            Pos left = new Pos(cur.x, cur.y-1);
            neighbors.add(left);
        }
        if(cur.y+1 <maxY) {
            Pos right = new Pos(cur.x, cur.y+1);
            neighbors.add(right);
        }

        if(cur.x-1 > -1) {
            Pos top = new Pos(cur.x-1, cur.y);
            neighbors.add(top);
        }

        if(cur.x+1 < maxX) {
            Pos bottom = new Pos(cur.x+1, cur.y);
            neighbors.add(bottom);
        }

        return neighbors;
    }
}
