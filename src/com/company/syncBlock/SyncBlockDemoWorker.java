package com.company.syncBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SyncBlockDemoWorker {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private Random random = new Random();
    private List<Integer> iList1 = new ArrayList<>();

    private List<Integer> iList2 = new ArrayList<>();

    public void processListOne(){

    synchronized (lock1){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        iList1.add(random.nextInt(100));
        }
    }


    public void processListTwo(){

        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            iList2.add(random.nextInt(100));
        }

    }

    public void processMethod(){
        for (int i = 0; i <1000 ; i++) {
            processListOne();
            processListTwo();
        }
    }

    public void mainMethod(){
        System.out.println("Hello");
        Long start = System.currentTimeMillis();
        //processMethod();
        Thread thread1 = new Thread(() -> {
           processMethod();
        });


        Thread thread2 = new Thread(() -> processMethod());
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();


        System.out.println("Time Taken : " +(end - start));
        System.out.println("List 1 Size : " +iList1.size()+ "   List 2 Size : " +iList2.size());
    }
}
