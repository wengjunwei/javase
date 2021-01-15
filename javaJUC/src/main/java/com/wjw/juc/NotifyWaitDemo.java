package com.wjw.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{

    public int number=0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException{
        lock.lock();
        try {
            //1、判断
            while(number != 0){
             condition.await();   //this.wait();
            }
            //2、干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知
            condition.signalAll(); //this.notifyAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException{
        lock.lock();
        try {
            //1、判断
            while(number == 0){
                condition.await();   //this.wait();
            }
            //2、干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知
            condition.signalAll(); //this.notifyAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

//    public synchronized void increment() throws InterruptedException {
//        //1.判断
//        while (number!=0) {
//            this.wait();
//        }
//
//        //2.干活
//        ++number;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//
//        //3.通知
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        //1.判断
//        while (number!=1) {
//            this.wait();
//        }
//
//        //2.干活
//        --number;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//
//        //3.通知
//        this.notifyAll();
//    }


}

/**
 *
 * @Description:
 *现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮。
 * @author xialei
 *
 *  * 笔记：Java里面如何进行工程级别的多线程编写
 * 1 多线程变成模板（套路）-----上
 *     1.1  线程    操作    资源类
 *     1.2  高内聚  低耦合
 * 2 多线程变成模板（套路）-----下
 *     2.1  判断
 *     2.2  干活
 *     2.3  通知
 * 3 多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只用while，不能用id）
 * 4 标志位
 */
public class NotifyWaitDemo {

    public static void main(String[] args) {
        Resource resource = new Resource();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(200);
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(200);
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    resource.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    resource.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}

