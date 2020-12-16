package com.wjw;

/**
 * 卖票 -- 使用实现Runable方法来做
 *
 *
 * 线程安全问题
 *
 * 方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码块
 *      }
 * 说明：1、操作共享数据的代码，即为需要被同步的代码
 *      2、共享数控：多个线程共同操作的变量。
 *      3、同步监视器，俗称：锁。任何一个类的对象，都可以充当锁
 *          要求：多个线程必须要共用同一把锁(重点)
 *
 *
 * 方式二：同步方法
 */
public class _06WindowTest_Runable {
    public static void main(String[] args) {
        ImRunable imRunable=new ImRunable();
        Thread t1=new Thread(imRunable);
        Thread t2=new Thread(imRunable);
        Thread t3=new Thread(imRunable);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class ImRunable implements Runnable{
    private int ticket=100;
//    Object obj=new Object();
    @Override
    public void run() {
        while(true){
            synchronized(this){
                if (ticket>0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"：买票，票号为:"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

