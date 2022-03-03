package com.sashutosh;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
    public static void main(String[] args) {
       /* LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts
        System.out.println(lRUCache.get(1));*/

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(1, 1); // cache is {1=1, 2=2}
        //System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(2, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));    // returns -1 (not found)
        System.out.println(lRUCache.get(2));    // returns -1 (not found)



    }

    static class Cache implements Comparable{
        int key;
        int value;
        long timestamp;

        public Cache(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Cache(int key, int value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Object o) {
            Cache that = (Cache) o;
            return (int) (this.timestamp- that.timestamp);

        }
    }

    Map<Integer,Cache> map = new ConcurrentHashMap<>();
    Queue<Cache> queue = new PriorityQueue<>();

    int capacity;
    int current=0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.current =0;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        else {

            Cache cache = map.get(key);
            queue.remove(cache);
            cache.timestamp = System.currentTimeMillis();
            queue.add(cache);
            return cache.value;
        }
    }

    public void put(int key, int value) {
        if(map.size() < capacity || map.containsKey(key)) {
            Cache cache= new Cache(key,value,System.currentTimeMillis());
            if(map.containsKey(key)) {
                Cache cur = map.get(key);
                queue.remove(cur);
            }
            map.put(key,cache);
            queue.offer(cache);
        }
        else {
            Cache lu = queue.remove();
            map.remove(lu.key);
            Cache cache= new Cache(key,value,System.currentTimeMillis());
            map.put(key,cache);
            queue.offer(cache);
        }
    }
}
