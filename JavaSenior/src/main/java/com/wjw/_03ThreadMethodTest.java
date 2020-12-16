package com.wjw;

/**
 * yield()  :释放当前cpu的执行权
 * join()   :在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行以后，线程a才结束阻塞状态。
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
//            if (i%20==0){
//                this.yield();
//            }
        }
    }
}

public class _03ThreadMethodTest {
    public static void main(String[] args) {
        MyThread my=new MyThread();
        my.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
            if (i==20) {
                try {
                    my.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }        
    }
}
