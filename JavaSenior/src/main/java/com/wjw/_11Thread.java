package com.wjw;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁  ----JDK5.0新增
 *
 * 1.面试题：synchronized与Lock的异同？
 *   相同：二者可以解决线程安全问题
 *   不同:sychronized机制在执行完相同的同步代码以后，自动的释放同步监视器
 *      Lock需要手动的启动同步（Lock（）），同时结束同步也需要手动的实现（unlock（））
 *
 * 2.优先使用顺序：
 * Lock->同步代码块->同步方法
 */
class _11MyThread implements Runnable{
    private static int ticket=100;
    //1.实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //2.调用锁定方法
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"的，票号码是："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.调用解锁方法
                lock.unlock();
            }

           }
    }
}

public class _11Thread {
    public static void main(String[] args) {
        _11MyThread my=new _11MyThread();

        Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);
        Thread t3 = new Thread(my);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}
