package com.wjw;

/**
 * 卖票 -- 使用实现Runable方法来做
 *
 *
 * 线程安全问题
 *

 * 方式二：同步方法
 */
public class _08WindowTest_Runable2 {
    public static void main(String[] args) {
        ImRunable1 imRunable=new ImRunable1();
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

class ImRunable1 implements Runnable{
    private int ticket=100;
//    Object obj=new Object();
    @Override
    public void run() {
        while(true){
            if(ticket==0)
                break;
           show();
        }
    }

    private synchronized void show(){
        if (ticket>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"：买票，票号为:"+ticket);
            ticket--;
        }
    }
}

