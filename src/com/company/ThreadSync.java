package com.company;

public class ThreadSync {

    public static void main(String[] args) {
        ThreadSync threadSync = new ThreadSync();
        threadSync.doSomeWork();
    }

    public int count = 0;
    public synchronized void increment(){  count++; }
    public void  doSomeWork() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                increment();
            }
        });
        thread1.start();
        thread2.start();
        //Call Join to make sure it's not concurrently adding
        try {  thread1.join();  thread2.join(); } catch (InterruptedException e) {    e.printStackTrace(); }
        System.out.println("Count : " +count);
    }
}
