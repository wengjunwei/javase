package com.wjw.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2020/12/27 0027
 * 三个售票员 卖30张票
 * <p>
 * 固定的编程套路+模板
 * 在高内聚低耦合的情况下 线程 操作 资源类
 * @author weng
 */

class Ticket{ //资源类

    private int number=30;

    private Lock lock = new ReentrantLock();

    public void saleTicket(){

        lock.lock();
        try {
            if (number>0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第"+(number--)+"\t还剩下"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}

public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() ->{for (int i = 0; i < 40; i++) ticket.saleTicket(); },"A").start();
        new Thread(() ->{for (int i = 0; i < 40; i++) ticket.saleTicket(); },"B").start();
        new Thread(() ->{for (int i = 0; i < 40; i++) ticket.saleTicket(); },"C").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"C").start();
    }
}
