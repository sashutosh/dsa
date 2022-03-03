package com.sashutosh.logger;

public class Process implements Comparable{

    long startTime;
    long endTime;
    String processId;

    public Process(String processId,long startTime) {
        this.startTime = startTime;
        this.processId = processId;
        this.endTime = -1;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Object o) {
        Process other =(Process) o;
        return (int) (this.startTime-other.endTime);
    }
}
