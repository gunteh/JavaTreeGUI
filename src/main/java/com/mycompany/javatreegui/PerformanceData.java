// PerformanceData Documentation:
//  Attributes:
//      opTime: Time the operation that returned this object took to complete in nanoseconds
//      nodesTravelled: How many nodes the operation had to search before completing the operation, counting root
//      rotations: Amount of rotations needed for AVL operation, can be 0, 1, or 2. Always 0 for BST operations
//      preSize: Size of tree before operation. Probably won't be used
//      preHeight: Height of tree before operation. Probably won't be used
//      success: Whether operation was successful or not. Replaces original boolean output of operations
//  Methods:
//      PerformanceData: Initialization function, you will usually enter tree.size and tree.root.height
//      updateTime: Call at the end of an operation to subtract start time from current time to give total time.

package com.mycompany.javatreegui;

public class PerformanceData {
    long opTime;
    int nodesTravelled;
    int rotations;
    int preSize;
    int preHeight;
    boolean success;

    public PerformanceData(int preSize, int preHeight) {
        opTime = System.nanoTime();
        this.preSize = preSize;
        this.preHeight = preHeight;
        rotations = 0;
        success = false;
    }

    public void updateTime() {
        opTime = System.nanoTime() - opTime;
    }
}
