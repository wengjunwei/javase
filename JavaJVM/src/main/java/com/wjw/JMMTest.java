package com.wjw;

/**
 * Created on 2021/1/1 0001
 *
 * @author weng
 */

class Test{
   public volatile int a = 10;  //加入volatile之后是线程共享数据，可见性

    public void changeValue(){
        this.a=1024;
    }
}
public class JMMTest {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("start------");

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.changeValue();
        }).start();

        System.out.println(test.a+"--------");
        while (test.a == 10){
            //如果值 改变就会结束
        }

        System.out.println("end --------");

        System.out.println(test.a);


    }
}
