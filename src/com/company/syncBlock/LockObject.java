package com.company.syncBlock;

import java.util.concurrent.locks.Lock;

public class LockObject {
    private final Object lock = new Object();
    private int count = 0;

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public static void main(String[] args) {
        LockObject lockObject = new LockObject();
        lockObject.increment();
        System.out.println(lockObject.count);
    }
}
