package com.company.ReentrantLockDemo;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantRunner {

    private int count = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public void increment(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }


    /**
     * Runs first as the other thread sleeps for 2seconds.
     * accquires lock and call await() to unlock n hand over lock to other thread(secondRunner())
     * secondRunner gets lock and waits for ENTER and then once pressed, Calls signal() which will notify threads that its unlocked.
     *
     *
     * In case of Deadlock - Use a method to accquire lock by calling tryLock() on the lock object.
     * In finally block make sure we got the lock for both locks (firstLock and secondLock) if not check if(gotFirstLock) then unlock firstLock
     * similarly for secondLock....
     *
     * @throws InterruptedException
     */
    public void firstRunner() throws InterruptedException {
        reentrantLock.lock();
        System.out.println("Waiting ........");
        condition.await();
        System.out.println("Lock accquired/relinquished by Other thread");
        try {
            increment();
        }finally {
            reentrantLock.unlock();
        }

    }


    public void secondRunner() throws InterruptedException {
        Thread.sleep(2000);
        reentrantLock.lock();

        System.out.println("Press ENTER key");
        new Scanner(System.in).nextLine();
        System.out.println("ENTER key pressed");
        condition.signal();
        try {
            increment();
        }finally {
            reentrantLock.unlock();
        }
    }


    public void finished(){

        System.out.println("Final COunt : " +count);
    }
}

