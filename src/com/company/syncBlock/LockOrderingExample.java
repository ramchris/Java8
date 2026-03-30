package com.company.syncBlock;

public class LockOrderingExample {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        // Task 1: Wants A then B
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1: Got Lock A");
                try { Thread.sleep(50); } catch (InterruptedException e) {}

                synchronized (lockB) {
                    System.out.println("Thread 1: Got Lock B - Success!");
                }
            }
        }).start();

        // Task 2: ALSO wants A then B (Even if it needs B more!)
        new Thread(() -> {
            synchronized (lockA) { // Changed from lockB to lockA
                System.out.println("Thread 2: Got Lock A");
                try { Thread.sleep(50); } catch (InterruptedException e) {}

                synchronized (lockB) {
                    System.out.println("Thread 2: Got Lock B - Success!");
                }
            }
        }).start();
    }
}
