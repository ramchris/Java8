package com.company.syncBlock;

//this causes deadlock
public class DeadlockExample {
    public static final Object LOCK_A = new Object();
    public static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        // Thread 1 locks A then B
        new Thread(() -> {
            synchronized (LOCK_A) {
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (LOCK_B) { System.out.println("T1 finished"); }
            }
        }).start();

        // Thread 2 locks B then A
        new Thread(() -> {
            synchronized (LOCK_B) {
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (LOCK_A) { System.out.println("T2 finished"); }
            }
        }).start();
    }
}

