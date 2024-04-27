package com.mycompany.javatreegui;

public class PerformanceData {
    long opTime;
    int nodesTravelled;
    int rotations;
    int preSize;
    int preHeight;

    public PerformanceData(int preSize, int preHeight) {
        opTime = System.nanoTime();
        this.preSize = preSize;
        this.preHeight = preHeight;
        rotations = 0;
    }

    public void updateTime() {
        opTime = System.nanoTime() - opTime;
    }
}
