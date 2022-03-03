package com.sashutosh.logger;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class LogClientImpl implements LogClient{

    Map<String,Process> processMap = new ConcurrentHashMap<>();
    Queue<Process> processQueue = new PriorityQueue<>();
    Queue<Process> completedQueue = new LinkedBlockingQueue<>();

    public LogClientImpl() {
    }

    @Override
    public void start(String processId, long timestamp) {
        Process p= new Process(processId,timestamp);
        processMap.put(processId,p );
        processQueue.add(p);
    }

    @Override
    public void end(String processId) {
        Process process = processMap.get(processId);
        process.setEndTime(System.currentTimeMillis());
    }

    @Override
    public String poll() {
        return null;
    }
}
