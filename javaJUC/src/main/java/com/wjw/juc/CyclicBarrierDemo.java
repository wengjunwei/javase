package com.wjw.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created on 2021/1/13 0013
 *和countDownLatch的区别就是一个加一个减
 * @author weng
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        Runnable barrierAction;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("*********召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            final int ii=i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t收集到第："+ii+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
