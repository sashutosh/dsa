package com.sashutosh.graph;

import java.util.*;
import java.util.stream.*;

public class TopologicalSort {
    public static void main(String[] args) {
        List<Integer> jobs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer[]> deps = Arrays.asList(new Integer[]{3, 1},
                new Integer[]{8, 1},
                new Integer[]{8, 7},
                new Integer[]{5, 7},
                new Integer[]{5, 2},
                new Integer[]{1, 4},
                new Integer[]{6, 7},
                new Integer[]{1, 2},
                new Integer[]{7, 6});
        List<Integer> integers = TopologicalSort.topologicalSort(jobs, deps);
        System.out.println(integers);
    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.
        Map<Integer,List<Integer>> al = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> resultSet;
        populate_al(jobs,deps,al);
        getInitial(al,result);
        if(result.size()==0)
            return new ArrayList<Integer>();
        resultSet =  new HashSet<>(result);
        System.out.println(result);
        cleanCompleted(al,result);
        while(result.size() < jobs.size()) {
            boolean added =false;
            for(Map.Entry<Integer, List<Integer>> entry : al.entrySet()){
                int job = entry.getKey();

                List<Integer> curdeps = entry.getValue();
                if(curdeps.size() > 0 && !resultSet.contains(job)) {
                    if(depsCompleted(new HashSet<Integer>(result),curdeps)){
                        added =true;
                        result.add(job);
                        resultSet.add(job);
                    }
                }
            }
            if(added ==false)
                return new ArrayList<Integer>();
            else{
                added=false;
                cleanCompleted(al,result);
            }
        }
        //System.out.println(deps);

        return result.stream().collect(Collectors.toList());
    }

    private static void cleanCompleted(Map<Integer, List<Integer>> al, List<Integer> result) {
        result.stream().forEach(x -> al.remove(x));
    }

    private static boolean depsCompleted(Set<Integer> results, List<Integer> deps) {
        for(Integer cur:deps) {
            if(!results.contains(cur))
                return false;
        }
        return true;
    }

    private static void getInitial(Map<Integer,List<Integer>> al, List<Integer> result){
        for(Map.Entry<Integer, List<Integer>> entry : al.entrySet()) {
            List<Integer> deps = entry.getValue();
            if(deps.size()==0) {
                result.add(entry.getKey());
            }
        }
    }
    private static void populate_al(List<Integer> jobs, List<Integer[]> deps,Map<Integer,List<Integer>> al){
        for(Integer job: jobs) {
            al.put(job, new ArrayList<>());
            for(Integer[] dep:deps) {
                if(dep[1] == job) {
                    List<Integer> current = al.get(job);
                    current.add(dep[0]);
                }

            }
        }
    }

}
