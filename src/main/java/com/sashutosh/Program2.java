package com.sashutosh;

import java.util.*;

/*Given an NxN matrix. Each cell has either 0 or 1.
0 - Path is blocked
1 - Path is open

You can move in right and down direction.
Is it possible to reach (N-1, N-1) starting from (0,0).

If yes, how many steps required to reach.

* */
public class Program2 {
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static int traverse(int[][] matrix, int startx, int starty, int endx, int endy ) {
        int count=0;
        Set<Pair> visited = new HashSet<>();
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        Queue<Pair> queue = new ArrayDeque<>();
        Pair start = new Pair(startx,starty);
        queue.add(start);
        while(!queue.isEmpty()) {
            Pair current = queue.remove();
            count++;
            if(isDestination(current, endx,endy)) {
                return count;

            }
            List<Pair>  neighbors = getNeighbors(current,matrix, maxX,maxY);
            for (Pair neighbor: neighbors
                 ) {
                queue.add(neighbor);
            }
        }
        return -1;

    }

    private static List<Pair> getNeighbors(Pair current,int[][] matrix, int maxX, int maxY) {
        List<Pair> res = new ArrayList<>();
        int curx = current.x;
        int cury = current.y;
        //right
        int rightx = curx +1;
        if(rightx < maxX && matrix[rightx][cury]!=0) {
            Pair rpair = new Pair(rightx,cury);
            res.add(rpair);
        }

        //down
        int downy =cury +1;
        if(downy < maxY && matrix[curx][downy]!=0) {
            Pair dpair = new Pair(curx,downy);
            res.add(dpair);
        }
        return res;
    }

    private static boolean isDestination(Pair current, int endx, int endy) {
        return  current.x==endx && current.y ==endy;
    }

}
