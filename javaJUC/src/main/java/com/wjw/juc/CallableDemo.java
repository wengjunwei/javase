package com.wjw.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2021/1/13 0013
 *
 * @author weng
 */

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("w shi callable inteface");
        TimeUnit.SECONDS.sleep(4);
        return 1022;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        System.out.println("main"+Thread.currentThread().getName()+"***计算完成");

        System.out.println(futureTask.get());
    }

}
