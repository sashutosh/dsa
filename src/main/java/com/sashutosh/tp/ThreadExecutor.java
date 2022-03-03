package com.sashutosh.tp;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadExecutor extends Thread{

    LinkedBlockingQueue<Runnable> runningQueue;


    public ThreadExecutor(LinkedBlockingQueue<Runnable> runningQueue) {
        this.runningQueue = runningQueue;
    }


    @Override
    public void run() {
        while(true) {
            Runnable task = null;
            try {
                task = runningQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if(task!=null)
                    task.run();
            } catch (Exception e) {
                System.out.printf("Found exception while running task");
            }
            runningQueue.remove(task);
        }
    }
}
