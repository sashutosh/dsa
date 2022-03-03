package com.sashutosh.graph;

import java.util.*;

public class ShortestPath {
    private static class Pair{
        String node;
        int dist;

        public Pair(String node, int dist) {
            this.node =node;
            this.dist = dist;
        }
    }
    public static int shortestPath(Map<String, List<String>> al, String start, String end) {
        int count=0;
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(start,count));
        while(!queue.isEmpty()) {
            Pair current = queue.remove();
            visited.add(current.node);
            if(current.node.equals(end))
                return current.dist;
            for (String neighbor: al.get(current.node)) {
                if(!visited.contains(neighbor)) {
                    Pair pair = new Pair(neighbor, current.dist + 1);
                    queue.add(pair);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<String,List<String>> al = new HashMap<>();
        al.put("w", Arrays.asList("x","v"));
        al.put("x", Arrays.asList("w","y"));
        al.put("v", Arrays.asList("w","z"));
        al.put("y", Arrays.asList("x","z"));
        al.put("z", Arrays.asList("y","v"));
        System.out.println(shortestPath(al,"w","z"));
    }

}
