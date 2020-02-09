package com.fight.concurrent;

public class A1WaitDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A1WaitDemo.class) {
                    System.out.println(Thread.currentThread().getName() + "go in");
                    try {
                        // wait等待到期跟notify效果一样，到期之后只是结束阻塞，还需要再次拿到监听器锁monitorObject才能继续执行
                        A1WaitDemo.class.wait(7000);
                        System.out.println(Thread.currentThread().getName() + "quit wait.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "go out");
                }
            }
        }, "thread1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A1WaitDemo.class) {
                    System.out.println(Thread.currentThread().getName() + "go in");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "go out");
                }
            }
        }, "thread2");

        t1.start();
        Thread.sleep(100);
        t2.start();
    }
}
