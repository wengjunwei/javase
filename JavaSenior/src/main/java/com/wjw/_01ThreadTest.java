package com.wjw;


class MyThread12 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){

                System.out.println(i);
            }
        }
    }
}


public class _01ThreadTest {
    public static void main(String[] args) {
        MyThread12 my=new MyThread12();
        my.start();

        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(i+"------------------main---------------");
            }

        }

    }
}
