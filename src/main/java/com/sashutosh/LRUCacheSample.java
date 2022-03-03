package com.sashutosh;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheSample {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(1, 1); // cache is {1=1, 2=2}

        System.out.println(lRUCache.get(1));    // return 1

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)

    }

    static class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        CacheNode head;
        CacheNode tail;
        int curSize = 0;

        Map<Integer, CacheNode> map = new HashMap<>();
        int cacheSize;

        public LRUCache(int size) {
            this.cacheSize = size;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                CacheNode cacheNode = map.get(key);
                removeNode(cacheNode);
                addNode(cacheNode);
                return cacheNode.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                CacheNode node = map.get(key);
                removeNode(node);
                addNode(node);
            } else {
                if (map.size() == cacheSize) {
                    map.remove(head.key);
                    removeNode(head);
                }
                CacheNode node = new CacheNode(key, value);
                addNode(node);
                map.put(key, node);
            }
        }

        private void addNode(CacheNode node) {
            if(tail!=null){
                tail.next = node;
            }

            node.prev = tail;
            node.next = null;
            tail = node;

            if(head == null){
                head = tail;
            }
        }

        private void removeNode(CacheNode node) {
            if(node.prev!=null){
                node.prev.next = node.next;
            }else{
                head = node.next;
            }

            if(node.next!=null){
                node.next.prev = node.prev;
            }else{
                tail = node.prev;
            }
        }
    }

}
