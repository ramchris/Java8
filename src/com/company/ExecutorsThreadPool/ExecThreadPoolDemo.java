package com.company.ExecutorsThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class DemoWorker implements Runnable{

    private int id;

    public DemoWorker(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Worker Thread Starting" +id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Worker Thread Ending/Completed" +id);

    }
}
public class ExecThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            executorService.submit(new DemoWorker(i));
        }
        executorService.shutdown();
        System.out.println("All task submitted");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All task Completed");
    }
}
