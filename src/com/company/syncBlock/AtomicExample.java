package com.company.syncBlock;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private AtomicInteger count = new AtomicInteger(0);
    public void increment()
    {
        count.incrementAndGet(); // atomic, lock-free
        // increment
    }
    public int getCount() { return count.get(); }
    public static void main(String[] args)
            throws InterruptedException
    {
        GFG demo = new GFG();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                demo.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                demo.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count (AtomicInteger): " + demo.getCount());
    }
}
