package com.liepin.qiushi.lucene.core;


import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    public static int a = 0;

    public synchronized static void inc(){
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
        Thread.sleep(500);
        System.out.println("结果："+Counter.a);
    }

}
