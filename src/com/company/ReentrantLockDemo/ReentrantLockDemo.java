package com.company.ReentrantLockDemo;

public class ReentrantLockDemo {

    public static void main(String[] args) {

        final ReentrantRunner reentrantRunner = new ReentrantRunner();

        try {
        Thread thread1 = new Thread(() -> {
            try {
                reentrantRunner.firstRunner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                reentrantRunner.secondRunner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();


            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Finally call finished() to know count value
        reentrantRunner.finished();
    }
}
