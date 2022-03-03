package com.sashutosh.graph;

import java.util.*;

public class Traversal {

    public static void bfs(Map<String, List<String>> al, String startNode) {
        Queue<String > queue = new ArrayDeque<>();
        queue.add(startNode);
        while (!queue.isEmpty()){
            String res = queue.remove();
            System.out.println(res);

            List<String> neighbors = al.get(res);
            neighbors.forEach(item -> queue.add(item));
        }

    }
    public static void dfs(Map<String, List<String>> al, String startNode) {
        Stack<String> stack = new Stack<>();
        stack.push(startNode);
        while (!stack.empty()) {
            String cur = stack.pop();
            List<String> strings = al.get(cur);
            strings.forEach(x -> stack.push(x));
            System.out.println(cur);
        }

    }

    public static void dfs_rec(Map<String,List<String>> al, String startNode) {
        System.out.println(startNode);
        List<String> strings = al.get(startNode);
        if(strings ==null || strings.isEmpty()) {
            return;
        }
        for (String str:strings) {
            dfs_rec(al,str);
        }
    }
    public static boolean hasPath(Map<String,List<String>> al, String startNode, String endNode) {
        if(startNode.equals(endNode))
            return true;
        List<String> neighbors = al.get(startNode);
        for (String neighbor:neighbors) {
            if(hasPath(al,neighbor,endNode)==true)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Map<String,List<String>> al = new HashMap<>();
        al.put("a", Arrays.asList("b","c"));
        al.put("b", Arrays.asList("d"));
        al.put("c", Arrays.asList("e"));

        al.put("d", Arrays.asList("f"));
        al.put("e", new ArrayList<>());
        al.put("f", new ArrayList<>());

        Map<String,List<String>> al1 = new HashMap<>();
        al1.put("f", Arrays.asList("g","i"));
        al1.put("g", Arrays.asList("h"));
        al1.put("h", new ArrayList<>());

        al1.put("i", Arrays.asList("g","k"));
        al1.put("j", Arrays.asList("i"));
        al1.put("k", new ArrayList<>());


        //dfs(al,"a");
        //dfs_rec(al,"a");
        //bfs(al,"a");
        System.out.println(hasPath(al1,"f","k"));

    }
}
