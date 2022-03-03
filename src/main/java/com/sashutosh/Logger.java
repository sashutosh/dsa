package com.sashutosh;
/*
interface Logger {
    public void start(String id, long starttime);
    public void end(String id, long endtime);
    void poll();
}
*/
/*
    Logger l = new loggerimpl();

        l.start(3, 7);
        l.start(2, 8);
        l.start(1, 12);

        //l.poll()
        l.end(1, 15)
        l.end(2, 12)
        l.start(3, 19);


*/

import com.sashutosh.tp.FixedThreadPoolExecutor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

interface Logger {
    public void start(String id, long starttime);
    public void end(String id, long endtime);
    void poll();
}


/**
 * When a process starts, it calls 'start' with processId.
 */
        /*void start(String processId, long timestamp);

        *//**
         * When the same process ends, it calls 'end' with processId.
         *//*
        void end(String processId);

        *//**
         * Polls the first log entry of a completed process sorted by the start time of processes in the below format
         * {processId} started at {startTime} and ended at {endTime}
         * <p>
         * process id = 1 --> 12, 15
         * process id = 2 --> 8, 12
         * process id = 3 --> 7, 19
         * <p>
         * {3} started at {7} and ended at {19}
         * {2} started at {8} and ended at {12}
         * {1} started at {12} and ended at {15}
         *//*
        void poll();
*/

 class Process implements Comparable  {
    String id;
    long startTime;
    long endTime;

    public Process(String id, long startTime) {
        this.id = id;
        this.startTime = startTime;
    }


    @Override
    public int compareTo(Object o) {
        Process p = (Process)o;
        return (int) (this.startTime -p.startTime);
    }
}

class LoggerImpl implements Logger {
     int pollCounter;
     Map<String,Process> running = new ConcurrentHashMap<>();
     Queue<Process> completed = new PriorityQueue<>();

     FixedThreadPoolExecutor threadPoolExecutor = new FixedThreadPoolExecutor(10);

    public void start(String id, long starttime) {

        threadPoolExecutor.submit(() ->{
            running.put(id,new Process(id, starttime));
            //running.add(new Process(id,starttime));
        });

    }

    public void end(String id, long endtime) {
        Process process = running.get(id);
        completed.add(process);
        running.remove(id);
        if(pollCounter > 0) {
            poll();
        }

    }



    public void poll() {

        if(completed.size() ==0) {
            pollCounter++;
            return;
        }
        else {
            Process process = completed.remove();
            System.out.println(process);

        }
    }

    public static void main(String[] args) {
        LoggerImpl logger = new LoggerImpl();
        logger.start("1",10);
        logger.start("2",12);
        logger.start("3",15);
        logger.end("2",15);

        logger.poll();
        logger.end("3",19);
        logger.poll();

    }


}
