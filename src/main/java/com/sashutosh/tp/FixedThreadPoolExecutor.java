package com.sashutosh.tp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class FixedThreadPoolExecutor implements TPExecutorService {
    int poolSize;
    LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    List<Thread> threads = new ArrayList<>();

    public FixedThreadPoolExecutor(int poolSize) {
        this.poolSize=poolSize;
        createThreads(poolSize,queue);
    }

    private void createThreads(int poolSize, LinkedBlockingQueue<Runnable> queue) {
        IntStream.range(0,poolSize).forEach(x -> {
          Thread t=  new ThreadExecutor(queue);
          threads.add(t);
          t.start();
        });
    }

    @Override
    public void submit(Runnable runnable)  {
        queue.add(runnable);
    }

    public static void main(String[] args) throws InterruptedException {
        TPExecutorService fixedThreadPoolExecutor = new FixedThreadPoolExecutor(2);
        fixedThreadPoolExecutor.submit(() -> {
            System.out.println("Running task 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished task 1");
        });

        fixedThreadPoolExecutor.submit(() -> {
            System.out.println("Running task 2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished task 2");
        });

        fixedThreadPoolExecutor.submit(() -> {
            System.out.println("Running task 3");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished task 3");
        });

        Thread.sleep(10000);
    }
}
