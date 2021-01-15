package com.wjw.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created on 2021/1/13 0013
 *
 * 闭锁
 *
 * @author weng
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

       CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t班长关门");
    }

    private static void closeDoor() {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
            },String.valueOf(i)).start();
        }

        System.out.println(Thread.currentThread().getName()+"\t班长关门");
    }
}
