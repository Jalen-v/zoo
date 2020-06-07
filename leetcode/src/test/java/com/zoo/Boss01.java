package com.zoo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Boss01 {
    public static void main(String[] args) {
        final CountDownLatch[] countDownLatch0 = {new CountDownLatch(1)};
        final CountDownLatch countDownLatch1 = new CountDownLatch(2);
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                countDownLatch0[0] = new CountDownLatch(1);
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long t0 = System.currentTimeMillis();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                long t1 = System.currentTimeMillis();
                char ch = 'a';
                while(ch <= 'z') {
                    System.out.println(ch++);
                    countDownLatch0[0].countDown();
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-a cost: " + (System.currentTimeMillis()-t1) + "ms");
                countDownLatch1.countDown();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                long t1 = System.currentTimeMillis();
                char ch = 'A';
                while(ch <= 'Z') {
                    try {
                        countDownLatch0[0].await();
                        System.out.println(ch++);
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-A cost: " + (System.currentTimeMillis()-t1) + "ms");
                countDownLatch1.countDown();
            }
        });

        try {
            countDownLatch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total cost: " + (System.currentTimeMillis()-t0) + "ms");
        executorService.shutdown();
    }
}
