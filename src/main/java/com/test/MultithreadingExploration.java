package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MultithreadingExploration {
    public static void main(String[] args)  {
        /*Thread t1 = new Thread(()->{
            System.out.println("Thread1 started");
        });
        t1.start();*/

        Thread t2 = new Thread(()-> {
            new RunnableClass("Thread2 started").run();
        });
        t2.start();

        Counter counter = new Counter();
        Incrementer incrementer = new Incrementer(counter);
        Thread t3 = new Thread(new Incrementer(counter), "Thread 3");
        Thread t4 = new Thread(new Incrementer(counter), "Thread 4");

        System.out.println(t3.isDaemon());

        t3.start();
        t4.start();

        //wait for both threads to finish
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());

        ShardResource shardResource = new ShardResource();

        Thread threadProduce = new Thread(()->{
            shardResource.produceData();
        });

        Thread threadConsume = new Thread(()->{
            shardResource.consumeData();
        });

        threadProduce.start();
        threadConsume.start();
        //threadConsume.run();

        try {
            threadProduce.join();
            threadConsume.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(1, 6).forEach((i)->executorService.submit(new Task(i)));
        executorService.shutdown();
    }


}

class RunnableClass implements Runnable{
    @Override
    public void run() {
        System.out.println(message + " ~~~ ");
    }

    public RunnableClass(String message) {
        this.message = message;
    }
    private String message;
}

class Counter{
    private int count = 0;

    public void increment(){
        synchronized (this){
            count++;
        }

        System.out.println(Thread.currentThread().getName() +" incremented to " + count);
    }

    public int getCount(){
        return count;
    }
}

class Incrementer implements Runnable{

    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            counter.increment();
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ShardResource{
    private boolean dataReady = false;

    public void produceData(){
        System.out.println("Data producer is generating data....");

        synchronized (this){
            try {
                Thread.sleep(6000);
                dataReady = true;
                System.out.println("Data Ready...");
                //notify waiting threads
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
    public void consumeData(){
        if(!dataReady){
            System.out.println("Consumer is waiting for data");
            synchronized (this){

                try {
                    while(!dataReady){
                        wait();
                    }
                    System.out.println("Waiting completed.... Go for consume...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println("Data consumed.");
    }
}

class Task implements Runnable{
    int taskId;
    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is executed by thread " + Thread.currentThread().getName());
    }
}
