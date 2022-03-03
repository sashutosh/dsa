package com.sashutosh.tp;

import com.sashutosh.tp.FixedThreadPoolExecutor;
import com.sashutosh.tp.TPExecutorService;

public class Executors {
    public static TPExecutorService newFixedThreadPoolExecutor(int poolSize) {
        return new FixedThreadPoolExecutor(poolSize);
    }
}
