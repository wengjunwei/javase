package com.wjw;

/**
 * 方式二：同步方法
 */
class Window1 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run() {
        while(true){
            if(ticket==0){
                break;
            }
            show();
        }
    }
    private static synchronized void show(){
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


public class _07WindowTest2 {
    public static void main(String[] args) {
        Window1 w1=new Window1();
        Window1 w2=new Window1();
        Window1 w3=new Window1();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}
