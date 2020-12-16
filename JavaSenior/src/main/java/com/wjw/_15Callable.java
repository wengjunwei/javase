package com.wjw;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 *
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 *
 * @author shkstart
 * @create 2019-02-15 下午 6:01
 */

class _15MyCallable implements Callable{
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}


public class _15Callable {
    public static void main(String[] args) {
        _15MyCallable my = new _15MyCallable();

        FutureTask futureTask = new FutureTask(my);
        new Thread(futureTask).start();

        try {
            Object o = futureTask.get();
            System.out.println("总数为："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
