package com.wjw;

/**
 * 卖票 -- 使用继承Thread
 */
class Window extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run() {
        while(true){
            synchronized (Window.class){
                if (ticket>0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"：买票，票号为:"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}


public class _04WindowTest {
    public static void main(String[] args) {
        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}
