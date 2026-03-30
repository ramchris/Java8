package com.company.syncBlock;

public class VolatileExample {

    // ensures visibility, not atomicity
    private volatile int count = 0;
    public void increment(){
        // not atomic (read + modify + write)
        count++;
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        VolatileExample demo = new VolatileExample();
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
        System.out.println("Final count (volatile): " + demo.count);
    }
}