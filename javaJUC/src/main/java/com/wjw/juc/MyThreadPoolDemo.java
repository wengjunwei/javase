package com.wjw.juc;

import java.util.concurrent.*;

/**
 * Created on 2021/1/14 0014
 *
 * @author weng
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

//        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
        2,
        5,
        2L,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(3),
//        new ThreadPoolExecutor.AbortPolicy());
//        new ThreadPoolExecutor.CallerRunsPolicy());
//        new ThreadPoolExecutor.DiscardOldestPolicy());
        new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 0; i < 10; i++) {
//                TimeUnit.SECONDS.sleep(1);
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    private static void initDemo() {
        //        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
