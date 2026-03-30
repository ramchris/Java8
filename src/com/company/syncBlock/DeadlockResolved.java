package com.company.syncBlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockResolved {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task1 = () -> tryAcquireLocks(lock1, lock2, "Thread 1");
        Runnable task2 = () -> tryAcquireLocks(lock2, lock1, "Thread 2");

        new Thread(task1).start();
        new Thread(task2).start();
    }

    public static void tryAcquireLocks(Lock firstLock, Lock secondLock, String name) {
        while (true) {
            boolean gotFirst = firstLock.tryLock();
            boolean gotSecond = false;
            try {
                if (gotFirst) {
                    System.out.println(name + " acquired " + firstLock);
                    // Attempt to get second lock with a 50ms timeout
                    gotSecond = secondLock.tryLock(50, TimeUnit.MILLISECONDS);
                    if (gotSecond) {
                        System.out.println(name + " acquired BOTH locks. Working...");
                        return; // Success!
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Critical: release locks if acquired
                if (gotFirst && !gotSecond) {
                    firstLock.unlock();
                    System.out.println(name + " failed to get second lock, released first. Retrying...");
                } else if (gotFirst && gotSecond) {
                    secondLock.unlock();
                    firstLock.unlock();
                }
            }
            // Small sleep to prevent "livelock" (both threads retrying at the same time)
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
    }
}
