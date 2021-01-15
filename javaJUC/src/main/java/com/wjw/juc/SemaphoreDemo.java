package com.wjw.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2021/1/13 0013
 *
 * @author weng
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢占到车位");
                    //暂停线程一会
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();

        }

    }
}
