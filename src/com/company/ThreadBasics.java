package com.company;

class Demo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("Demo Thread : " +i);
        }
    }
}

class RunnableDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Demo Runnable Thread : " +i);
        }
    }
}

public class ThreadBasics {

    private volatile int count = 0;

    private synchronized void increment(){
        count++;
    }
    public void doSomeWork(){

        Thread t1 = new Thread(() -> {
            for (int i = 0; i <10000 ; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i <10000 ; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count : " +count);

    }


    public static void main(String[] args) {

        Demo myDemo = new Demo();
        myDemo.start();

        Thread thread1 = new Thread(new RunnableDemo());
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                System.out.println("Main Thread :" +i);
            }
        });
        thread2.start();

        ThreadBasics threadBasics = new ThreadBasics();
        threadBasics.doSomeWork();
    }
}
