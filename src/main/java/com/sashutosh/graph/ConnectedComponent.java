package com.sashutosh.graph;

import java.util.*;

public class ConnectedComponent {
    private static int connected(Map<Integer, List<Integer>> al) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> cur : al.entrySet()) {
            if (!visited.contains(cur.getKey())) {
                //visited.add(cur.getKey());
                dfs(al, cur.getKey(), visited);
                count++;
            }

        }
        return count;
    }
    private static int connectedCount(Map<Integer, List<Integer>> al) {
        Set<Integer> visited = new HashSet<>();
        int max_count = 0;
        for (Map.Entry<Integer, List<Integer>> cur : al.entrySet()) {
            if (!visited.contains(cur.getKey())) {
                int count =dfs_count(al, cur.getKey(), visited);
                if(count > max_count)
                    max_count=count;
            }

        }
        return max_count;
    }

    private static int dfs_count(Map<Integer, List<Integer>> al, Integer key, Set<Integer> visited) {
        if(visited.contains(key))
            return 0;
        visited.add(key);
        int count=1;
        for (Integer neighbor: al.get(key)) {
            count = count +dfs_count(al,neighbor,visited);
        }
        return count;
    }

    private static void dfs(Map<Integer, List<Integer>> al, Integer start, Set<Integer> visited) {

        visited.add(start);
        List<Integer> neighbors = al.get(start);
        for (Integer neighbor : neighbors) {
            if(!visited.contains(neighbor))
                dfs(al, neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> al = new HashMap<>();
        al.put(1, Arrays.asList(2));
        al.put(2, Arrays.asList(1));
        al.put(3, new ArrayList<>());
        al.put(4, Arrays.asList(6));
        al.put(5, Arrays.asList(6));
        al.put(6, Arrays.asList(5, 6, 7, 8));
        al.put(7, Arrays.asList(6));
        al.put(8, Arrays.asList(6));

        System.out.println(connected(al));
        //System.out.println(connectedCount(al));
    }
}
