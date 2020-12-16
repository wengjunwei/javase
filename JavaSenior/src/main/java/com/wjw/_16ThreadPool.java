package com.wjw;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程第四种方式：使用线程池
 *
 * 好处：
 *  * 1.提高响应速度（减少了创建新线程的时间）
 *  * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *  * 3.便于线程管理
 *  *      corePoolSize：核心池的大小
 *  *      maximumPoolSize：最大线程数
 *  *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *  *
 *  *
 *  * 面试题：创建多线程有几种方式？四种！
 */
class _16MyThread implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class _16ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        System.out.println(executorService.getClass());

        ThreadPoolExecutor t= (ThreadPoolExecutor) executorService;
//        t.setCorePoolSize(10);

        executorService.execute(new _16MyThread());//适合适用于Runnable

//        executorService.submit();//适合使用于Callable

        executorService.shutdown();
    }
}
