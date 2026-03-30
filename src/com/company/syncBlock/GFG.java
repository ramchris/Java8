package com.company.syncBlock;

public class GFG{
    private int count = 0;
    public synchronized void increment(){
        // atomic due to synchronization
        count++;
    }

    public int getCount() { return count; }
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

        System.out.println("Final count (synchronized): " + demo.getCount());
    }
}
