package com.wjw.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created on 2021/1/15 0015
 *
 * @author weng
 */

class MyTask extends RecursiveTask<Integer> {

    private static final Integer ADJUST_VALUE=10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end-begin)<=ADJUST_VALUE) {
            for (int i = begin; i <=end ; i++) {
                result+=i;
            }
        }else{
            int middle = (begin+end)/2;
            MyTask myTask01 = new MyTask(begin,middle);
            MyTask myTask02 = new MyTask(middle+1,end);
            myTask01.fork();
            myTask02.fork();
            result=myTask01.join()+myTask02.join();
        }
        return result;
    }
}

/**
 * 分支合并例子
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
    }
}
